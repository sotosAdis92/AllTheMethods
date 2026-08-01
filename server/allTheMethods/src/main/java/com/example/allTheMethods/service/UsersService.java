package com.example.allTheMethods.service;


import com.example.allTheMethods.dto.response.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService {
    UserDetailsService userDetailsService();
    UserResponseDto getUserName();
}
