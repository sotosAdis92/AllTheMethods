package com.example.allTheMethods.security;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import java.rmi.server.ServerCloneException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class RateLimiter extends OncePerRequestFilter {
    private static final String LOGIN_URI = "/api/auth/login";
    private static final String SUBMIT_URI = "/api/submissions/**";
    private Cache<String, Bucket> loginCache = Caffeine.newBuilder()
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .maximumSize(1_000_000)
            .build();

    private Bucket loginBucket(){
        Bandwidth bandwidthLimit = Bandwidth.builder()
                .capacity(8)
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

    }

}
