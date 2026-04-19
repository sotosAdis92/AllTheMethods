package com.example.allTheMethods.dto;

public class GerschgorinCirclesDto extends SubmissionDataDto{
    private int[][] inputMatrix;

    public GerschgorinCirclesDto(int[][] inputMatrix) {
        this.inputMatrix = inputMatrix;
    }

    public int[][] getInputMatrix() {
        return inputMatrix;
    }

    public void setInputMatrix(int[][] inputMatrix) {
        this.inputMatrix = inputMatrix;
    }
}
