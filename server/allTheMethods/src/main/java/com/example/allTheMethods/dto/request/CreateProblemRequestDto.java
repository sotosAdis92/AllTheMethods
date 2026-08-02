package com.example.allTheMethods.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CreateProblemRequestDto(
    @NotBlank(message = "Number cannot be blank or null")
    int number,

    @NotBlank(message = "Title cannot be blank or null")
    String title,

    @NotBlank(message = "Category cannot be blank or null")
    String category,

    @NotBlank(message = "Difficulty cannot be blank or null")
    String difficulty,

    @NotBlank(message = "Description cannot be blank or null")
    String description,

    @NotBlank(message = "Points cannot be blank or null")
    int points,

    @NotBlank(message = "Problem String cannot be blank or null")
    String problemString,

    @NotBlank(message = "Problem Type cannot be blank or null")
    String problemType,


    @NotBlank(message = "Problem Data cannot be blank or null")
    String problemData,

    @NotBlank(message = "Function String cannot be blank or null")
    String functionString
) {
}
