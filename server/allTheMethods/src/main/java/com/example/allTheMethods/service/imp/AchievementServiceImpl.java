package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.request.CreateAchievementRequestDto;
import com.example.allTheMethods.dto.response.AchievementResponseDto;
import com.example.allTheMethods.entity.Achievement;
import com.example.allTheMethods.exception.ResourceNotFoundException;
import com.example.allTheMethods.mapper.AchievementMapper;
import com.example.allTheMethods.mapper.imp.AchievementMapperImpl;
import com.example.allTheMethods.repository.AchievementRepository;
import com.example.allTheMethods.service.AchievementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.allTheMethods.utils.MethodUtils.cleanList;

@Service
public class AchievementServiceImpl implements AchievementService {
    private AchievementRepository achievementRepository;
    private AchievementMapper achievementMapper;

    public AchievementServiceImpl(AchievementRepository achievementRepository, AchievementMapper achievementMapper) {
        this.achievementRepository = achievementRepository;
        this.achievementMapper = achievementMapper;
    }

    @Override
    public AchievementResponseDto createAchievement(CreateAchievementRequestDto achievementDto) {
        Achievement achievement = achievementMapper.toEntity(achievementDto);
        return achievementMapper.toDto(achievementRepository.save(achievement));
    }

    @Override
    public AchievementDto getAchievementById(Long id) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found" + id));
        return AchievementMapperImpl.mapToAchievementDto(achievement);
    }

    @Override
    public List<AchievementDto> getAllAchievements() {
        List<Achievement> achievements = achievementRepository.findAll();
        return achievements.stream().map((achievement -> AchievementMapperImpl.mapToAchievementDto(achievement))).collect(Collectors.toUnmodifiableList());
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
        return AchievementMapperImpl.mapToAchievementDto(savedAchievementObj);
    }

    @Override
    public void deleteAchievement(Long id) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found" + id));
        achievementRepository.deleteById(id);
    }

    @Override
    public List<AchievementDto> getAchievementByCategory(String category) {
        List<Achievement> achievements = achievementRepository.findAchievementByCategory(category);
        return achievements.stream().map((achievement -> AchievementMapperImpl.mapToAchievementDto(achievement))).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<AchievementDto> getAchievementByRank(String rank){
        List<Achievement> achievements = achievementRepository.findAchievementByRank(rank);
        return achievements.stream().map((achievement -> AchievementMapperImpl.mapToAchievementDto(achievement))).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<AchievementDto> getAchievementByCategoryAndRanks(List<String> categories, List<String> ranks){
        categories = cleanList(categories);
        ranks = cleanList(ranks);
        List<Achievement> achievementsByCategoryAndRank;
        if(categories!=null && ranks!=null){
            achievementsByCategoryAndRank = achievementRepository.findAchievementsByCategoryAndRank(categories, ranks);
        }
        else if(categories != null){
            achievementsByCategoryAndRank = achievementRepository.findAchievementsByCategoryIn(categories);
        }
        else if(ranks !=null){
            achievementsByCategoryAndRank = achievementRepository.findAchievementsByRankIn(ranks);
        }
        else {
            achievementsByCategoryAndRank = achievementRepository.findAll();
        }
        return achievementsByCategoryAndRank.stream().map((achievement -> AchievementMapperImpl.mapToAchievementDto(achievement))).collect(Collectors.toUnmodifiableList());
    }

    public long countAllTheAchievements(){
        long countOfAchievements = achievementRepository.count();
        return countOfAchievements;
    }
}
