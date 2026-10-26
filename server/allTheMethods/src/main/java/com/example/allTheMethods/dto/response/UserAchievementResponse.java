package com.example.allTheMethods.dto.response;

import java.time.LocalDateTime;

public record UserAchievementResponse(
        Long id,
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
