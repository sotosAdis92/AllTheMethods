package com.example.allTheMethods.dto.request;

public record UpdateUserRequest(
        String username,
        String displayName,
        String imageUrl
) {
}
