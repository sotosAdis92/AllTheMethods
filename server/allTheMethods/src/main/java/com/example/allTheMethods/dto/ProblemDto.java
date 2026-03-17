package com.example.allTheMethods.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ProblemDto {
    private Long id;
    private int number;
    private String title;
    private String category;
    private String difficulty;
    private String description;
    private int points;
    private String function;
    public ProblemDto() {
    }

    public ProblemDto(Long id, int number, String title, String category, String difficulty, String description, int points) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.category = category;
        this.difficulty = difficulty;
        this.description = description;
        this.points = points;
    }

    public ProblemDto(Long id, int number, String title, String category, String difficulty, String description, int points, String function) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.category = category;
        this.difficulty = difficulty;
        this.description = description;
        this.points = points;
        this.function = function;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getDescription() {
        return description;
    }

    public int getPoints() {
        return points;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
