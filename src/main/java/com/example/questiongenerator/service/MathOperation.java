package com.example.questiongenerator.service;

public enum MathOperation {
    PLUS("+"),
    MINUS("-"),
    MULTI("*"),
    DIVIDE("/");

    private final String sign;

    MathOperation(String sign) {
        this.sign = sign;
    }

    public int getAnswer(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Zero Divide");
        }
        return switch (this) {
            case PLUS -> num1 + num2;
            case MINUS -> num1 - num2;
            case MULTI -> num1 * num2;
            case DIVIDE -> num1 / num2;
        };
    }

    public String getQuestion(int numa1,int num2) {
        return String.format("%d %s %d = ?", numa1, this.sign, num2);
    }
}


