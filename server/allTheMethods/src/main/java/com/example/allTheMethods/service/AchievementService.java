package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.request.CreateAchievementRequestDto;
import com.example.allTheMethods.dto.response.AchievementResponseDto;

import java.util.List;


public interface AchievementService {
    AchievementResponseDto createAchievement(CreateAchievementRequestDto achievementDto);
    AchievementDto getAchievementById(Long id);
    List<AchievementDto> getAllAchievements();
    AchievementDto updateAchievement(Long id,AchievementDto updatedAchievement);
    void deleteAchievement(Long id);
    List<AchievementDto> getAchievementByCategory(String category);
    List<AchievementDto> getAchievementByRank(String rank);
    List<AchievementDto> getAchievementByCategoryAndRanks(List<String> categories, List<String> ranks);
    long countAllTheAchievements();
}
