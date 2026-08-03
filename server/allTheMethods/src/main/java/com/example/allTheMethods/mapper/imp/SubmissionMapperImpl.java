package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.request.CreateSubmissionRequestDto;
import com.example.allTheMethods.dto.response.SubmissionResponse;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.Submission;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.SubmissionMapper;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.repository.UsersRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubmissionMapperImpl implements SubmissionMapper {
    private final UsersRepository usersRepository;
    private final ProblemRepository problemRepository;

    public SubmissionMapperImpl(UsersRepository usersRepository, ProblemRepository problemRepository) {
        this.usersRepository = usersRepository;
        this.problemRepository = problemRepository;
    }

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

    @Override
    public Page<SubmissionResponse> toDto(Page<Submission> submissionPage) {
        return submissionPage.map(this::toDto);
    }

    @Override
    public Submission toEntity(CreateSubmissionRequestDto createSubmissionRequestDto){
        Users user = usersRepository.findById(createSubmissionRequestDto.userId()).orElseThrow(() -> new RuntimeException("User not found with an Id:" + createSubmissionRequestDto.userId()));
        Problem problem = problemRepository.findById(createSubmissionRequestDto.problemId()).orElseThrow(() -> new RuntimeException("User not found with an Id:" + createSubmissionRequestDto.problemId()));
        Submission submission = new Submission();
        submission.setDate(createSubmissionRequestDto.submittedAt());
        submission.setUser(user);
        submission.setProblem(problem);
        return submission;
    }
}
