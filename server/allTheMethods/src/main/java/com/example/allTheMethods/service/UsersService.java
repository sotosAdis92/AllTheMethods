package com.example.allTheMethods.service;


import com.example.allTheMethods.dto.response.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService {
    UserDetailsService userDetailsService();
    UserResponseDto getUserName();
    Page<UserResponseDto> getAllUsers(Pageable pageable);
}
