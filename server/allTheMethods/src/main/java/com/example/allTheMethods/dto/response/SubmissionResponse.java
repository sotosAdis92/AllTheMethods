package com.example.allTheMethods.dto.response;

import java.time.LocalDateTime;

public record SubmissionResponse(
        Long id,
        String date,
        int number,
        String title,
        String difficulty
) {
}
