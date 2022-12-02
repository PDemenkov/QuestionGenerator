package com.example.questiongenerator.service;

import com.example.questiongenerator.exception.IllegalNumberOfQuestions;
import com.example.questiongenerator.model.Question;
import com.example.questiongenerator.services.ExamineService;
import com.example.questiongenerator.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExamineService {
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection <Question> getQuestions(int amount) {
        Set<Question> toCopy = new HashSet<>();
        if (amount > questionService.getAll().size()) {
            throw new IllegalNumberOfQuestions("Вопросов не может быть больше, чем с списке");
        }
        while (toCopy.size()<amount) {
            toCopy.add(questionService.getRandomQuestion());
        }
        return toCopy ;
    }


}
