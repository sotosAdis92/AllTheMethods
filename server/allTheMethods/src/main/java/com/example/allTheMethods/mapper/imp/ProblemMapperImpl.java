package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.ProblemDto;
import com.example.allTheMethods.dto.request.CreateProblemRequestDto;
import com.example.allTheMethods.dto.request.UpdateProblemRequestDto;
import com.example.allTheMethods.dto.response.ProblemResponseDto;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.mapper.ProblemMapper;

import java.util.List;

public class ProblemMapperImpl implements ProblemMapper {
    public static ProblemDto mapToProblemDto(Problem problem){
        return new ProblemDto(
                problem.getId(),
                problem.getNumber(),
                problem.getTitle(),
                problem.getCategory(),
                problem.getDifficulty(),
                problem.getDescription(),
                problem.getPoints(),
                problem.getProblemString(),
                problem.getProblemType(),
                problem.getProblemData(),
                problem.getFunctionString()
        );
    }
    public static Problem mapToProblem(ProblemDto problemDto){
        return new Problem(
                problemDto.getProblemId(),
                problemDto.getNumber(),
                problemDto.getTitle(),
                problemDto.getCategory(),
                problemDto.getDifficulty(),
                problemDto.getDescription(),
                problemDto.getPoints(),
                problemDto.getProblemString(),
                problemDto.getProblemType(),
                problemDto.getProblemData(),
                problemDto.getFunctionString()
        );
    }

    @Override
    public Problem toEntity(CreateProblemRequestDto createProblemRequestDto) {
        return null;
    }

    @Override
    public Problem toEntity(UpdateProblemRequestDto updateProblemRequestDto) {
        return null;
    }

    @Override
    public ProblemResponseDto toDto(Problem problem) {
        return null;
    }

    @Override
    public List<ProblemResponseDto> toDto(List<Problem> problemList) {
        return List.of();
    }
}
