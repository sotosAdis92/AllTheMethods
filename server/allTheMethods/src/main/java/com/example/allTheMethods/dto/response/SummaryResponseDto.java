package com.example.allTheMethods.dto.response;

public record SummaryResponseDto(
        Long countTotalProblems,
        Long countSubmissions,
        Double userAcceptanceRate
) {
}
