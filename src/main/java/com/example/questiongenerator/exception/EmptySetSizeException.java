package com.example.questiongenerator.exception;

public class EmptySetSizeException extends RuntimeException {
    public EmptySetSizeException() {
    }

    public EmptySetSizeException(String message) {
        super(message);
    }
}
