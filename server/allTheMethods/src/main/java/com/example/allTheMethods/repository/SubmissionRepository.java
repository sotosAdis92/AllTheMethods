package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository  extends JpaRepository<Submission, Long> {
}
