package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService {
    UsersDto getUserName();
}
