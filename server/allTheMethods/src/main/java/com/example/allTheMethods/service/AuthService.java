package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.SignupRequest;
import com.example.allTheMethods.dto.UsersDto;

public interface AuthService {
    UsersDto createUser(SignupRequest signupRequest);
    Boolean hasUserWithUsername(String username);
}
