package com.example.allTheMethods.dto.request;

import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.Users;

import java.time.LocalDateTime;

public record CreateFavouriteRequestDto(
        Long id,
        Long user,
        Long problem,
        LocalDateTime dateAdded
){
}
