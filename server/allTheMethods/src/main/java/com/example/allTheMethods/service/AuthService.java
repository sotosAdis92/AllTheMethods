package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.CreateUserAccountRequest;
import com.example.allTheMethods.dto.response.UserResponseDto;

public interface AuthService {
    UserResponseDto createUser(CreateUserAccountRequest createUserAccountRequest);
    Boolean hasUserWithUsername(String username);
}
