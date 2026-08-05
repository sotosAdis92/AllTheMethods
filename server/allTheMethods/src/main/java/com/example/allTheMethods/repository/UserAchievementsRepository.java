package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.UserAchievements;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserAchievementsRepository extends JpaRepository<UserAchievements, Long> {
    @Query("SELECT ua from UserAchievements ua JOIN ua.achievement a WHERE ua.user.id = ?1")
    @QueryHints({@QueryHint(name="org.hibernate.readOnly",value="true"),@QueryHint(name = "org.hibernate.cacheable",value = "true")})
    List<UserAchievements> findAllByUserId(Long userId);

    @Query("SELECT COUNT(up) FROM UserProblem up WHERE up.user.id = :userId AND up.problem.category = :category")
    @QueryHints({@QueryHint(name="org.hibernate.readOnly",value="true"),@QueryHint(name = "org.hibernate.cacheable",value = "true")})
    Integer countProblemsByCategory(@Param("userId") Long userId, @Param("category") String category);

    @Query("SELECT COUNT(ua) > 0 FROM UserAchievements ua WHERE ua.user.id = :userId AND ua.achievement.achievementId = :achievementId")
    @QueryHints({@QueryHint(name="org.hibernate.readOnly",value="true"),@QueryHint(name = "org.hibernate.cacheable",value = "true")})
    boolean existsByUserIdAndAchievementId(Long userId, Long achievementId);
}
