package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
    List<Problem> findProblemByCategory(String category);
}
