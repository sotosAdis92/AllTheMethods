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
    private String category;
    private String description;
    private String name;
    private String rank;
    private String visibility;

    public UserAchievementDto() {
    }

    public UserAchievementDto(Long userAchievementId, Long userId, Long achievementId, LocalDateTime achievedAt) {
        this.userAchievementId = userAchievementId;
        this.userId = userId;
        this.achievementId = achievementId;
        this.achievedAt = achievedAt;
    }

    public UserAchievementDto(Long userAchievementId, Long userId, Long achievementId, LocalDateTime achievedAt, String category, String description, String name, String rank, String visibility) {
        this.userAchievementId = userAchievementId;
        this.userId = userId;
        this.achievementId = achievementId;
        this.achievedAt = achievedAt;
        this.category = category;
        this.description = description;
        this.name = name;
        this.rank = rank;
        this.visibility = visibility;
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

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getVisibility() {
        return visibility;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
