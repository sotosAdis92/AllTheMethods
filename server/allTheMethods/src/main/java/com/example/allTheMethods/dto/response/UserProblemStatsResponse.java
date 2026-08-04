package com.example.allTheMethods.dto.response;

public record UserProblemStatsResponse(
        String problemType,
        int countProblemType
) {
}
