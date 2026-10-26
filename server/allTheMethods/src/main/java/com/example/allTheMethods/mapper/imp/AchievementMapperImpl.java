package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.request.CreateAchievementRequest;
import com.example.allTheMethods.dto.request.UpdateAchievementRequest;
import com.example.allTheMethods.dto.response.AchievementResponse;
import com.example.allTheMethods.entity.Achievement;
import com.example.allTheMethods.mapper.AchievementMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AchievementMapperImpl implements AchievementMapper {

    @Override
    public Achievement toEntity(CreateAchievementRequest achievementRequestDto) {
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
    public Achievement toEntity(UpdateAchievementRequest achievementRequestDto) {
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
    public AchievementResponse toDto(Achievement achievement) {
        return new AchievementResponse(
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
    public List<AchievementResponse> toDto(List<Achievement> achievementList) {
        return achievementList.stream().map(this::toDto).toList();
    }
}

