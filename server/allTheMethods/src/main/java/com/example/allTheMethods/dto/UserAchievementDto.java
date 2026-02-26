package com.example.allTheMethods.dto;

import com.example.allTheMethods.entity.Achievement;
import com.example.allTheMethods.entity.Users;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserAchievementDto {
    private Long userAchievementId;
    private Long userId;
    private Long achievementId;
    private LocalDateTime achievedAt;
}
