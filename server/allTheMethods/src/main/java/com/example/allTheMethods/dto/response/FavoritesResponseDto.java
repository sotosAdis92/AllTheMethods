package com.example.allTheMethods.dto.response;

public record FavoritesResponseDto(
        Long id,
        Long userId,
        Long problemId,
        String dateAdded,
        String title,
        int number,
        String difficulty,
        String category
) {
}
