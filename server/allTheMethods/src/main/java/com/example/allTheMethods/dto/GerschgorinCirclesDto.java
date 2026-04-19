package com.example.allTheMethods.dto;

public class GerschgorinCirclesDto extends SubmissionDataDto{
    private int[][] inputMatrix;
    private int nSize;
    private int mSize;

    public GerschgorinCirclesDto(int[][] inputMatrix, int nSize, int mSize) {
        this.inputMatrix = inputMatrix;
        this.nSize = nSize;
        this.mSize = mSize;
    }

    public int[][] getInputMatrix() {
        return inputMatrix;
    }

    public void setInputMatrix(int[][] inputMatrix) {
        this.inputMatrix = inputMatrix;
    }

    public int getnSize() {
        return nSize;
    }

    public void setnSize(int nSize) {
        this.nSize = nSize;
    }

    public int getmSize() {
        return mSize;
    }

    public void setmSize(int mSize) {
        this.mSize = mSize;
    }
}
