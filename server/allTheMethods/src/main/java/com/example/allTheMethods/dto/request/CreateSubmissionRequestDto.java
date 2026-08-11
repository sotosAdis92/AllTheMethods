package com.example.allTheMethods.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateSubmissionRequestDto(
        @NotBlank(message = "ID cannot be blank")
        @NotEmpty(message = "ID cannot be empty")
        @NotNull(message = "ID cannot be null")
        Long userId,

        @NotBlank(message = "Problem ID cannot be blank")
        @NotEmpty(message = "Problem ID cannot be empty")
        @NotNull(message = "Problem ID cannot be null")
        Long problemId,

        @NotBlank(message = "Date cannot be blank")
        @NotEmpty(message = "Date cannot be empty")
        @NotNull(message = "Date cannot be null")
        String submittedAt
) {
}
