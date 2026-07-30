package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.CreateUserAccountRequest;
import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.dto.response.CreateUserAccountResponse;

public interface AuthService {
    CreateUserAccountResponse createUser(CreateUserAccountRequest createUserAccountRequest);
    Boolean hasUserWithUsername(String username);
}
