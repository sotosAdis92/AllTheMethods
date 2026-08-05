package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.Submission;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    @Query("SELECT s FROM Submission s JOIN FETCH s.problem p WHERE s.user.id = ?1")
    @QueryHints({@QueryHint(name="org.hibernate.readOnly",value = "true"), @QueryHint(name = "org.hibernate.cacheable",value = "true")})
    Page<Submission> findAllByUserId(@Param("userId") Long id, Pageable pageable);
}
