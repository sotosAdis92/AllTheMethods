package com.example.allTheMethods.service;


import com.example.allTheMethods.dto.request.CreateAchievementRequest;
import com.example.allTheMethods.dto.request.UpdateAchievementRequest;
import com.example.allTheMethods.dto.response.AchievementResponseDto;
import java.util.List;


public interface AchievementService {
    AchievementResponseDto createAchievement(CreateAchievementRequest achievementDto);
    AchievementResponseDto getAchievementById(Long id);
    List<AchievementResponseDto> getAllAchievements();
    AchievementResponseDto updateAchievement(Long id, UpdateAchievementRequest updatedAchievement);
    void deleteAchievement(Long id);
    List<AchievementResponseDto> getAchievementByCategory(String category);
    List<AchievementResponseDto> getAchievementByRank(String rank);
    List<AchievementResponseDto> getAchievementByCategoryAndRanks(List<String> categories, List<String> ranks);
    long countAllTheAchievements();
}
