package com.example.allTheMethods.dto.response;

public record CategoryStatsResponse(
        String difficulty,
        int countDifficulty,
        int countUserId
) {
}
