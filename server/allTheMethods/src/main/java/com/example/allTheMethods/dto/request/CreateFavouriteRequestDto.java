package com.example.allTheMethods.dto.request;

import java.time.LocalDateTime;

public record CreateFavouriteRequestDto(
        Long id,
        Long userId,
        Long problemId,
        LocalDateTime dateAdded
){
}
