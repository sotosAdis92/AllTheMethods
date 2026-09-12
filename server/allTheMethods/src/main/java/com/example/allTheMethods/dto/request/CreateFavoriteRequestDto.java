package com.example.allTheMethods.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

public record CreateFavoriteRequestDto(
        Long id,
        Long user,
        Long problem,
        @FutureOrPresent(message = "The date that the favorite is added must be after the current date")
        LocalDateTime dateAdded
){
}
