package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.UserProblem;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface UserProblemsRepository extends JpaRepository<UserProblem, Long> {

    @Query("SELECT up FROM UserProblem up JOIN FETCH up.problem p WHERE up.user.id = ?1")
    Page<UserProblem> findAllByUserId(Long userId, Pageable pageable);

    @Query("SELECT p.difficulty,COUNT(up) FROM UserProblem up JOIN up.problem p WHERE up.user.id = ?1 GROUP BY p.difficulty")
    List<Object> countAllByUserAndProblemDifficulty(@Param("userId") Long userId);

    @Query("SELECT p.difficulty,COUNT(p.difficulty),COUNT(up.user.id) FROM Problem p LEFT JOIN UserProblem up ON p.id = up.problem.id AND up.user.id = ?1 GROUP BY p.difficulty")
    List<Object> countDistinctSolvedByDifficultyFromUser(@Param("userId") Long userId);

    @Query("SELECT p.problemType,COUNT(p.problemType) FROM Problem p FULL JOIN UserProblem up ON p.id = up.problem.id WHERE up.user.id = ?1 GROUP BY p.problemType")
    List<Object> countDistinctByIdAndCategory(@Param("userId") Long userId);

    boolean existsByUserIdAndProblemId(Long userId, Long problemId);
}
