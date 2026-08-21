package com.example.allTheMethods.dto.response;

public record SummaryResponseDto(
        int countTotalProblems,
        float userAcceptanceRate
) {
}
