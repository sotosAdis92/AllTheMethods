package com.example.allTheMethods.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FivePointDerivativeDto extends SubmissionDataDto{
    private List<Integer> coutingParameters;
    private List<Integer> xiParameters;
    private List<Integer> fiParameters;
    private double xoParameter;
    private String typeOfDerivative;

    public FivePointDerivativeDto(List<Double> inp, String problemString, List<Integer> coutingParameters, List<Integer> xiParameters, List<Integer> fiParameters, double xoParameter, String typeOfDerivative) {
        super(inp, problemString);
        this.coutingParameters = coutingParameters;
        this.xiParameters = xiParameters;
        this.fiParameters = fiParameters;
        this.xoParameter = xoParameter;
        this.typeOfDerivative = typeOfDerivative;
    }
}
