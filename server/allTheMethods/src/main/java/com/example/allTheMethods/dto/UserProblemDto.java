package com.example.allTheMethods.dto;

public class UserProblemDto extends ProblemDto{
    private Long id;
    private Long userId;
    private Long problemId;

    public UserProblemDto() {
    }

    public UserProblemDto(Long id, int number, String title, String category, String difficulty, String description, int points, String problemString, Long id1, Long userId, Long problemId) {
        super(id, number, title, category, difficulty, description, points, problemString);
        this.id = id1;
        this.userId = userId;
        this.problemId = problemId;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProblemId() {
        return problemId;
    }
}
