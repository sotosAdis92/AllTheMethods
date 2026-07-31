package com.example.allTheMethods.dto.response;

import java.time.LocalDateTime;

public record UserAchievementResponseDto(
        Long id,
        Long userId,
        Long achievementId,
        LocalDateTime achievedAt,
        String name,
        String description,
        String category,
        String rank,
        String visibility
) {
}
