package com.example.allTheMethods.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProblemDto {
    private Long id;
    private int number;
    private String title;
    private String category;
    private String difficulty;
    private String description;
    private int points;
    private String problemString;
    private String problemType;
    private String problemData;
    private String functionString;

    public ProblemDto(String functionString) {
        this.functionString = functionString;
    }

    public ProblemDto(Long id, int number, String title, String category, String difficulty, String description, int points, String problemString, String problemType, String problemData, String functionString) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.category = category;
        this.difficulty = difficulty;
        this.description = description;
        this.points = points;
        this.problemString = problemString;
        this.problemType = problemType;
        this.problemData = problemData;
        this.functionString = functionString;
    }

    public ProblemDto(int number, String title, String category, String difficulty, String description, int points, String problemString, String problemType, String problemData, String functionString) {
        this.number = number;
        this.title = title;
        this.category = category;
        this.difficulty = difficulty;
        this.description = description;
        this.points = points;
        this.problemString = problemString;
        this.problemType = problemType;
        this.problemData = problemData;
        this.functionString = functionString;
    }

    public ProblemDto(Long id, int number, String title, String category, String difficulty, String description, int points, String problemString, String functionString) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.category = category;
        this.difficulty = difficulty;
        this.description = description;
        this.points = points;
        this.problemString = problemString;
        this.functionString = functionString;
    }
}
