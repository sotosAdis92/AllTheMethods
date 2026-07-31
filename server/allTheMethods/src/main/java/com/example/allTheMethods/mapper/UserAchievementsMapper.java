package com.example.allTheMethods.mapper;


import com.example.allTheMethods.dto.SaveUserAchievementDto;
import com.example.allTheMethods.dto.response.UserAchievementResponseDto;
import com.example.allTheMethods.entity.UserAchievements;

import java.util.List;

public interface UserAchievementsMapper {
    UserAchievementResponseDto toDto(UserAchievements userAchievements);
    List<UserAchievementResponseDto> toDto(List<UserAchievements> userAchievements);
    UserAchievements toEntity(SaveUserAchievementDto saveUserAchievementDto);
}
