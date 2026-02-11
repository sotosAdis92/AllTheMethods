package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
}
