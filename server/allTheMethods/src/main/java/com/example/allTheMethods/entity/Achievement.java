package com.example.allTheMethods.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long achievementId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String rank;

    @Column(nullable = false)
    private String visibility;

    public Achievement() {
    }

    public Achievement(Long achievementId, String name, String description, String category, String rank, String visibility) {
        this.achievementId = achievementId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.rank = rank;
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
}
