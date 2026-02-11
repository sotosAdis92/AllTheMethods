package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.ProblemDto;
import com.example.allTheMethods.entity.Achievement;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.exception.ResourceNotFoundException;
import com.example.allTheMethods.mapper.AchievementMapper;
import com.example.allTheMethods.mapper.ProblemMapper;
import com.example.allTheMethods.repository.AchievementRepository;
import com.example.allTheMethods.service.AchievementService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AchievementServiceImpl implements AchievementService {
    private AchievementRepository achievementRepository;

    public AchievementServiceImpl(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    @Override
    public AchievementDto createAchievement(AchievementDto achievementDto) {
        Achievement achievement = AchievementMapper.mapToAchievement(achievementDto);
        Achievement savedAchievement = achievementRepository.save(achievement);
        return AchievementMapper.mapToAchievementDto(savedAchievement);
    }

    @Override
    public AchievementDto getAchievementById(Long id) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found" + id));
        return AchievementMapper.mapToAchievementDto(achievement);
    }

    @Override
    public List<AchievementDto> getAllAchievements() {
        List<Achievement> achievements = achievementRepository.findAll();
        return achievements.stream().map((achievement -> AchievementMapper.mapToAchievementDto(achievement))).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public AchievementDto updateAchievement(Long id,AchievementDto updatedAchievement) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found" + id));
        achievement.setName(updatedAchievement.getName());
        achievement.setDescription(updatedAchievement.getDescription());
        achievement.setCategory(updatedAchievement.getCategory());
        achievement.setRank(updatedAchievement.getRank());
        achievement.setVisibility(updatedAchievement.getVisibility());
        Achievement savedAchievementObj = achievementRepository.save(achievement);
        return AchievementMapper.mapToAchievementDto(savedAchievementObj);
    }

    @Override
    public void deleteAchievement(Long id) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found" + id));
        achievementRepository.deleteById(id);
    }
}
