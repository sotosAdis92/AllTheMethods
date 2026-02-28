package com.example.allTheMethods.repository;

import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.entity.UserAchievements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface UserAchievementsRepository extends JpaRepository<UserAchievements, Long> {
    @Query("SELECT a.achievementId,a.name,a.category,a.rank,a.description FROM UserAchievements ua JOIN ua.achievement a WHERE ua.user.id = ?1")
    List<Object[]> findAllByUserId(Long userId);
}
