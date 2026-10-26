package com.example.allTheMethods.mapper;


import com.example.allTheMethods.dto.request.SaveUserAchievementDto;
import com.example.allTheMethods.dto.response.UserAchievementResponse;
import com.example.allTheMethods.entity.UserAchievements;
import java.util.List;

public interface UserAchievementsMapper {
    UserAchievementResponse toDto(UserAchievements userAchievements);
    List<UserAchievementResponse> toDto(List<UserAchievements> userAchievements);
    UserAchievements toEntity(SaveUserAchievementDto saveUserAchievementDto);
}
