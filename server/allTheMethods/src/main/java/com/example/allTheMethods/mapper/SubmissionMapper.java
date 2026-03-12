package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.SubmissionDto;
import com.example.allTheMethods.entity.Submission;

public class SubmissionMapper {
    public static SubmissionDto mapToSubmissionDto(Submission submission){
        return new SubmissionDto(
                submission.getId(),
                submission.getUser().getId(),
                submission.getProblem().getId(),
                submission.getDate(),
                submission.getValid()
        );
    }

}
