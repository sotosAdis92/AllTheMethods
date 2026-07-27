package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.dto.response.UserProblemResponse;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.UserProblem;
import com.example.allTheMethods.entity.Users;

public class UserProblemMapper {
    public UserProblemResponse toDto(UserProblem userProblem){
        if(userProblem == null){
            return null;
        }
        return new UserProblemResponse();
    }

    public static UserProblemDto mapToUserProblemDto(UserProblem userProblem){
        return new UserProblemDto(
                userProblem.getId(),
                userProblem.getProblem().getNumber(),
                userProblem.getProblem().getTitle(),
                userProblem.getProblem().getCategory(),
                userProblem.getProblem().getDifficulty(),
                userProblem.getProblem().getDescription(),
                userProblem.getProblem().getPoints(),
                userProblem.getProblem().getProblemString(),
                userProblem.getProblem().getProblemType(),
                userProblem.getUser().getId(),
                userProblem.getProblem().getId()
        );
    }

    public static UserProblem mapToUserProblem(UserProblemDto userProblemDto, Users user, Problem problem){
        UserProblem userProblem = new UserProblem();
        userProblem.setUser(user);
        userProblem.setProblem(problem);
        return userProblem;
    }
}
