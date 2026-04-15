package com.example.allTheMethods.dto;

import java.util.List;

public class TrapezodialRuleDataDto extends SubmissionDataDto{
    private int integrationPointA;
    private int integrationPointB;
    private double hParameter;

    public TrapezodialRuleDataDto(List<Double> inp, String problemString, int integrationPointA, int integrationPointB, double hParameter) {
        super(inp, problemString);
        this.integrationPointA = integrationPointA;
        this.integrationPointB = integrationPointB;
        this.hParameter = hParameter;
    }

    public int getIntegrationPointA() {
        return integrationPointA;
    }

    public int getIntegrationPointB() {
        return integrationPointB;
    }

    public double gethParameter() {
        return hParameter;
    }

    public void setIntegrationPointA(int integrationPointA) {
        this.integrationPointA = integrationPointA;
    }

    public void setIntegrationPointB(int integrationPointB) {
        this.integrationPointB = integrationPointB;
    }

    public void sethParameter(double hParameter) {
        this.hParameter = hParameter;
    }
}
