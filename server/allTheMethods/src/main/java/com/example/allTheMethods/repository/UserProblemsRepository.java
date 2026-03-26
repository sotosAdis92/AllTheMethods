package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.UserAchievements;
import com.example.allTheMethods.entity.UserProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserProblemsRepository extends JpaRepository<UserProblem, Long> {
    @Query("SELECT p.id,p.number,p.title,p.category,p.difficulty,p.description,p.points,p.problemString FROM UserProblem up JOIN up.problem p WHERE up.user.id = ?1")
    List<Object[]> findAllByUserId(Long userId);
}
