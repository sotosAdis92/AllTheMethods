package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.SubmissionDataDto;
import com.example.allTheMethods.dto.SubmissionDto;
import com.example.allTheMethods.entity.Submission;
import com.example.allTheMethods.mapper.SubmissionMapper;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.repository.SubmissionRepository;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.SubmmisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmmisionService {
    @Autowired
    private SubmissionRepository submissionRepository;
    private UsersRepository usersRepository;
    private ProblemRepository problemRepository;

    public SubmissionServiceImpl(SubmissionRepository submissionRepository, UsersRepository usersRepository, ProblemRepository problemRepository) {
        this.submissionRepository = submissionRepository;
        this.usersRepository = usersRepository;
        this.problemRepository = problemRepository;
    }

    @Override
    public SubmissionDto createSubmission(SubmissionDto submissionDto) {
        Submission submission = SubmissionMapper.mapToSubmission(submissionDto, usersRepository, problemRepository);
        Submission savedSubmission = submissionRepository.save(submission);
        return SubmissionMapper.mapToSubmissionDto(savedSubmission);
    }

    @Override
    public boolean checkData(SubmissionDataDto submissionDataDto) {
        boolean flag = false;
        int i=0;

        List<Float> input = submissionDataDto.getInputs();
        int length = submissionDataDto.getIterations();
        int Inta = submissionDataDto.getProblemSpaceA();
        int Intb = submissionDataDto.getProblemSpaceB();
        String problem = submissionDataDto.getProblemString();

        List<Float> list = new ArrayList<>();

        float a = (int)Inta;
        float b = (int)Intb;

        float x = 0;
        float resultX = 0;
        float resultA = 0;

        for(i=0;i<length;i++){
            x = (a+b)/2;
            resultX = fx(x);
            resultA = fa(a);
            if(resultX * resultA < 0){
                b = x;
            }
            else{
                a = x;
            }
            list.add(x);
        }
    }

    public static float fx(float x){

    }
    public static float fa(float a){

    }
}
