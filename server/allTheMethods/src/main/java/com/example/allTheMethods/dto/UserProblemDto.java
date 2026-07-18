package com.example.allTheMethods.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserProblemDto extends ProblemDto{
    private Long id;
    private Long userId;
    private Long problemId;

    public UserProblemDto(Long id, int number, String title, String category,
                          String difficulty, String description, int points,
                          String problemString, String functionString,
                          Long userId, Long problemId) {
        super(id, number, title, category, difficulty, description, points,
                problemString, functionString);
        this.id = id;
        this.userId = userId;
        this.problemId = problemId;
    }
}
