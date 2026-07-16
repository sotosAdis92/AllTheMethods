package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AchievementService {
    AchievementDto createAchievement(AchievementDto achievementDto);
    AchievementDto getAchievementById(Long id);
    List<AchievementDto> getAllAchievements();
    AchievementDto updateAchievement(Long id,AchievementDto updatedAchievement);
    void deleteAchievement(Long id);
    List<AchievementDto> getAchievementByCategory(String category);
    List<AchievementDto> getAchievementByRank(String rank);
    List<AchievementDto> getAchievementByCategoryAndRanks(List<String> categories, List<String> ranks);
}
