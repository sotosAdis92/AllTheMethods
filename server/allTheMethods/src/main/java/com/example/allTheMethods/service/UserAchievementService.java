package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.entity.UserAchievements;

import java.util.List;

public interface UserAchievementService {
    UserAchievementDto saveUserAchievements(UserAchievementDto userAchievementDto);
    List<UserAchievementDto> getUserAchievements();
}
