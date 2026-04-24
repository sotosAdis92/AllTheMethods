package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.UserProblem;
import com.example.allTheMethods.entity.Users;

import java.util.Locale;

public class UserProblemMapper {
    public static UserProblemDto mapToUserProblemDto(UserProblem userProblem){
        return new UserProblemDto(
                userProblem.getProblem().getNumber(),
                userProblem.getProblem().getTitle(),
                userProblem.getProblem().getCategory(),
                userProblem.getProblem().getDifficulty(),
                userProblem.getProblem().getDescription(),
                userProblem.getProblem().getPoints(),
                userProblem.getProblem().getProblemString(),
                userProblem.getProblem().getProblemType(),
                userProblem.getProblem().getProblemData(),
                userProblem.getId(),
                userProblem.getProblem().getId(),
                userProblem.getUser().getId()
        );
    }
    public static UserProblem mapToUserProblem(UserProblemDto userProblemDto, Users user, Problem problem){
        UserProblem userProblem = new UserProblem();
        userProblem.getId();
        userProblem.setUser(user);
        userProblem.setProblem(problem);
        return userProblem;
    }
}
