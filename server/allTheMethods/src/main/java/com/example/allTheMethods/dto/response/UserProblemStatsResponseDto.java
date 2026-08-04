package com.example.allTheMethods.dto.response;

public record UserProblemStatsResponseDto(
    String difficulty,
    Long countDifficulty,
    Long countDistinct
) {
}
