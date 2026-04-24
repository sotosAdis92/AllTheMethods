package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.entity.UserProblem;

public class UserProblemMapper {
    public static UserProblemDto mapToUserProblemDto(UserProblem userProblem){
        return new UserProblemDto(
                userProblem.getId(),
                userProblem.getUser().getId()
        );
    }
    public static UserProblem mapToUserProblem(UserProblemDto userProblemDto){
        UserProblem userProblem = new UserProblem();
        userProblem.setId(userProblemDto.getProblemId());
        userProblem.getUser();
        userProblem.getProblem();
        return userProblem;
    }
}
