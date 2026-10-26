package com.example.allTheMethods.dto.response;

public record CategoryStatsResponse(
        String problemType,
        Long countProblemType
) {
}
