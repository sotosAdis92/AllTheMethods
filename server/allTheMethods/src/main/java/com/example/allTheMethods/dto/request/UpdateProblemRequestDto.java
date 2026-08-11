package com.example.allTheMethods.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateProblemRequestDto(
        @NotBlank(message = "Number cannot be empty or null")
        int number,

        @NotBlank(message = "Title cannot be empty or null")
        String title,

        @NotBlank(message = "Category cannot be empty or null")
        String category,

        @NotBlank(message = "Difficulty cannot be empty")
        String difficulty,

        @NotBlank(message = "Description cannot be empty")
        String description,

        @NotBlank(message = "Points cannot be empty")
        int points,

        @NotBlank(message = "Problem String cannot be empty")
        String problemString,

        @NotBlank(message = "Problem Type cannot be empty")
        String problemType,

        @NotBlank(message = "Problem Data cannot be empty")
        String problemData,

        @NotBlank(message = "Function String cannot be empty")
        String functionString
) {
}
