package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.SaveUserAchievementDto;
import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.dto.response.UserAchievementResponseDto;
import com.example.allTheMethods.entity.Achievement;
import com.example.allTheMethods.entity.UserAchievements;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.UserAchievementsMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAchievementsMapperImpl implements UserAchievementsMapper {

    @Override
    public UserAchievementResponseDto toDto(UserAchievements userAchievements) {
        if(userAchievements == null){
            return null;
        }
        return new UserAchievementResponseDto(
                userAchievements.getUserAchievementId(),
                userAchievements.getUser().getId(),
                userAchievements.getAchievement().getAchievementId(),
                userAchievements.getAchievedAt(),
                userAchievements.getAchievement().getName(),
                userAchievements.getAchievement().getDescription(),
                userAchievements.getAchievement().getCategory(),
                userAchievements.getAchievement().getRank(),
                userAchievements.getAchievement().getVisibility(),
                userAchievements.getAchievement().getCounter()
        );
    }

    @Override
    public List<UserAchievementResponseDto> toDto(List<UserAchievements> userAchievements) {
        if(userAchievements == null){
            return null;
        }
        return userAchievements.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public UserAchievements toEntity(SaveUserAchievementDto saveUserAchievementDto) {
        if(saveUserAchievementDto == null){
            return null;
        }
        UserAchievements userAchievements = new UserAchievements();
        Users user = new Users();
        user.setId(saveUserAchievementDto.getUserProblemDto().getUserId());
        userAchievements.setUser(user);

        Achievement achievement = new Achievement();
        AchievementDto achievementDto = saveUserAchievementDto.getAchievementDto();
        achievement.setAchievementId(achievementDto.getAchievementId());
        achievement.setName(achievementDto.getName());
        achievement.setDescription(achievementDto.getDescription());
        achievement.setCategory(achievementDto.getCategory());
        achievement.setRank(achievementDto.getRank());
        achievement.setVisibility(achievementDto.getVisibility());
        achievement.setCounter(achievementDto.getCounter());
        userAchievements.setAchievement(achievement);

        return userAchievements;
    }


}
