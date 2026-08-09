package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.CreateSubmissionRequestDto;
import com.example.allTheMethods.dto.response.SubmissionResponse;
import com.example.allTheMethods.entity.Submission;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.SubmissionMapper;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.repository.SubmissionRepository;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.SubmissionService;
import com.example.allTheMethods.utils.JWTUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SubmissionServiceImpl implements SubmissionService {
    /* Dependency Injection for SubmissionServiceImpl Class */
    private SubmissionRepository submissionRepository;
    private UsersRepository usersRepository;
    private ProblemRepository problemRepository;
    private SubmissionMapper submissionMapper;
    private final JWTUtil jwtUtil;

    public SubmissionServiceImpl(SubmissionRepository submissionRepository,JWTUtil jwtUtil, UsersRepository usersRepository, ProblemRepository problemRepository, SubmissionMapper submissionMapper) {
        this.submissionRepository = submissionRepository;
        this.jwtUtil = jwtUtil;
        this.usersRepository = usersRepository;
        this.problemRepository = problemRepository;
        this.submissionMapper = submissionMapper;
    }

    @Override
    public SubmissionResponse createSubmission(CreateSubmissionRequestDto submissionDto) {
        Submission submission = submissionMapper.toEntity(submissionDto);
        Submission savedSubmission = submissionRepository.save(submission);
        return submissionMapper.toDto(savedSubmission);
    }

    @Override
    public Page<SubmissionResponse> getSubmissionsByUserId(int id, Pageable pageable) {
        Users user = jwtUtil.getLoggedInUser();
        if(user!=null){
            Page<SubmissionResponse> submissionResponses = submissionMapper.toDto(submissionRepository.findAllByUserId((long) id, pageable));
            return submissionResponses;
        }
        throw new EntityNotFoundException("User not found");
    }

    @Override
    public Page<SubmissionResponse> getAllSubmissions(Pageable pageable) {
        Page<SubmissionResponse> submissionResponses = submissionMapper.toDto(submissionRepository.findAll(pageable));
        return submissionResponses;
    }


}
