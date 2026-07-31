package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.request.CreateAchievementRequestDto;
import com.example.allTheMethods.dto.request.UpdateAchievementRequestDto;
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
    public AchievementResponseDto getAchievementById(Long id) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found" + id));
        return achievementMapper.toDto(achievement);
    }

    @Override
    public List<AchievementResponseDto> getAllAchievements() {
        List<Achievement> allAchievements = achievementRepository.findAll();
        return achievementMapper.toDto(allAchievements);
    }

    @Override
    public AchievementResponseDto updateAchievement(Long id, UpdateAchievementRequestDto updatedAchievement) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found" + id));
        achievement.setName(updatedAchievement.name());
        achievement.setDescription(updatedAchievement.description());
        achievement.setCategory(updatedAchievement.category());
        achievement.setRank(updatedAchievement.rank());
        achievement.setVisibility(updatedAchievement.visibility());
        achievement.setCounter(updatedAchievement.counter());
        Achievement savedAchievementObj = achievementRepository.save(achievement);
        return achievementMapper.toDto(savedAchievementObj);
    }

    @Override
    public void deleteAchievement(Long id) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found" + id));
        achievementRepository.deleteById(id);
    }

    @Override
    public List<AchievementResponseDto> getAchievementByCategory(String category) {
        List<Achievement> achievements = achievementRepository.findAchievementByCategory(category);
        return achievementMapper.toDto(achievements);
    }

    @Override
    public List<AchievementResponseDto> getAchievementByRank(String rank){
        List<Achievement> achievements = achievementRepository.findAchievementByRank(rank);
        return achievementMapper.toDto(achievements);
    }

    @Override
    public List<AchievementResponseDto> getAchievementByCategoryAndRanks(List<String> categories, List<String> ranks){
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
        return achievementMapper.toDto(achievementsByCategoryAndRank);
    }

    public long countAllTheAchievements(){
        long countOfAchievements = achievementRepository.count();
        return countOfAchievements;
    }
}
