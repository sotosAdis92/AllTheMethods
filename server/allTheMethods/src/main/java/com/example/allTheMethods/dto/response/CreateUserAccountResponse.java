package com.example.allTheMethods.dto.response;

import com.example.allTheMethods.enus.UserRole;

public record CreateUserAccountResponse(
        Long id,
        String username,
        String displayName,
        UserRole userRole
) {
}
