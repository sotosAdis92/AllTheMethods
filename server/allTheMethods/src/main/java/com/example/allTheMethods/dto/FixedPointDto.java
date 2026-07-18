package com.example.allTheMethods.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FixedPointDto extends SubmissionDataDto{
    private int iterations;
    private int xo;
}
