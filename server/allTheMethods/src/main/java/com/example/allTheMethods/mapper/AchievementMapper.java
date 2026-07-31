package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.request.CreateAchievementRequestDto;
import com.example.allTheMethods.dto.request.UpdateAchievementRequestDto;
import com.example.allTheMethods.dto.response.AchievementResponseDto;
import com.example.allTheMethods.entity.Achievement;
import org.springframework.stereotype.Component;

import java.util.List;


public interface AchievementMapper {
    Achievement toEntity(CreateAchievementRequestDto achievementRequestDto);
    Achievement toEntity(UpdateAchievementRequestDto achievementRequestDto);
    AchievementResponseDto toDto(Achievement achievement);
    List<AchievementResponseDto> toDto(List<Achievement> achievementList);
}
