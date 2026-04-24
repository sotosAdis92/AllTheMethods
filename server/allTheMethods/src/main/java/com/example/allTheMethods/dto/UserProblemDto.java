package com.example.allTheMethods.dto;

public class UserProblemDto extends ProblemDto{
    private Long id;
    private Long userId;
    private Long problemId;

    public UserProblemDto() {
    }


    public UserProblemDto(Long id, Long userId, Long problemId) {
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
