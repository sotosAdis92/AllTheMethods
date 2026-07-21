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

public class RateLimiter extends OncePerRequestFilter {
    private static final String LOGIN_URI = "/api/auth/login";
    private static final String SUBMIT_URI = "/api/submissions/**";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain webFilterChain) throws ServletException, IOException {

    }

}
