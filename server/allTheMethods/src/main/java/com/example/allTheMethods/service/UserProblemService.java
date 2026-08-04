package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.SaveUserProblemRequestDto;
import com.example.allTheMethods.dto.response.UserProblemResponse;

import java.util.List;


public interface UserProblemService {
    UserProblemResponse saveUserProblem(SaveUserProblemRequestDto userProblemDto);
    List<UserProblemResponse> getUserProblemsByUserId(int id);
    boolean checkIfUserSolvedAProblem(int id);
    List<Object> countAllByUserAndProblemDifficulty(int id);
    List<Object> countDistinctSolvedProblemsByDifficultyForUser(int id);
    List<Object> countDistinctSolvedProblemsByCategoryForUser(int id);
}
