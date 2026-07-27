package com.example.allTheMethods.dto.request;

public record CreateSubmissionRequestDto(
        Long id,
        Long userId,
        Long problemId,
        String submittedAt
) {
}
