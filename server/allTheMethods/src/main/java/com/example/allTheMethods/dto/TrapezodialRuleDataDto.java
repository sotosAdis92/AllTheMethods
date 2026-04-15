package com.example.allTheMethods.dto;

import java.util.List;

public class TrapezodialRuleDataDto extends SubmissionDataDto{
    private int integrationPointA;
    private int integrationPointB;
    private int hParameter;

    public TrapezodialRuleDataDto(List<Double> inp, String problemString, int integrationPointA, int integrationPointB, int hParameter) {
        super(inp, problemString);
        this.integrationPointA = integrationPointA;
        this.integrationPointB = integrationPointB;
        this.hParameter = hParameter;
    }

    public TrapezodialRuleDataDto(int integrationPointA, int integrationPointB, int hParameter) {
        this.integrationPointA = integrationPointA;
        this.integrationPointB = integrationPointB;
        this.hParameter = hParameter;
    }

    public void setIntegrationPointA(int integrationPointA) {
        this.integrationPointA = integrationPointA;
    }

    public void setIntegrationPointB(int integrationPointB) {
        this.integrationPointB = integrationPointB;
    }

    public void sethParameter(int hParameter) {
        this.hParameter = hParameter;
    }

    public int getIntegrationPointA() {
        return integrationPointA;
    }

    public int getIntegrationPointB() {
        return integrationPointB;
    }

    public int gethParameter() {
        return hParameter;
    }
}
