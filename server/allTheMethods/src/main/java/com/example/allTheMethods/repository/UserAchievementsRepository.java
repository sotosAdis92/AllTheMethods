package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.UserAchievements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserAchievementsRepository extends JpaRepository<UserAchievements, Long> {
    @Query("SELECT ua from UserAchievements ua JOIN ua.achievement a WHERE ua.user.id = ?1")
    List<UserAchievements> findAllByUserId(Long userId);

    @Query("SELECT COUNT(up) FROM UserProblem up WHERE up.user.id = :userId GROUP BY up.problem.category")
    Integer countProblemsByCategory(@Param("userId") Long userId);

    @Query("SELECT COUNT(ua) > 0 FROM UserAchievements ua WHERE ua.user.id = :userId AND ua.achievement.achievementId = :achievementId")
    boolean existsByUserIdAndAchievementId(Long userId, Long achievementId);
}
