package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.request.AchievementRequest;
import com.example.allTheMethods.dto.request.SaveUserAchievementDto;
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
        AchievementRequest achievementRequest = saveUserAchievementDto.getAchievementDto();
        achievement.setAchievementId(achievementRequest.getAchievementId());
        achievement.setName(achievementRequest.getName());
        achievement.setDescription(achievementRequest.getDescription());
        achievement.setCategory(achievementRequest.getCategory());
        achievement.setRank(achievementRequest.getRank());
        achievement.setVisibility(achievementRequest.getVisibility());
        achievement.setCounter(achievementRequest.getCounter());
        userAchievements.setAchievement(achievement);

        return userAchievements;
    }


}
