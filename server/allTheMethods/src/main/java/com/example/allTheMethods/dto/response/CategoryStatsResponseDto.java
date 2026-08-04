package com.example.allTheMethods.dto.response;

public record CategoryStatsResponseDto(
        String problemType,
        Long countProblemType
) {
}
