package com.example.allTheMethods.security;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebCorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
       // registry.addMapping("/api/**").allowedOrigins("*").allowedMethods("GET","POST","PUT","DELETE","OPTIONS");
    }
}
