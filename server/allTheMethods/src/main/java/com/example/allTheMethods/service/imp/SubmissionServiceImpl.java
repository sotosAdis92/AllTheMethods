package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.BisectionDataDto;
import com.example.allTheMethods.dto.RegulaFalsiDataDto;
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
    public boolean checkDataBisection(BisectionDataDto bisectionDataDto) {
        boolean flag = false;
        int i=0;
        int count = 0;

        List<Double> input = bisectionDataDto.getInp();
        int length = bisectionDataDto.getIterations();
        int Inta = bisectionDataDto.getProblemSpaceA();
        int Intb = bisectionDataDto.getProblemSpaceB();
        String problem = bisectionDataDto.getProblemString();

        System.out.println(problem);
        System.out.println(Inta);
        System.out.println();
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
            if(list.get(i) - input.get(i) == 0.000){
                count++;
            }
        }
        if(count==length){
            flag = true;
        }

        return flag;
    }


    @Override
    public boolean checkDataRegulaFalsi(RegulaFalsiDataDto regulaFalsiDataDto) {
        boolean flag  = false;
        int i = 0;
        int count = 0;

        List<Double> input = regulaFalsiDataDto.getInp();
        int length = regulaFalsiDataDto.getIterations();
        int Inta = regulaFalsiDataDto.getProblemSpaceA();
        int Intb = regulaFalsiDataDto.getProblemSpaceB();
        String problem = regulaFalsiDataDto.getProblemString();

        List<Double> list = new ArrayList<>();
        double x = 0;
        double a = Inta;
        double b = Intb;
        double resultX = 0;
        double resultA = 0;

        for(i=0;i<length;i++){
            x = b - (f())
        }

        return flag;
    }


    public static double fx(double x, String problem){
        Expression expression = new ExpressionBuilder(problem).variables("x").build().setVariable("x",x);
        double result = expression.evaluate();
        return result;
    }
    public static double fa(double a, String problem){
        Expression expression = new ExpressionBuilder(problem).variables("x").build().setVariable("x",a);
        double result = expression.evaluate();
        return result;
    }
    public static double fb(double b, String problem){
        Expression expression = new ExpressionBuilder(problem).variables("x").build().setVariable("x", b);
        double result = expression.evaluate();
        return result;
    }
}
