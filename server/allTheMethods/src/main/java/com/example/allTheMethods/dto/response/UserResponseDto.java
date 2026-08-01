package com.example.allTheMethods.dto.response;

import com.example.allTheMethods.enus.UserRole;

public record UserResponseDto(
    Long id,
    String username,
    String displayName,
    UserRole userRole
){}
