package com.example.allTheMethods.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TrapezodialRuleDataDto extends SubmissionDataDto{
    public TrapezodialRuleDataDto() {
    }
    private int integrationPointA;
    private int integrationPointB;
    private double hParameter;

    public TrapezodialRuleDataDto(List<Double> inp, String problemString, int integrationPointA, int integrationPointB, double hParameter) {
        super(inp, problemString);
        this.integrationPointA = integrationPointA;
        this.integrationPointB = integrationPointB;
        this.hParameter = hParameter;
    }
}
