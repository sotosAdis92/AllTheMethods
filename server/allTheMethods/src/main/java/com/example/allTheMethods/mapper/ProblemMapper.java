package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.request.CreateProblemRequest;
import com.example.allTheMethods.dto.request.UpdateProblemRequest;
import com.example.allTheMethods.dto.response.ProblemResponseDto;
import com.example.allTheMethods.entity.Problem;
import java.util.List;


public interface ProblemMapper {
    Problem toEntity(CreateProblemRequest createProblemRequest);
    Problem toEntity(UpdateProblemRequest updateProblemRequest);
    ProblemResponseDto toDto(Problem problem);
    List<ProblemResponseDto> toDto(List<Problem> problemList);
}
