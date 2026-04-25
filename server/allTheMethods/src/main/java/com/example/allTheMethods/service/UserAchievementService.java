package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.entity.UserAchievements;

import java.util.List;

public interface UserAchievementService {
    UserAchievementDto saveUserAchievements(UserAchievementDto userAchievementDto, UserProblemDto userProblemDto, AchievementDto achievementDto);
    List<UserAchievementDto> getUserAchievements();
}
