package com.example.allTheMethods.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "achievement")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long achievementId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String rank;

    @Column(nullable = false)
    private String visibility;

    @Column
    private int counter;

    @OneToMany(mappedBy = "achievement")
    Set<UserAchievements> achievements;


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


    public Achievement(Long achievementId, String name, String description, String category, String rank, String visibility, Set<UserAchievements> achievements) {
        this.achievementId = achievementId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.rank = rank;
        this.visibility = visibility;
        this.achievements = achievements;
    }

    public Achievement(Long achievementId, String name, String description, String category, String rank, String visibility, int counter) {
        this.achievementId = achievementId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.rank = rank;
        this.visibility = visibility;
        this.counter = counter;
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

    public void setAchievements(Set<UserAchievements> achievements) {
        this.achievements = achievements;
    }

    public Set<UserAchievements> getAchievements() {
        return achievements;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
