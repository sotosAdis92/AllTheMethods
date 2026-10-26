package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.SaveUserAchievementDto;
import com.example.allTheMethods.dto.response.UserAchievementResponse;
import java.util.List;

public interface UserAchievementService {
    UserAchievementResponse saveUserAchievements(SaveUserAchievementDto saveUserAchievementDto);
    List<UserAchievementResponse> getUserAchievements(Long id);
}
