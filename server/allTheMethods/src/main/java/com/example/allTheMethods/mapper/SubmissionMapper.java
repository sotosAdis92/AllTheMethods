package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.SubmissionDto;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.Submission;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.repository.UsersRepository;
import org.springframework.stereotype.Component;

@Component
public class SubmissionMapper {
    public static SubmissionDto mapToSubmissionDto(Submission submission){
        return new SubmissionDto(
                submission.getId(),
                submission.getUser().getId(),
                submission.getProblem().getId(),
                submission.getDate()
        );
    }
    public static Submission mapToSubmission(SubmissionDto submissionDto, UsersRepository usersRepository, ProblemRepository problemRepository){
        Users user =  usersRepository.findById(submissionDto.getUserId()).orElseThrow();
        Problem problem = problemRepository.findById(submissionDto.getProblemId()).orElseThrow();
        Submission submission = new Submission();
        submission.setDate(submissionDto.getSubmittedAt());
        submission.setUser(user);
        submission.setProblem(problem);
        return submission;
    }
}
