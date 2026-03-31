package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.*;
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
    /* Dependency Injection for SubmissionServiceImpl Class */
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

    /*
    Method Implementation of Bisection Method, the method takes in a bisectionData object
    and through the bisection method creates its own list of outputs, and compares that list
    with the list of inputs from the user, if the list matches within 3 significant digits of
    the correct answer, for all the numbers entered by the client, then it returns true.
     */
    @Override
    public boolean checkDataBisection(BisectionDataDto bisectionDataDto) {
        boolean flag = false;
        int i=0;
        int count = 0;
        int decimalPoint = 3;

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
            x = truncateDecimalPlaces(x,decimalPoint);
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

    /*
    Method Implementation of Regula-Falsi Method, the method takes in a regulaFalsiData object
    and through the Regula-Falsi Method creates its own list of outputs, and compares that list
    with the list of inputs from the user, if the list matches within 3 significant digits of
    the correct answer, for all the numbers entered by the client, then it returns true.
     */
    @Override
    public boolean checkDataRegulaFalsi(RegulaFalsiDataDto regulaFalsiDataDto) {
        boolean flag  = false;
        int i = 0;
        int count = 0;
        int decimalPoint = 3;

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
            x = b - ( fb(b,problem) * (b - a) / (fb(b,problem) - fa(a, problem) ));
            resultX = fx(x, problem);
            resultA = fa(a, problem);
            if(resultX * resultA < 0){
                b = x;
            }
            else{
                a = x;
            }
            x = truncateDecimalPlaces(x,decimalPoint);
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

    /*
    Method Implementation of Newton-Raphson Method, the method takes in a newtonRaphson object
    and through the Newton-Raphson Method creates its own list of outputs, and compares that list
    with the list of inputs from the user, if the list matches within 3 significant digits of
    the correct answer, for all the numbers entered by the client, then it returns true.
     */
    @Override
    public boolean checkDataNewtonRaphson(NewtonRaphsonDataDto newtonRaphsonDataDto) {
        boolean flag = false;
        int i = 0;
        int count = 0;
        int decimalPoint = 3;
        int xo = newtonRaphsonDataDto.getXo();
        List<Double> inputs = newtonRaphsonDataDto.getInp();
        String problem = newtonRaphsonDataDto.getProblemString();
        int iterations = newtonRaphsonDataDto.getIterations();

        double x = 0;
        List<Double> list = new ArrayList<>();

        for(i=0;i<iterations;i++){
            x = xo - (fx(x,problem)/fprime(x,problem));
            x = truncateDecimalPlaces(x, decimalPoint);
            list.add(x);
            System.out.println(x);
        }
        for(i=0;i<iterations;i++){
            if(list.get(i) - inputs.get(i) == 0.000){
                count++;
            }
        }
        if(count==iterations){
            flag = true;
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
    public static double truncateDecimalPlaces(double x, int decimalPoint){
        x = x * Math.pow(10, decimalPoint); //shift the decimal of the value to the given decimal 10^n
        x = Math.floor(x); //floor the number
        x = x / Math.pow(10, decimalPoint); //divide by 10^n
        //this extracts the integer part while keeping the shift
        return x;
    }
    private double fprime(double x, String problem) {


    }
}
