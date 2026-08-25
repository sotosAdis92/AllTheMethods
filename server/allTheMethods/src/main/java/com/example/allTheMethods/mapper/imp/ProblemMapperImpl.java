package com.example.allTheMethods.mapper.imp;
import com.example.allTheMethods.dto.request.CreateProblemRequestDto;
import com.example.allTheMethods.dto.request.UpdateProblemRequestDto;
import com.example.allTheMethods.dto.response.ProblemResponseDto;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.mapper.ProblemMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProblemMapperImpl implements ProblemMapper {

    @Override
    public Problem toEntity(CreateProblemRequestDto createProblemRequestDto) {
        Problem problem = new Problem(
            null,
            createProblemRequestDto.number(),
                createProblemRequestDto.title(),
                createProblemRequestDto.category(),
                createProblemRequestDto.difficulty(),
                createProblemRequestDto.description(),
                createProblemRequestDto.points(),
                createProblemRequestDto.problemString(),
                createProblemRequestDto.problemType(),
                createProblemRequestDto.functionString(),
                createProblemRequestDto.problemData()
        );
        return problem;
    }

    @Override
    public Problem toEntity(UpdateProblemRequestDto updateProblemRequestDto) {
        Problem problem = new Problem(
                null,
                updateProblemRequestDto.number(),
                updateProblemRequestDto.title(),
                updateProblemRequestDto.category(),
                updateProblemRequestDto.difficulty(),
                updateProblemRequestDto.description(),
                updateProblemRequestDto.points(),
                updateProblemRequestDto.problemString(),
                updateProblemRequestDto.problemType(),
                updateProblemRequestDto.functionString(),
                updateProblemRequestDto.problemData()
        );
        return problem;
    }

    @Override
    public ProblemResponseDto toDto(Problem problem) {
        return new ProblemResponseDto(
                problem.getId(),
                problem.getNumber(),
                problem.getTitle(),
                problem.getCategory(),
                problem.getDifficulty(),
                problem.getDescription(),
                problem.getPoints(),
                problem.getProblemString(),
                problem.getProblemType(),
                problem.getFunctionString(),
                problem.getProblemData()
        );
    }

    @Override
    public List<ProblemResponseDto> toDto(List<Problem> problemList) {
        return problemList.stream().map(this::toDto).toList();
    }
}
