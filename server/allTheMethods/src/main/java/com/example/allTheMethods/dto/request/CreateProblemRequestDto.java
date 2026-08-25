package com.example.allTheMethods.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record CreateProblemRequestDto(
    @NotNull(message = "Number cannot be null")
    @Positive(message = "Number must be a positive")
    int number,

    @NotEmpty(message = "Title cannot be empty")
    @NotNull(message = "Title cannot be null")
    @NotBlank(message = "Title cannot be blank")
    String title,

    @NotEmpty(message = "Category cannot be empty")
    @NotNull(message = "Category cannot be null")
    @NotBlank(message = "Category cannot be blank or null")
    String category,

    @NotEmpty(message = "Difficulty cannot be empty")
    @NotNull(message = "Difficulty cannot be null")
    @NotBlank(message = "Difficulty cannot be blank or null")
    String difficulty,

    @NotEmpty(message = "Description cannot be empty")
    @NotNull(message = "Description cannot be null")
    @NotBlank(message = "Description cannot be blank or null")
    String description,


    @NotNull(message = "Points cannot be null")
    @Positive(message = "Points must be a positive")
    int points,

    @NotEmpty(message = "Problem String cannot be empty")
    @NotNull(message = "Problem String cannot be null")
    @NotBlank(message = "Problem String cannot be blank or null")
    String problemString,

    @NotEmpty(message = "Problem Type cannot be empty")
    @NotNull(message = "Problem Type cannot be null")
    @NotBlank(message = "Problem Type cannot be blank or null")
    String problemType,

    @NotEmpty(message = "Function String cannot be empty")
    @NotNull(message = "Function String cannot be null")
    @NotBlank(message = "Function String cannot be blank or null")
    String functionString,

    @NotEmpty(message = "Problem Data cannot be empty")
    @NotNull(message = "Problem Data cannot be null")
    @NotBlank(message = "Problem Data cannot be blank or null")
    String problemData
) {
}
