package com.example.allTheMethods.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private int points;

    @Column(nullable = false)
    private String problemString;

    @Column(nullable = false)
    private String problemType;

    @Column(nullable = false)
    private String functionString;

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

    public Problem(Long id, int number, String title, String category, String difficulty, String description, int points, String problemString, String problemType, String functionSting, String problemData) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.category = category;
        this.difficulty = difficulty;
        this.description = description;
        this.points = points;
        this.problemString = problemString;
        this.problemType = problemType;
        this.functionString = functionSting;
        this.problemData = problemData;
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
}
