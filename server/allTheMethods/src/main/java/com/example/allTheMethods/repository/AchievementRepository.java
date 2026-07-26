package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findAchievementByCategory(String category);
    List<Achievement> findAchievementByRank(String rank);

    @Query("SELECT a from Achievement a WHERE a.category IN (:categories) AND a.rank IN(:ranks)")
    List<Achievement> findAchievementsByCategoryAndRank(@Param("categories") List<String> categories, @Param("ranks") List<String> ranks);

    List<Achievement> findAchievementsByCategoryIn(@Param("categories") List<String> categories);
    List<Achievement> findAchievementsByRankIn(@Param("ranks") List<String> ranks);

    long count();
}
