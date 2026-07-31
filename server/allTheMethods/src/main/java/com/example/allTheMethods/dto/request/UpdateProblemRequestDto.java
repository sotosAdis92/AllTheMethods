package com.example.allTheMethods.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateProblemRequestDto(
        @NotBlank(message = "")
        int number,

        @NotBlank(message = "")
        String title,

        @NotBlank(message = "")
        String category,

        @NotBlank(message = "")
        String difficulty,

        @NotBlank(message = "")
        String description,

        @NotBlank(message = "")
        int points,

        @NotBlank(message = "")
        String problemString,

        @NotBlank(message = "")
        String problemType,


        @NotBlank(message = "")
        String problemData,

        @NotBlank(message = "")
        String functionString
) {
}
