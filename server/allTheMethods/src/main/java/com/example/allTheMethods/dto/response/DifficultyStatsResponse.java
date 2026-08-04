package com.example.allTheMethods.dto.response;

public record DifficultyStatsResponse(
        String difficulty,
        int solvedCount
) {
}
