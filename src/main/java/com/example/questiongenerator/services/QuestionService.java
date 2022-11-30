package com.example.questiongenerator.services;

import com.example.questiongenerator.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface QuestionService {

    Question addQuestion(String question, String answer);

    Question addQuestion(Question question);

    Question questionRemove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
    Question find(Question question);
}
