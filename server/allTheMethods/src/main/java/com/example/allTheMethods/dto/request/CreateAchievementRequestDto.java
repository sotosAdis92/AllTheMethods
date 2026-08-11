package com.example.allTheMethods.dto.request;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public record CreateAchievementRequestDto(
        @NotEmpty(message = "Name cannot be empty")
        @NotNull(message = "Name cannot be null")
        @NotBlank(message = "Name cannot be blank")
        @Length(max = 510, message = "Name cannot be too long")
        String name,

        @NotEmpty(message = "description cannot be empty")
        @NotNull(message = "description cannot be null")
        @NotBlank(message = "description cannot be blank")
        @Length(max = 510, message = "description cannot be too long")
        String description,

        @NotEmpty(message = "category cannot be empty")
        @NotNull(message = "category cannot be null")
        @NotBlank(message = "category cannot be blank")
        @Length(max = 510, message = "category cannot be too long")
        String category,

        @NotEmpty(message = "rank cannot be empty")
        @NotNull(message = "rank cannot be null")
        @NotBlank(message = "rank cannot be blank")
        @Length(max = 510, message = "rank cannot be too long")
        String rank,

        @NotEmpty(message = "visibility cannot be empty")
        @NotNull(message = "visibility cannot be null")
        @NotBlank(message = "visibility cannot be blank")
        @Length(max = 510, message = "visibility cannot be too long")
        String visibility,

        @NotEmpty(message = "counter cannot be empty")
        @NotNull(message = "counter cannot be null")
        @NotBlank(message = "counter cannot be blank")
        @Min(value = 2, message = "Counter should be>=2")
        @Max(value = 20, message = "Counter should be<=20")
        @Positive(message = "Counter must be a positive")
        int counter

) {
}
