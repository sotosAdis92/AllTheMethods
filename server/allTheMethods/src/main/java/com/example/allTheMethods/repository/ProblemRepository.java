package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.Problem;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
    List<Problem> findProblemByCategory(String category);
    List<Problem> findProblemByDifficulty(String difficulty);

    @Query("SELECT p FROM Problem p WHERE p.category IN (:categories) AND p.difficulty IN (:difficulties)")
    @QueryHints({
            @QueryHint(name = "org.hibernate.readOnly",value = "true"),
            @QueryHint(name = "org.hibernate.cacheable",value = "true"),
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE")
    })
    List<Problem> findProblemsByCategoryOrDifficulty(@Param("categories") List<String> categories, @Param("difficulties") List<String> difficulties);

    List<Problem> findProblemsByCategoryIn(@Param("categories") List<String> categories);
    List<Problem> findProblemsByDifficultyIn(@Param("difficulties") List<String> difficulties);

    long count();
}
