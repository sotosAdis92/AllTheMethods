package com.example.allTheMethods.dto.request;

import java.time.LocalDateTime;

public record CreateUserAchievementRequestDto(
        Long userId,
        Long achievementId,
        LocalDateTime achievedAt,
        String name,
        String description,
        String category,
        String rank,
        String visibility,
        int counter
) {
}
