package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.response.UserProblemResponse;
import com.example.allTheMethods.entity.UserProblem;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UserProblemMapper {
    UserProblemResponse toDto(UserProblem userProblem);
    List<UserProblemResponse> toDto(List<UserProblem> userProblems);
}
