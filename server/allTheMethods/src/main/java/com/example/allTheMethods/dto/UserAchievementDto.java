package com.example.allTheMethods.dto;

import com.example.allTheMethods.entity.Achievement;
import com.example.allTheMethods.entity.Users;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserAchievementDto extends AchievementDto{
    private Long userAchievementId;
    private Long userId;
    private Long achievementId;
    private LocalDateTime achievedAt;

    public UserAchievementDto() {
    }

    public UserAchievementDto(Long userAchievementId, Long userId, Long achievementId, LocalDateTime achievedAt) {
        this.userAchievementId = userAchievementId;
        this.userId = userId;
        this.achievementId = achievementId;
        this.achievedAt = achievedAt;
    }


    public Long getUserAchievementId() {
        return userAchievementId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAchievementId() {
        return achievementId;
    }

    public LocalDateTime getAchievedAt() {
        return achievedAt;
    }

    public void setUserAchievementId(Long userAchievementId) {
        this.userAchievementId = userAchievementId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    public void setAchievedAt(LocalDateTime achievedAt) {
        this.achievedAt = achievedAt;
    }

}
