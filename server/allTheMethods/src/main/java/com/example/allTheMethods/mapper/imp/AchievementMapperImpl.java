package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.request.CreateAchievementRequestDto;
import com.example.allTheMethods.dto.request.UpdateAchievementRequestDto;
import com.example.allTheMethods.dto.response.AchievementResponseDto;
import com.example.allTheMethods.entity.Achievement;
import com.example.allTheMethods.mapper.AchievementMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AchievementMapperImpl implements AchievementMapper {


    public static AchievementDto mapToAchievementDto(Achievement achievement){
        return new AchievementDto(
                achievement.getAchievementId(),
                achievement.getName(),
                achievement.getDescription(),
                achievement.getCategory(),
                achievement.getRank(),
                achievement.getVisibility(),
                achievement.getCounter()
        );
    }
    public static Achievement mapToAchievement(AchievementDto achievementDto){
        return new Achievement(
                achievementDto.getAchievementId(),
                achievementDto.getName(),
                achievementDto.getDescription(),
                achievementDto.getCategory(),
                achievementDto.getRank(),
                achievementDto.getVisibility(),
                achievementDto.getCounter()
        );
    }

    @Override
    public Achievement toEntity(CreateAchievementRequestDto achievementRequestDto) {
        Achievement achievement = new Achievement(
                null,
                achievementRequestDto.name(),
                achievementRequestDto.description(),
                achievementRequestDto.category(),
                achievementRequestDto.rank(),
                achievementRequestDto.visibility(),
                achievementRequestDto.counter()
        );
        return achievement;
    }

    @Override
    public Achievement toEntity(UpdateAchievementRequestDto achievementRequestDto) {
        Achievement achievement = new Achievement(
                null,
                achievementRequestDto.name(),
                achievementRequestDto.description(),
                achievementRequestDto.category(),
                achievementRequestDto.rank(),
                achievementRequestDto.visibility(),
                achievementRequestDto.counter()
        );
        return achievement;
    }

    @Override
    public AchievementResponseDto toDto(Achievement achievement) {
        return new AchievementResponseDto(
                achievement.getAchievementId(),
                achievement.getName(),
                achievement.getDescription(),
                achievement.getCategory(),
                achievement.getRank(),
                achievement.getVisibility(),
                achievement.getCounter()
        );
    }

    @Override
    public List<AchievementResponseDto> toDto(List<Achievement> achievementList) {
        return achievementList.stream().map(this::toDto).toList();
    }
}

