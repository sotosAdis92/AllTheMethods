package com.example.allTheMethods.dto.request;

public class SaveUserAchievementDto {
    private UserAchievementRequest userAchievementDto;
    private UserProblemRequest userProblemDto;
    private AchievementRequest achievementRequest;

    public SaveUserAchievementDto() {
    }

    public UserAchievementRequest getUserAchievementDto() {
        return userAchievementDto;
    }

    public void setUserAchievementDto(UserAchievementRequest userAchievementDto) {
        this.userAchievementDto = userAchievementDto;
    }

    public UserProblemRequest getUserProblemDto() {
        return userProblemDto;
    }

    public void setUserProblemDto(UserProblemRequest userProblemDto) {
        this.userProblemDto = userProblemDto;
    }

    public AchievementRequest getAchievementDto() {
        return achievementRequest;
    }

    public void setAchievementDto(AchievementRequest achievementRequest) {
        this.achievementRequest = achievementRequest;
    }
}
