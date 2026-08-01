package com.example.allTheMethods.dto.request;

import com.example.allTheMethods.dto.SubmissionDataDto;

public class DiakritiNewtonRaphsonDto extends SubmissionDataDto {
    private int iterations;
    private int hParameter;
    private int xoParameter;

    public DiakritiNewtonRaphsonDto() {
    }

    public int getIterations() {
        return iterations;
    }

    public int gethParameter() {
        return hParameter;
    }

    public int getXoParameter() {
        return xoParameter;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public void sethParameter(int hParameter) {
        this.hParameter = hParameter;
    }

    public void setXoParameter(int xoParameter) {
        this.xoParameter = xoParameter;
    }
}
