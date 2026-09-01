package com.example.allTheMethods.dto.response;

import java.time.LocalDateTime;

public record FavouritesResponseDto(
        Long id,
        Long userId,
        Long problemId,
        LocalDateTime dateAdded,
        String title,
        int number,
        String difficulty,
        String category
) {
}
