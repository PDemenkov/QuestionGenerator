package com.example.questiongenerator.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IllegalNumberOfQuestions.class)

    public ResponseEntity<String> illegalNumberOfQ(IllegalNumberOfQuestions e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(value = QuestionNotExistException.class)
    public ResponseEntity<String> illegalQ(QuestionNotExistException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
