package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.UserAchievements;
import com.example.allTheMethods.entity.UserProblem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProblemsRepository extends JpaRepository<UserProblem, Long> {
}
