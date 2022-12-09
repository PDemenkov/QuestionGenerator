package com.example.questiongenerator.service;

import com.example.questiongenerator.model.Question;
import com.example.questiongenerator.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;
@Service
public class MathQuestionService implements QuestionService {

    @Override
    public Question addQuestion(String question, String answer) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    public Question addQuestion(Question question) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    public Question questionRemove(Question question) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    public Collection<Question> getAll() {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    public Question getRandomQuestion() {
        MathOperation mathOperation = MathOperation.values()[ThreadLocalRandom.current().nextInt(0, MathOperation.values().length)];
        int num1 = ThreadLocalRandom.current().nextInt(1,100);
        int num2 = ThreadLocalRandom.current().nextInt(1,100);
        return new Question(mathOperation.getQuestion(num1, num2), String.valueOf(mathOperation.getAnswer(num1, num2)));
    }

    @Override
    public Question find(Question question) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }
}
