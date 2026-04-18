package com.example.allTheMethods.dto;

import java.util.List;

public class RichardsonDataDto extends SubmissionDataDto{
    private List<Integer> coutingParameters;
    private List<Integer> xiParameters;
    private List<Integer> fiParameters;
    private double xoParameter;
    private int firstHParameter;
    private int secondHParameter;

    public RichardsonDataDto(List<Double> inp, String problemString, List<Integer> coutingParameters, List<Integer> xiParameters, List<Integer> fiParameters, double xoParameter, int firstHParameter, int secondHParameter) {
        super(inp, problemString);
        this.coutingParameters = coutingParameters;
        this.xiParameters = xiParameters;
        this.fiParameters = fiParameters;
        this.xoParameter = xoParameter;
        this.firstHParameter = firstHParameter;
        this.secondHParameter = secondHParameter;
    }

    public List<Integer> getCoutingParameters() {
        return coutingParameters;
    }

    public void setCoutingParameters(List<Integer> coutingParameters) {
        this.coutingParameters = coutingParameters;
    }

    public List<Integer> getXiParameters() {
        return xiParameters;
    }

    public void setXiParameters(List<Integer> xiParameters) {
        this.xiParameters = xiParameters;
    }

    public List<Integer> getFiParameters() {
        return fiParameters;
    }

    public void setFiParameters(List<Integer> fiParameters) {
        this.fiParameters = fiParameters;
    }

    public double getXoParameter() {
        return xoParameter;
    }

    public void setXoParameter(double xoParameter) {
        this.xoParameter = xoParameter;
    }

    public int getFirstHParameter() {
        return firstHParameter;
    }

    public void setFirstHParameter(int firstHParameter) {
        this.firstHParameter = firstHParameter;
    }

    public int getSecondHParameter() {
        return secondHParameter;
    }

    public void setSecondHParameter(int secondHParameter) {
        this.secondHParameter = secondHParameter;
    }
}
