package com.example.allTheMethods.dto.response;

public record SummeryResponseDto(
        int countTotalProblems,
        int countTotalAchievements,
        int countTotalSubmissions,
        float userAcceptanceRate
) {
}
