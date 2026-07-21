package com.example.allTheMethods.security;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import java.rmi.server.ServerCloneException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Component
public class RateLimiter extends OncePerRequestFilter {
    private static final String LOGIN_URI = "/api/auth/login";
    private static final String REGISTER_URI = "/api/auth/register";
    private static final String SUBMIT_URI = "/api/submissions/**";
    private Cache<String, Bucket> loginCache = Caffeine.newBuilder()
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .maximumSize(1_000_000)
            .build();
    private Cache<String, Bucket> registerCache = Caffeine.newBuilder()
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .maximumSize(1_000_000)
            .build()
    private Bucket loginBucket(){
        Bandwidth bandwidthLimit = Bandwidth.builder()
                .capacity(5)
                .refillIntervally(8, Duration.ofMinutes(1))
                .build();
        return Bucket.builder().addLimit(bandwidthLimit).build();
    }
    private Bucket registerBucket(){
        Bandwidth bandwidthLimit = Bandwidth.builder()
                .capacity(5)
                .refillIntervally(8, Duration.ofMinutes(1))
                .build();
        return Bucket.builder().addLimit(bandwidthLimit).build();
    }

    private boolean tryConsume(Cache<String, Bucket> bucket, String ip, Supplier<Bucket> supplier){
        return bucket.get(ip, s -> supplier.get()).tryConsume(1);
    }

    private String getClientIp(HttpServletRequest request){
        return request.getRemoteAddr();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain webFilterChain) throws ServletException, IOException {
        String clientIp = getClientIp(request);
        String path = request.getRequestURI();
        if(LOGIN_URI.equalsIgnoreCase(path)){
            if(!tryConsume(loginCache,clientIp,this::loginBucket)){
                System.out.println("Too many requests made to login");
                String jsonResponse = """
                        {
                            "status": %s,
                            "error": "Too many requests",
                            "message": "You have exhausted the limit of calls towards the login endpoint",
                            "retryAfterSeconds": %s
                        }
                        """.formatted(HttpStatus.TOO_MANY_REQUESTS.value(), 60);

                response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                response.setContentType("application/json");
                response.getWriter().write(jsonResponse);
                return;
            }
        }
        else if(REGISTER_URI.equalsIgnoreCase(path)){
            if(!tryConsume(registerCache,clientIp,this::registerBucket)){
                System.out.println("Too many requests made to register");
                String jsonResponse = """
                        {
                            "status": %s,
                            "error": "Too many requests",
                            "message": "You have exhausted the limit of calls towards the login endpoint",
                            "retryAfterSeconds": %s
                        }
                        """.formatted(HttpStatus.TOO_MANY_REQUESTS.value(), 60);

                response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                response.setContentType("application/json");
                response.getWriter().write(jsonResponse);
                return;
            }
        }
        webFilterChain.doFilter(request, response);
    }
}
