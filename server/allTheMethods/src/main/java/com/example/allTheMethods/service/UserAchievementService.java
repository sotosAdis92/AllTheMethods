package com.example.allTheMethods.service;
import com.example.allTheMethods.dto.SaveUserAchievementDto;
import com.example.allTheMethods.dto.UserAchievementDto;
import java.util.List;

public interface UserAchievementService {
    UserAchievementDto saveUserAchievements(SaveUserAchievementDto saveUserAchievementDto);
    List<UserAchievementDto> getUserAchievements();
}
