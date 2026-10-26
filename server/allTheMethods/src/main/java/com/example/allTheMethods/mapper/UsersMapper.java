package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.request.CreateUserAccountRequest;
import com.example.allTheMethods.dto.request.UpdateUserRequest;
import com.example.allTheMethods.dto.response.UserResponseDto;
import com.example.allTheMethods.entity.Users;
import org.springframework.data.domain.Page;


public interface UsersMapper {
    Users toEntity(CreateUserAccountRequest request);
    UserResponseDto toDto(Users user);
    Users toEntity(UpdateUserRequest requestDto);
    Page<UserResponseDto> toDto(Page<Users> users);
}
