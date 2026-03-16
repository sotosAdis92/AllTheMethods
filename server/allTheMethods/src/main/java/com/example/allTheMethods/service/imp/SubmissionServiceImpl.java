package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.SubmissionDataDto;
import com.example.allTheMethods.dto.SubmissionDto;
import com.example.allTheMethods.entity.Submission;
import com.example.allTheMethods.mapper.SubmissionMapper;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.repository.SubmissionRepository;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.SubmmisionService;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
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
        int count = 0;

        List<Double> input = submissionDataDto.getInputs();
        int length = submissionDataDto.getIterations();
        int Inta = submissionDataDto.getProblemSpaceA();
        int Intb = submissionDataDto.getProblemSpaceB();
        String problem = submissionDataDto.getProblemString();

        List<Double> list = new ArrayList<>();

        double a = (int)Inta;
        double b = (int)Intb;

        double x = 0;
        double resultX = 0;
        double resultA = 0;

        for(i=0;i<length;i++){
            x = (a+b)/2;
            resultX = fx(x, problem);
            resultA = fa(a, problem);
            if(resultX * resultA < 0){
                b = x;
            }
            else{
                a = x;
            }
            list.add(x);
            System.out.println(x);
        }

        for(i=0;i<length;i++){
            if(Double.compare(list.get(i),input.get(i)) == 0){
                count++;
            }
        }
        if(count==length){
            flag = true;
        }

        return flag;
    }


    public static double fx(double x, String problem){
        Expression expression = new ExpressionBuilder(problem).variables("X").build().setVariable("X",x);
        double result = expression.evaluate();
        return result;
    }
    public static double fa(double a, String problem){
        Expression expression = new ExpressionBuilder(problem).variables("X").build().setVariable("X",a);
        double result = expression.evaluate();
        return result;
    }
}
