package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}
