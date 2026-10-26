package com.example.allTheMethods.dto.response;

public record ProblemResponse(
        Long id,
        int number,
        String title,
        String category,
        String difficulty,
        String description,
        int points,
        String problemString,
        String problemType,
        String functionString,
        String problemData
) {
}
