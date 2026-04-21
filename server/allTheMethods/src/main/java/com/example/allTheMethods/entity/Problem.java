package com.example.allTheMethods.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnTransformer;

import java.util.Set;


@Entity
@Table(name = "problem")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int number;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String difficulty;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int points;

    @Column()
    private String problemString;

    @Column
    private String problemType;

    public Problem(Long id, int number, String title, String category, String difficulty, String description, int points, String problemString, String problemType, String problemData) {
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

    public String getProblemData() {
        return problemData;
    }

    public void setProblemData(String problemData) {
        this.problemData = problemData;
    }

    @Column(name = "problem_parameters", columnDefinition = "jsonb")
    @ColumnTransformer(write = "?::jsonb")
    private String problemData;
    /*
    ? -> the data you are trying to insert which is of type String
    :: -> represent casting
    jsonb -> the target data type we wish our data to be transformed to
     */

    @OneToMany(mappedBy = "problem")
    Set<Submission> problems;

    public Problem() {
    }

    public Problem(Long id, int number, String title, String category, String difficulty, String description, int points) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.category = category;
        this.difficulty = difficulty;
        this.description = description;
        this.points = points;
    }



    public Problem(Long id, int number, String title, String category, String difficulty, String description, int points, Set<Submission> problems) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.category = category;
        this.difficulty = difficulty;
        this.description = description;
        this.points = points;
        this.problems = problems;
    }

    public Problem(Long id, int number, String title, String category, String difficulty, String description, int points, String problemString) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.category = category;
        this.difficulty = difficulty;
        this.description = description;
        this.points = points;
        this.problemString = problemString;
    }

    public Problem(Long id, int number, String title, String category, String difficulty, String description, int points, String problemString, String problemType) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.category = category;
        this.difficulty = difficulty;
        this.description = description;
        this.points = points;
        this.problemString = problemString;
        this.problemType = problemType;
    }

    public String getProblemString() {
        return problemString;
    }

    public void setProblemString(String problemString) {
        this.problemString = problemString;
    }

    public Set<Submission> getProblems() {
        return problems;
    }

    public void setProblems(Set<Submission> problems) {
        this.problems = problems;
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

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }
}
