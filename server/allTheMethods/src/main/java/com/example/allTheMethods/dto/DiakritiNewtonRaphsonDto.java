package com.example.allTheMethods.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DiakritiNewtonRaphsonDto extends SubmissionDataDto{
    private int iterations;
    private int hParameter;
    private int xoParameter;
}
