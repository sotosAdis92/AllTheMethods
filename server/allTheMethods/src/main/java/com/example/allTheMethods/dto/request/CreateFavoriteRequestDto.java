package com.example.allTheMethods.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

public record CreateFavoriteRequestDto(
        @NotNull(message = "Favorite Id should not be null")
        @Positive(message = "Id of any favorite must be a positive integer")
        Long id,

        @NotEmpty(message = "User that added the favorite cannot be empty")
        Long user,

        @NotEmpty(message = "The problem added by the user cannot be empty")
        Long problem,

        @NotEmpty(message = "The date that the problem was added cannot be empty")
        LocalDateTime dateAdded
){
}
