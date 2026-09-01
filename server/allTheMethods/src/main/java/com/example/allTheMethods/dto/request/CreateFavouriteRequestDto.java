package com.example.allTheMethods.dto.request;

import java.util.Date;

public record CreateFavouriteRequestDto(
        Long id,
        Long userId,
        Long problemId,
        Date dateAdded
){
}
