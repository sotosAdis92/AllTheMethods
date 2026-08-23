package com.example.allTheMethods.repository;

import com.example.allTheMethods.dto.response.CategoryStatsResponseDto;
import com.example.allTheMethods.dto.response.DifficultyStatsResponse;
import com.example.allTheMethods.dto.response.SummaryResponseDto;
import com.example.allTheMethods.dto.response.UserProblemStatsResponseDto;
import com.example.allTheMethods.entity.UserProblem;
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
public interface UserProblemsRepository extends JpaRepository<UserProblem, Long> {

    @Query("SELECT up FROM UserProblem up JOIN FETCH up.problem p WHERE up.user.id = ?1")
    @QueryHints({@QueryHint(name="org.hibernate.readOnly",value="true"),@QueryHint(name = "org.hibernate.cacheable",value = "true")})
    Page<UserProblem> findAllByUserId(Long userId, Pageable pageable);

    @Query("SELECT p.difficulty,COUNT(up) FROM UserProblem up JOIN up.problem p WHERE up.user.id = ?1 GROUP BY p.difficulty")
    @QueryHints({@QueryHint(name="org.hibernate.readOnly",value="true"),@QueryHint(name = "org.hibernate.cacheable",value = "true")})
    List<DifficultyStatsResponse> countAllByUserAndProblemDifficulty(@Param("userId") Long userId);

    @Query("SELECT p.difficulty,COUNT(p.difficulty),COUNT(up.user.id) FROM Problem p LEFT JOIN UserProblem up ON p.id = up.problem.id AND up.user.id = ?1 GROUP BY p.difficulty")
    @QueryHints({@QueryHint(name="org.hibernate.readOnly",value="true"),@QueryHint(name = "org.hibernate.cacheable",value = "true")})
    List<UserProblemStatsResponseDto> countDistinctSolvedByDifficultyFromUser(@Param("userId") Long userId);

    @Query("SELECT p.problemType,COUNT(p.problemType) FROM Problem p FULL JOIN UserProblem up ON p.id = up.problem.id WHERE up.user.id = ?1 GROUP BY p.problemType")
    @QueryHints({@QueryHint(name="org.hibernate.readOnly",value="true"),@QueryHint(name = "org.hibernate.cacheable",value = "true")})
    List<CategoryStatsResponseDto> countDistinctByIdAndCategory(@Param("userId") Long userId);

    boolean existsByUserIdAndProblemId(Long userId, Long problemId);

    @Query("SELECT COUNT(DISTINCT up.problem.id),COUNT(s),CASE WHEN COUNT(s.user.id) = 0 THEN 0 ELSE 100.0*COUNT(DISTINCT up.user.id) / COUNT(s.user.id) END FROM Submission s JOIN UserProblem up ON s.user.id = up.user.id WHERE up.user.id = ?1")
    @QueryHints({@QueryHint(name = "org.hibernate.readOnly", value = "true"), @QueryHint( name= "org.hibernate.cacheable",value = "true")})
    List<SummaryResponseDto> countSummeryOfUser(@Param("userId") Long userId);
}
