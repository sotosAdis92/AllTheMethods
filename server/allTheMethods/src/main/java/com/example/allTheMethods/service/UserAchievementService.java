package com.example.allTheMethods.service;
import com.example.allTheMethods.dto.SaveUserAchievementDto;
import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.dto.response.UserAchievementResponseDto;

import java.util.List;

public interface UserAchievementService {
    UserAchievementResponseDto saveUserAchievements(SaveUserAchievementDto saveUserAchievementDto);
    List<UserAchievementResponseDto> getUserAchievements(int id);
}
