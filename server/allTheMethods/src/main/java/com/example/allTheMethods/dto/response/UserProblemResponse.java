package com.example.allTheMethods.dto.response;

public record UserProblemResponse(
        Long id,
        Long userId,
        Long problemId,
        int number,
        String title,
        String category,
        String difficulty,
        String description,
        int points,
        String problemString,
        String problemType,
        String problemData,
        String functionString
) {
}
