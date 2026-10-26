package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.request.CreateAchievementRequest;
import com.example.allTheMethods.dto.request.UpdateAchievementRequest;
import com.example.allTheMethods.dto.response.AchievementResponseDto;
import com.example.allTheMethods.entity.Achievement;
import java.util.List;


public interface AchievementMapper {
    Achievement toEntity(CreateAchievementRequest achievementRequestDto);
    Achievement toEntity(UpdateAchievementRequest achievementRequestDto);
    AchievementResponseDto toDto(Achievement achievement);
    List<AchievementResponseDto> toDto(List<Achievement> achievementList);
}
