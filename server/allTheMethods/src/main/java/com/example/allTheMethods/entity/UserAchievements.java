package com.example.allTheMethods.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_achievements")
public class UserAchievements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAchievementId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "achievementId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Achievement achievement;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    private LocalDateTime achievedAt;

    public UserAchievements() {
    }

    public UserAchievements(Long userAchievementId, Users user, Achievement achievement, LocalDateTime achievedAt) {
        this.userAchievementId = userAchievementId;
        this.user = user;
        this.achievement = achievement;
        this.achievedAt = achievedAt;
    }

    public UserAchievements(Long userAchievementId, Users user, Achievement achievement, Instant createdAt, Instant updatedAt, LocalDateTime achievedAt) {
        this.userAchievementId = userAchievementId;
        this.user = user;
        this.achievement = achievement;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
