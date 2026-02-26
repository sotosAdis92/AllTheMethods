package com.example.allTheMethods.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class UserAchievements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAchievementId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "achievementId")
    private Achievement achievement;

    private LocalDateTime achievedAt;

    public UserAchievements() {
    }

    public UserAchievements(Long userAchievementId, Users user, Achievement achievement, LocalDateTime achievedAt) {
        this.userAchievementId = userAchievementId;
        this.user = user;
        this.achievement = achievement;
        this.achievedAt = achievedAt;
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
}
