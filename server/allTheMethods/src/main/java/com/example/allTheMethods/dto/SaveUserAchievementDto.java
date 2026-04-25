package com.example.allTheMethods.dto;

public class SaveUserAchievementDto {
    private UserAchievementDto userAchievementDto;
    private UserProblemDto userProblemDto;
    private AchievementDto achievementDto;

    public SaveUserAchievementDto() {
    }

    public UserAchievementDto getUserAchievementDto() {
        return userAchievementDto;
    }

    public void setUserAchievementDto(UserAchievementDto userAchievementDto) {
        this.userAchievementDto = userAchievementDto;
    }

    public UserProblemDto getUserProblemDto() {
        return userProblemDto;
    }

    public void setUserProblemDto(UserProblemDto userProblemDto) {
        this.userProblemDto = userProblemDto;
    }

    public AchievementDto getAchievementDto() {
        return achievementDto;
    }

    public void setAchievementDto(AchievementDto achievementDto) {
        this.achievementDto = achievementDto;
    }
}
