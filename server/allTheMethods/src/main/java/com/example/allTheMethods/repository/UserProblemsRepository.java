package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.UserAchievements;
import com.example.allTheMethods.entity.UserProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProblemsRepository extends JpaRepository<UserProblem, Long> {
    @Query("SELECT up FROM UserProblem up JOIN FETCH up.problem p WHERE up.user.id = ?1")
    List<UserProblem> findAllByUserId(Long userId);
}
