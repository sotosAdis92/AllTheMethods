package com.example.allTheMethods.dto.request;

public record SaveUserProblemRequest(
        Long id,
        Long userId,
        Long problemId
) {

}
