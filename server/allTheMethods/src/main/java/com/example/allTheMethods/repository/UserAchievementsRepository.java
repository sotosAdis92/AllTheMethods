package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.UserAchievements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface UserAchievementsRepository extends JpaRepository<UserAchievements, Long> {
    List<UserAchievements> findAllByUserId(Long userId);
}
