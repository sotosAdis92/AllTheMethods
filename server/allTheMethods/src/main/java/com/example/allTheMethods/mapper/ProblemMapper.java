package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.request.CreateProblemRequestDto;
import com.example.allTheMethods.dto.request.UpdateProblemRequestDto;
import com.example.allTheMethods.dto.response.ProblemResponseDto;
import com.example.allTheMethods.entity.Problem;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ProblemMapper {
    Problem toEntity(CreateProblemRequestDto createProblemRequestDto);
    Problem toEntity(UpdateProblemRequestDto updateProblemRequestDto);
    ProblemResponseDto toDto(Problem problem);
    List<ProblemResponseDto> toDto(List<Problem> problemList);
}
