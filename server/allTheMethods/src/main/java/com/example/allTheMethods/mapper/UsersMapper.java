package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.request.CreateUserAccountRequest;
import com.example.allTheMethods.dto.response.CreateUserAccountResponse;
import com.example.allTheMethods.entity.Users;

public interface UsersMapper {
    Users toEntity(CreateUserAccountRequest request);
    CreateUserAccountResponse toDto(Users user);

}
