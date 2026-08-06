package com.example.allTheMethods.dto.response;

import com.example.allTheMethods.enums.UserRole;

public record UserResponseDto(
    Long id,
    String username,
    String displayName,
    UserRole userRole
){}
