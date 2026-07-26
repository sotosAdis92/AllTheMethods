package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.UserProblemDto;
import java.util.List;


public interface UserProblemService {
    UserProblemDto saveUserProblem(UserProblemDto userProblemDto);
    List<UserProblemDto> getUserProblems();
    boolean checkIfUserSolvedAProblem(int id);
    List<Object> countAllByUserAndProblemDifficulty(int id);
    List<Object> countDistinctSolvedProblemsByDifficultyForUser(int id);
    List<Object> countDistinctSolvedProblemsByCategoryForUser(int id);
}
