package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.entity.UserProblem;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


public interface UserProblemService {
    UserProblemDto saveUserProblem(UserProblemDto userProblemDto);
    List<UserProblemDto> getUserProblems();
    boolean checkIfUserSolvedAProblem(int id);
    List<Object[]> countAllByUserAndProblemDifficulty(int id);
}
