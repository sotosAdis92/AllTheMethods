package com.example.allTheMethods.dto.request;

import java.time.LocalDateTime;

public record CreateFavoriteRequestDto(
        Long id,
        Long user,
        Long problem,
        LocalDateTime dateAdded
){
}
