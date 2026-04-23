package com.example.allTheMethods.dto;

public class UserProblemDto extends ProblemDto{
    private Long id;
    private Long userId;

    public UserProblemDto() {
    }

    public UserProblemDto(Long id, int number, String title, String category, String difficulty, String description, int points, String problemString, Long id1, Long userId) {
        super(id, number, title, category, difficulty, description, points, problemString);
        this.id = id1;
        this.userId = userId;
    }

    public UserProblemDto(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

}
