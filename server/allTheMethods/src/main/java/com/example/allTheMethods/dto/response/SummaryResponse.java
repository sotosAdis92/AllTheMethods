package com.example.allTheMethods.dto.response;

public record SummaryResponse(
        Long countTotalProblems,
        Long countSubmissions,
        Double userAcceptanceRate
) {
}
