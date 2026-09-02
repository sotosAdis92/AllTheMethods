package com.example.allTheMethods.dto.request;

public record SaveUserProblemRequestDto(
        Long id,
        Long userId,
        Long problemId
) {

}
