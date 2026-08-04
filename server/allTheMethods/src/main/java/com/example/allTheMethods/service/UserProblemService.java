package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.SaveUserProblemRequestDto;
import com.example.allTheMethods.dto.response.UserProblemResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;


public interface UserProblemService {
    UserProblemResponse saveUserProblem(SaveUserProblemRequestDto userProblemDto);
    Page<UserProblemResponse> getUserProblemsByUserId(int id, Pageable pageable);
    boolean checkIfUserSolvedAProblem(int id);
    List<Object> countAllByUserAndProblemDifficulty(int id);
    List<Object> countDistinctSolvedProblemsByDifficultyForUser(int id);
    List<Object> countDistinctSolvedProblemsByCategoryForUser(int id);
}
