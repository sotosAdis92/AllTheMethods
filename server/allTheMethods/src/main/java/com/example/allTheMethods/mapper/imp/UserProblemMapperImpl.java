package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.request.SaveUserProblemRequestDto;
import com.example.allTheMethods.dto.response.UserProblemResponse;
import com.example.allTheMethods.entity.UserProblem;
import com.example.allTheMethods.mapper.UserProblemMapper;
import org.springframework.data.domain.Page;
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
                userProblem.getProblem().getId(),
                userProblem.getProblem().getNumber(),
                userProblem.getProblem().getTitle(),
                userProblem.getProblem().getCategory(),
                userProblem.getProblem().getDifficulty(),
                userProblem.getProblem().getDescription(),
                userProblem.getProblem().getPoints(),
                userProblem.getProblem().getProblemString(),
                userProblem.getProblem().getProblemType(),
                userProblem.getProblem().getProblemData(),
                userProblem.getProblem().getFunctionString()
        );
    }

    public List<UserProblemResponse> toDto(List<UserProblem> userProblems) {
        if (userProblems == null) {
            return null;
        }
        return userProblems.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<UserProblemResponse> toDto(Page<UserProblem> userProblems) {
        return userProblems.map(this::toDto);
    }

    @Override
    public UserProblem toEntity(SaveUserProblemRequestDto saveUserProblemRequestDto) {
        if(saveUserProblemRequestDto == null){
            return null;
        }
        UserProblem userProblem = new UserProblem();
        return userProblem;
    }
}
