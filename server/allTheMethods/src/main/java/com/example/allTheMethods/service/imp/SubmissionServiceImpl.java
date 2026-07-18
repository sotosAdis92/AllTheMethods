package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.ast.AbstractTreeBuilder;
import com.example.allTheMethods.ast.Operation;
import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.*;
import com.example.allTheMethods.entity.Submission;
import com.example.allTheMethods.mapper.SubmissionMapper;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.repository.SubmissionRepository;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.SubmissionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class SubmissionServiceImpl implements SubmissionService {
    /* Dependency Injection for SubmissionServiceImpl Class */
    @Autowired
    private SubmissionRepository submissionRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ProblemRepository problemRepository;
    @Autowired
    private SubmissionMapper submissionMapper;

    @Override
    public SubmissionDto createSubmission(SubmissionDto submissionDto) {
        Submission submission = submissionMapper.mapToSubmission(submissionDto, usersRepository, problemRepository);
        Submission savedSubmission = submissionRepository.save(submission);
        return submissionMapper.mapToSubmissionDto(savedSubmission);
    }
}
