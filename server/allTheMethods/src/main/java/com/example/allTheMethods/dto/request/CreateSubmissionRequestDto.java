package com.example.allTheMethods.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateSubmissionRequestDto(
        @NotBlank(message = "Number cannot be blank")
        @NotEmpty(message = "Number cannot be empty")
        @NotNull(message = "ID cannot be null")
        Long userId,

        @NotBlank(message = "Number cannot be blank")
        @NotEmpty(message = "Number cannot be empty")
        @NotNull(message = "Problem ID cannot be null")
        Long problemId,

        @NotBlank(message = "Number cannot be blank")
        @NotEmpty(message = "Number cannot be empty")
        @NotNull(message = "Date cannot be null")
        String submittedAt
) {
}
