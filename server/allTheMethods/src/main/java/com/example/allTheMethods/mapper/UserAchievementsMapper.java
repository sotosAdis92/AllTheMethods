package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.entity.UserAchievements;

public class UserAchievementsMapper {
    public static UserAchievementDto mapToUserAchievementDto(UserAchievements userAchievements){
        return new UserAchievementDto(
            userAchievements.getUserAchievementId(),
                userAchievements.getUser().getId(),
                userAchievements.getAchievement().getAchievementId(),
                userAchievements.getAchievedAt(),
                userAchievements.getAchievement().getCategory(),
                userAchievements.getAchievement().getDescription(),
                userAchievements.getAchievement().getName(),
                userAchievements.getAchievement().getRank(),
                userAchievements.getAchievement().getVisibility()
        );
    }
    public static UserAchievements mapToUserAchievement(UserAchievementDto userAchievementDto){
        return new UserAchievements(

        );
    }
}
