package com.example.allTheMethods.dto.response;


public record SubmissionResponse(
        Long id,
        String date,
        int number,
        String title,
        String difficulty
) {
}
