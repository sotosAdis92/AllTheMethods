package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
    List<Problem> findProblemByCategory(String category);
    List<Problem> findProblemByDifficulty(String difficulty);

    @Query("SELECT p FROM Problem p WHERE p.category IN (:categories) AND p.difficulty IN (:difficulties)")
    List<Problem> findProblemsByCategoryOrDifficulty(@Param("categories") List<String> categories, @Param("difficulties") List<String> difficulties);

    List<Problem> findProblemsByCategoryIn(@Param("categories") List<String> categories);
    List<Problem> findProblemsByDifficultyIn(@Param("difficulties") List<String> difficulties);

    long count();
}
