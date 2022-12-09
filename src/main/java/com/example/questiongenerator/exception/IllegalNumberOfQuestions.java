package com.example.questiongenerator.exception;

public class IllegalNumberOfQuestions extends RuntimeException{
    public IllegalNumberOfQuestions() {
    }

    public IllegalNumberOfQuestions(String message) {
        super(message);
    }
}
