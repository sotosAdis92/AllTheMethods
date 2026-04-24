package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.entity.UserAchievements;

public class UserAchievementsMapper {
    public static UserAchievementDto mapToUserAchievementDto(UserAchievements userAchievements){
        return new UserAchievementDto(

        );
    }
    public static UserAchievements mapToUserAchievement(UserAchievementDto userAchievementDto){
        return new UserAchievements(

        );
    }
}
