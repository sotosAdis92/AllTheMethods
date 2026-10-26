package com.example.allTheMethods.service;


import com.example.allTheMethods.dto.request.CreateAchievementRequest;
import com.example.allTheMethods.dto.request.UpdateAchievementRequest;
import com.example.allTheMethods.dto.response.AchievementResponse;
import java.util.List;


public interface AchievementService {
    AchievementResponse createAchievement(CreateAchievementRequest achievementDto);
    AchievementResponse getAchievementById(Long id);
    List<AchievementResponse> getAllAchievements();
    AchievementResponse updateAchievement(Long id, UpdateAchievementRequest updatedAchievement);
    void deleteAchievement(Long id);
    List<AchievementResponse> getAchievementByCategory(String category);
    List<AchievementResponse> getAchievementByRank(String rank);
    List<AchievementResponse> getAchievementByCategoryAndRanks(List<String> categories, List<String> ranks);
    long countAllTheAchievements();
}
