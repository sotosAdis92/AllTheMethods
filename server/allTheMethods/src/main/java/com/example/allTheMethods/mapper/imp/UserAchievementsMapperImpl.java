package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.UserAchievementDto;
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
    public static UserAchievementDto mapToUserAchievementDto(UserAchievements userAchievements){
        return new UserAchievementDto(
                userAchievements.getAchievement().getName(),
                userAchievements.getAchievement().getDescription(),
                userAchievements.getAchievement().getCategory(),
                userAchievements.getAchievement().getRank(),
                userAchievements.getAchievement().getVisibility(),
                userAchievements.getUserAchievementId(),
                userAchievements.getUser().getId(),
                userAchievements.getAchievement().getAchievementId(),
                userAchievements.getAchievedAt()
        );
    }
    public static UserAchievements mapToUserAchievement(UserAchievementDto userAchievementDto){
        UserAchievements userAchievements = new UserAchievements();

        Users user = new Users();
        user.setId(userAchievementDto.getUserId());
        userAchievements.setUser(user);

        Achievement achievement = new Achievement();
        achievement.setAchievementId(userAchievementDto.getAchievementId());
        achievement.setName(userAchievementDto.getName());
        achievement.setDescription(userAchievementDto.getDescription());
        achievement.setCategory(userAchievementDto.getCategory());
        achievement.setRank(userAchievementDto.getRank());
        achievement.setVisibility(userAchievementDto.getVisibility());
        achievement.setCounter(userAchievementDto.getCounter());

        userAchievements.setAchievement(achievement);
        return userAchievements;
    }

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
}
