package com.example.allTheMethods.dto.response;

import jakarta.validation.constraints.NotBlank;

public record ProblemResponseDto(
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
