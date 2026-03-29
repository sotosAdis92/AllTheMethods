package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository  extends JpaRepository<Submission, Long> {
}
