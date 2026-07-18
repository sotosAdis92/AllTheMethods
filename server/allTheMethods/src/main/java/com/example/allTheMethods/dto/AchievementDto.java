package com.example.allTheMethods.dto;

import lombok.*;

@Setter
@Getter
public class AchievementDto {
    private Long achievementId;
    private String name;
    private String description;
    private String category;
    private String rank;
    private String visibility;
    private int counter;

    public AchievementDto() {
    }

    public AchievementDto(Long achievementId, String name, String description, String category, String rank, String visibility) {
        this.achievementId = achievementId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.rank = rank;
        this.visibility = visibility;
    }

    public AchievementDto(String name, String description, String category, String rank, String visibility) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.rank = rank;
        this.visibility = visibility;
    }

    public AchievementDto(Long achievementId, String name, String description, String category, String rank, String visibility, int counter) {
        this.achievementId = achievementId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.rank = rank;
        this.visibility = visibility;
        this.counter = counter;
    }
}
