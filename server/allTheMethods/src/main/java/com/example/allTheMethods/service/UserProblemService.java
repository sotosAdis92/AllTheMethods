package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.SaveUserProblemRequestDto;
import com.example.allTheMethods.dto.response.CategoryStatsResponseDto;
import com.example.allTheMethods.dto.response.DifficultyStatsResponse;
import com.example.allTheMethods.dto.response.UserProblemResponse;
import com.example.allTheMethods.dto.response.UserProblemStatsResponseDto;


import java.util.List;


public interface UserProblemService {
    UserProblemResponse saveUserProblem(SaveUserProblemRequestDto userProblemDto);
    List<UserProblemResponse> getUserProblemsByUserId(int id);
    boolean checkIfUserSolvedAProblem(int id);
    List<DifficultyStatsResponse> countAllByUserAndProblemDifficulty(int id);
    List<UserProblemStatsResponseDto> countDistinctSolvedProblemsByDifficultyForUser(int id);
    List<CategoryStatsResponseDto> countDistinctSolvedProblemsByCategoryForUser(int id);
}
