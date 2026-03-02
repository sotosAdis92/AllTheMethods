package com.example.allTheMethods.repository;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findAchievementByCategory(String category);
}
