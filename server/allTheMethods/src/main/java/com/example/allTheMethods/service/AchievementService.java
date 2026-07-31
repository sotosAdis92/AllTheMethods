package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.request.CreateAchievementRequestDto;
import com.example.allTheMethods.dto.request.UpdateAchievementRequestDto;
import com.example.allTheMethods.dto.response.AchievementResponseDto;

import java.util.List;


public interface AchievementService {
    AchievementResponseDto createAchievement(CreateAchievementRequestDto achievementDto);
    AchievementResponseDto getAchievementById(Long id);
    List<AchievementResponseDto> getAllAchievements();
    AchievementResponseDto updateAchievement(Long id, UpdateAchievementRequestDto updatedAchievement);
    void deleteAchievement(Long id);
    List<AchievementResponseDto> getAchievementByCategory(String category);
    List<AchievementResponseDto> getAchievementByRank(String rank);
    List<AchievementResponseDto> getAchievementByCategoryAndRanks(List<String> categories, List<String> ranks);
    long countAllTheAchievements();
}
