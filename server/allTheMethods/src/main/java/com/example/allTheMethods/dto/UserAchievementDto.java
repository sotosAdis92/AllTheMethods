package com.example.allTheMethods.dto;

import com.example.allTheMethods.entity.Achievement;
import com.example.allTheMethods.entity.Users;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Data
public class UserAchievementDto extends AchievementDto{
    private Long userAchievementId;
    private Long userId;
    private Long achievementId;
    private LocalDateTime achievedAt;

    public UserAchievementDto() {
    }
    public UserAchievementDto(String name, String description, String category, String rank, String visibility, Long userAchievementId, Long userId, Long achievementId, LocalDateTime achievedAt) {
        super(name, description, category, rank, visibility);
        this.userAchievementId = userAchievementId;
        this.userId = userId;
        this.achievementId = achievementId;
        this.achievedAt = achievedAt;
    }

}
