package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.dto.response.UserProblemResponse;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.UserProblem;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.UserProblemMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserProblemMapperImpl implements UserProblemMapper {
    public UserProblemResponse toDto(UserProblem userProblem){
        if(userProblem == null){
            return null;
        }
        return new UserProblemResponse(
                userProblem.getId(),
                userProblem.getUser().getId(),
                userProblem.getProblem().getNumber(),
                userProblem.getProblem().getTitle(),

        );
    }

    public List<UserProblemResponse> toDto(List<UserProblem> userProblems) {
        if (userProblems == null) {
            return null;
        }
        return userProblems.stream().map(this::toDto).collect(Collectors.toList());
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
