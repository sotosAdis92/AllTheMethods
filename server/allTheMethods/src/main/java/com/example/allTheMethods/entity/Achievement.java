package com.example.allTheMethods.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    public Achievement(Long achievementId, String name, String description, String category, String rank, String visibility, int counter) {
        this.achievementId = achievementId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.rank = rank;
        this.visibility = visibility;
        this.counter = counter;
    }
}
