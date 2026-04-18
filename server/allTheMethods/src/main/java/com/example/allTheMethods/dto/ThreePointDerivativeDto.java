package com.example.allTheMethods.dto;

import java.util.List;

public class ThreePointDerivativeDto extends SubmissionDataDto{
    private List<Integer> coutingParameters;
    private List<Double> xiParameters;
    private List<Integer> fiParameters;
    private double xoParameter;

    public ThreePointDerivativeDto(List<Double> inp, String problemString, List<Integer> coutingParameters, List<Double> xiParameters, List<Integer> fiParameters, double xoParameter) {
        super(inp, problemString);
        this.coutingParameters = coutingParameters;
        this.xiParameters = xiParameters;
        this.fiParameters = fiParameters;
        this.xoParameter = xoParameter;
    }

    public void setCoutingParameters(List<Integer> coutingParameters) {
        this.coutingParameters = coutingParameters;
    }

    public void setXiParameters(List<Double> xiParameters) {
        this.xiParameters = xiParameters;
    }

    public void setFiParameters(List<Integer> fiParameters) {
        this.fiParameters = fiParameters;
    }

    public void setXoParameter(double xoParameter) {
        this.xoParameter = xoParameter;
    }

    public List<Integer> getCoutingParameters() {
        return coutingParameters;
    }

    public List<Double> getXiParameters() {
        return xiParameters;
    }

    public List<Integer> getFiParameters() {
        return fiParameters;
    }

    public double getXoParameter() {
        return xoParameter;
    }
}
