package com.example.allTheMethods.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class BisectionDataDto extends SubmissionDataDto{
    private int iterations;
    private int problemSpaceA;
    private int problemSpaceB;
}
