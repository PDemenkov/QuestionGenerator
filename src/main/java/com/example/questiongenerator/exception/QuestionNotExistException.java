package com.example.questiongenerator.exception;

public class QuestionNotExistException extends RuntimeException{

    public QuestionNotExistException() {
    }

    public QuestionNotExistException(String message) {
        super(message);
    }
}
