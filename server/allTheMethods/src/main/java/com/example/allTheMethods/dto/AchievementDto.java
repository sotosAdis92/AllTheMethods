package com.example.allTheMethods.dto;

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

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Long getAchievementId() {
        return achievementId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getRank() {
        return rank;
    }

    public String getVisibility() {
        return visibility;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
