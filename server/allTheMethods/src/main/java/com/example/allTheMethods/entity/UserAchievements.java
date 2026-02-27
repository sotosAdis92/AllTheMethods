package com.example.allTheMethods.entity;

import com.example.allTheMethods.dto.UserAchievementDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
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

    public UserAchievementDto getUserAchievementDto(){
        UserAchievementDto userAchievementDto = new UserAchievementDto();
        userAchievementDto.setUserAchievementId(userAchievementId);
        userAchievementDto.setUserId(user.getUserId());
        userAchievementDto.setAchievementId(achievement.getAchievementId());
        userAchievementDto.setAchievedAt(achievedAt);
        return userAchievementDto;
    }
}
