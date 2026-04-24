package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.entity.UserProblem;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserProblemService {
    UserProblemDto saveUserProblem(UserProblemDto userProblemDto);
    List<UserProblemDto> getUserProblems();
}
