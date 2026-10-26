package com.example.allTheMethods.mapper.imp;
import com.example.allTheMethods.dto.request.CreateProblemRequest;
import com.example.allTheMethods.dto.request.UpdateProblemRequest;
import com.example.allTheMethods.dto.response.ProblemResponse;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.mapper.ProblemMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProblemMapperImpl implements ProblemMapper {

    @Override
    public Problem toEntity(CreateProblemRequest createProblemRequest) {
        Problem problem = new Problem(
            null,
            createProblemRequest.number(),
                createProblemRequest.title(),
                createProblemRequest.category(),
                createProblemRequest.difficulty(),
                createProblemRequest.description(),
                createProblemRequest.points(),
                createProblemRequest.problemString(),
                createProblemRequest.problemType(),
                createProblemRequest.functionString(),
                createProblemRequest.problemData()
        );
        return problem;
    }

    @Override
    public Problem toEntity(UpdateProblemRequest updateProblemRequest) {
        Problem problem = new Problem(
                null,
                updateProblemRequest.number(),
                updateProblemRequest.title(),
                updateProblemRequest.category(),
                updateProblemRequest.difficulty(),
                updateProblemRequest.description(),
                updateProblemRequest.points(),
                updateProblemRequest.problemString(),
                updateProblemRequest.problemType(),
                updateProblemRequest.functionString(),
                updateProblemRequest.problemData()
        );
        return problem;
    }

    @Override
    public ProblemResponse toDto(Problem problem) {
        return new ProblemResponse(
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
    public List<ProblemResponse> toDto(List<Problem> problemList) {
        return problemList.stream().map(this::toDto).toList();
    }
}
