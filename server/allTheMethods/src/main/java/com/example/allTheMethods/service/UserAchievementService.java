package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.SaveUserAchievementDto;
import com.example.allTheMethods.dto.response.UserAchievementResponseDto;
import java.util.List;

public interface UserAchievementService {
    UserAchievementResponseDto saveUserAchievements(SaveUserAchievementDto saveUserAchievementDto);
    List<UserAchievementResponseDto> getUserAchievements(Long id);
}
