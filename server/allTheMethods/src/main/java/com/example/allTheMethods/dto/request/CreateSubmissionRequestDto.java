package com.example.allTheMethods.dto.request;


import jakarta.validation.constraints.NotNull;

public record CreateSubmissionRequestDto(
        @NotNull(message = "ID cannot be null")
        Long userId,

        @NotNull(message = "Problem ID cannot be null")
        Long problemId,

        @NotNull(message = "Date cannot be null")
        String submittedAt
) {
}
