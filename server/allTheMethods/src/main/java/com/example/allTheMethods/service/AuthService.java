package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.CreateUserAccountRequest;
import com.example.allTheMethods.dto.response.UserResponse;

public interface AuthService {
    UserResponse createUser(CreateUserAccountRequest createUserAccountRequest);
    Boolean hasUserWithUsername(String username);
}
