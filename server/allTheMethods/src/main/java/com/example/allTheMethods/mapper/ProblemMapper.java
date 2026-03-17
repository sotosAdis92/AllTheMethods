package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.ProblemDto;
import com.example.allTheMethods.entity.Problem;

public class ProblemMapper {
    public static ProblemDto mapToProblemDto(Problem problem){
        return new ProblemDto(
                problem.getId(),
                problem.getNumber(),
                problem.getTitle(),
                problem.getCategory(),
                problem.getDifficulty(),
                problem.getDescription(),
                problem.getPoints(),
                problem.getFunctionString()
        );
    }
    public static Problem mapToProblem(ProblemDto problemDto){
        return new Problem(
                problemDto.getId(),
                problemDto.getNumber(),
                problemDto.getTitle(),
                problemDto.getCategory(),
                problemDto.getDifficulty(),
                problemDto.getDescription(),
                problemDto.getPoints(),
                problemDto.getFunction()
        );
    }
}
