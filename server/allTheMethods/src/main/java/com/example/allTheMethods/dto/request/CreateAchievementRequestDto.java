package com.example.allTheMethods.dto.request;

import jakarta.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
public record CreateAchievementRequestDto(
        @NotBlank(message = "Name cannot be blank")
        @Length(max = 510, message = "Name cannot be too long")
        String name,

        @NotBlank(message = "description cannot be blank")
        @Length(max = 510, message = "Name cannot be too long")
        String description,

        @NotBlank(message = "category cannot be blank")
        @Length(max = 510, message = "Name cannot be too long")
        String category,

        @NotBlank(message = "rank cannot be blank")
        @Length(max = 510, message = "Name cannot be too long")
        String rank,

        @NotBlank(message = "visibility cannot be blank")
        @Length(max = 510, message = "Name cannot be too long")
        String visibility,

        @NotBlank(message = "counter cannot be blank")
        int counter

) {
}
