package com.example.allTheMethods.dto.request;

import com.example.allTheMethods.dto.SubmissionDataDto;

import java.util.List;

public class SimpsonDataDto extends SubmissionDataDto {
    private int integrationSpaceA;
    private int integrationSpaceB;
    private double hParameter;

    public SimpsonDataDto(List<Double> inp, String problemString, int integrationSpaceA, int integrationSpaceB, double hParameter) {
        super(inp, problemString);
        this.integrationSpaceA = integrationSpaceA;
        this.integrationSpaceB = integrationSpaceB;
        this.hParameter = hParameter;
    }

    public SimpsonDataDto(List<Double> inp, String problemString) {
        super(inp, problemString);
    }

    public int getIntegrationSpaceA() {
        return integrationSpaceA;
    }

    public int getIntegrationSpaceB() {
        return integrationSpaceB;
    }

    public double gethParameter() {
        return hParameter;
    }

    public void setIntegrationSpaceA(int integrationSpaceA) {
        this.integrationSpaceA = integrationSpaceA;
    }

    public void setIntegrationSpaceB(int integrationSpaceB) {
        this.integrationSpaceB = integrationSpaceB;
    }

    public void sethParameter(double hParameter) {
        this.hParameter = hParameter;
    }
}
