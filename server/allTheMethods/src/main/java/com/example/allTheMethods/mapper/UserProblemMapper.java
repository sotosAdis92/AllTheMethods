package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.UserProblem;
import com.example.allTheMethods.entity.Users;

public class UserProblemMapper {
    public static UserProblemDto mapToUserProblemDto(UserProblem userProblem){
        return new UserProblemDto(
                userProblem.getId(),
                userProblem.getUser().getId()
        );
    }
    public static UserProblem mapToUserProblem(UserProblemDto userProblemDto){
        UserProblem userProblem = new UserProblem();
        userProblem.setId(userProblemDto.getId());
        userProblem.getUser();
        userProblem.getProblem();
        return userProblem;
    }
}
