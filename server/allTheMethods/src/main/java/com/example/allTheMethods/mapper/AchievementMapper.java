package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.entity.Achievement;

public class AchievementMapper {
    public static AchievementDto mapToAchievementDto(Achievement achievement){
        return new AchievementDto(
                achievement.getAchievementId(),
                achievement.getName(),
                achievement.getDescription(),
                achievement.getCategory(),
                achievement.getRank(),
                achievement.getVisibility()
        );
    }
    public static Achievement mapToAchievement(AchievementDto achievementDto){
        return new Achievement(
                achievementDto.getAchievementId(),
                achievementDto.getName(),
                achievementDto.getDescription(),
                achievementDto.getCategory(),
                achievementDto.getRank(),
                achievementDto.getVisibility()
        );
    }
}

