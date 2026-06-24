package com.example.allTheMethods.dto;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Long getProblemId() {
        return problemId;
    }

    @Override
    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }
}
