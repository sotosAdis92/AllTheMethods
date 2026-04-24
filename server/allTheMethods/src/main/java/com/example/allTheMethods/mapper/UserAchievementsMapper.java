package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.entity.UserAchievements;

public class UserAchievementsMapper {
    public static UserAchievementDto mapToUserAchievementDto(UserAchievements userAchievements){
        return new UserAchievementDto(
            userAchievements.getUserAchievementId(),
                userAchievements.getUser().getId(),
                userAchievements.getAchievement().getAchievementId(),
                userAchievements.getAchievedAt()
        );
    }
    public static UserAchievements mapToUserAchievement(UserAchievementDto userAchievementDto){
        UserAchievements userAchievements = new UserAchievements();
        userAchievements.setUserAchievementId(userAchievementDto.getUserAchievementId());
        userAchievements.getUser();
        userAchievements.getAchievement().getAchievementId();
        return userAchievements;
    }
}
