package com.example.allTheMethods.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RichardsonDataDto extends SubmissionDataDto{
    private List<Integer> coutingParameters;
    private List<Integer> xiParameters;
    private List<Integer> fiParameters;
    private double xoParameter;
    private int hParameter;


    public RichardsonDataDto(List<Double> inp, String problemString, List<Integer> coutingParameters, List<Integer> xiParameters, List<Integer> fiParameters, double xoParameter, int hParameter, int secondHParameter) {
        super(inp, problemString);
        this.coutingParameters = coutingParameters;
        this.xiParameters = xiParameters;
        this.fiParameters = fiParameters;
        this.xoParameter = xoParameter;
        this.hParameter = hParameter;
    }

}
