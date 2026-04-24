package com.example.allTheMethods.dto;


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

    public String getProblemData() {
        return problemData;
    }

    public void setProblemData(String problemData) {
        this.problemData = problemData;
    }

    public ProblemDto() {
    }

    public ProblemDto(Long id, int number, String title, String category, String difficulty, String description, int points, String problemString, String problemType, String problemData) {
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
    }


    public ProblemDto(Long id, int number, String title, String category, String difficulty, String description, int points, String problemString) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.category = category;
        this.difficulty = difficulty;
        this.description = description;
        this.points = points;
        this.problemString = problemString;
    }

    public String getProblemString() {
        return problemString;
    }

    public void setProblemString(String problemString) {
        this.problemString = problemString;
    }

    public Long getProblemId() {
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

    public void setProblemId(Long problemId) {
        this.id = problemId;
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

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }
}
