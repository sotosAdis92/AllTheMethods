package com.example.allTheMethods.dto.response;

public record DifficultyStatsResponse(
        String difficulty,
        Long solvedCount
) {
}
