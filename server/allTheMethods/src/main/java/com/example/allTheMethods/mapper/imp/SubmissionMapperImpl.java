package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.SubmissionDto;
import com.example.allTheMethods.dto.response.SubmissionResponse;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.Submission;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.SubmissionMapper;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.repository.UsersRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubmissionMapperImpl implements SubmissionMapper {

    public SubmissionResponse toDto(Submission submission){
        if(submission == null){
            return null;
        }
        return new SubmissionResponse(
                submission.getId(),
                submission.getDate(),
                submission.getProblem().getNumber(),
                submission.getProblem().getTitle(),
                submission.getProblem().getDifficulty()
        );
    }

    public List<SubmissionResponse> toDto(List<Submission> submissions){
        if(submissions == null){
            return null;
        }
        return submissions.stream().map(this::toDto).collect(Collectors.toList());
    }

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
