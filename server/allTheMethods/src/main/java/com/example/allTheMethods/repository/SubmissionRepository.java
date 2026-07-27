package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    @Query("SELECT s.date,p.number,p.title,p.difficulty FROM Submission s JOIN Problem p ON p.id = s.problem.id WHERE s.user.id = ?1")
    List<Submission> findAllByUserId(@Param("userId") Long id);
}
