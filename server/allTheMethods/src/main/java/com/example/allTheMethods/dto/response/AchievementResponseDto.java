package com.example.allTheMethods.dto.response;

public record AchievementResponseDto(
    Long id,
    String name,
    String description,
    String category,
    String rank,
    String visibility,
    int counter
) {
}
