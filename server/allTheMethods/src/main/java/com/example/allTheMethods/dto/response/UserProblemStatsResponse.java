package com.example.allTheMethods.dto.response;

public record UserProblemStatsResponse(
    String difficulty,
    Long countDifficulty,
    Long countDistinct
) {
}
