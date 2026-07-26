package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.UsersDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService {
    UserDetailsService userDetailsService();
    UsersDto getUserName();
}
