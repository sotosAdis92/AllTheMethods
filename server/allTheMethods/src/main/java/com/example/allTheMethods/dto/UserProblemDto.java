package com.example.allTheMethods.dto;

public class UserProblemDto extends ProblemDto{
    private Long id;
    private Long userId;
    private Long problemId;

    public UserProblemDto() {
        super();
    }


    public UserProblemDto(Long id, Long userId, Long problemId) {
        super();
        this.id = id;
        this.userId = userId;
        this.problemId = problemId;
    }

    public UserProblemDto(int number, String title, String category, String difficulty, String description, int points, String problemString, String problemType, String problemData, Long id, Long userId, Long problemId) {
        super(number, title, category, difficulty, description, points, problemString, problemType, problemData);
        this.id = id;
        this.userId = userId;
        this.problemId = problemId;
    }

    @Override
    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Long getProblemId() {
        return problemId;
    }

    public Long getUserId() {
        return userId;
    }

}
