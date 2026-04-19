package com.example.allTheMethods.dto;

import java.util.List;

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

    public int gethParameter() {
        return hParameter;
    }

    public void sethParameter(int hParameter) {
        this.hParameter = hParameter;
    }

}
