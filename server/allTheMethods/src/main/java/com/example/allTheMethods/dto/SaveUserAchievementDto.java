package com.example.allTheMethods.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveUserAchievementDto {
    private UserAchievementDto userAchievementDto;
    private UserProblemDto userProblemDto;
    private AchievementDto achievementDto;

    public SaveUserAchievementDto() {
    }
}
