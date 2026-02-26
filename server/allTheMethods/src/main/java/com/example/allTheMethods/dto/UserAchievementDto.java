package com.example.allTheMethods.dto;

import com.example.allTheMethods.entity.Achievement;
import com.example.allTheMethods.entity.Users;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserAchievementDto {
    private Long userAchievementId;
    private Users user;
    private Achievement achievement;
    private LocalDateTime achievedAt;

    public UserAchievementDto() {
    }

    public UserAchievementDto(Long userAchievementId, Users user, Achievement achievement, LocalDateTime achievedAt) {
        this.userAchievementId = userAchievementId;
        this.user = user;
        this.achievement = achievement;
        this.achievedAt = achievedAt;
    }

    public Long getUserAchievementId() {
        return userAchievementId;
    }

    public Users getUser() {
        return user;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public LocalDateTime getAchievedAt() {
        return achievedAt;
    }

    public void setUserAchievementId(Long userAchievementId) {
        this.userAchievementId = userAchievementId;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public void setAchievedAt(LocalDateTime achievedAt) {
        this.achievedAt = achievedAt;
    }
}
