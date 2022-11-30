package com.example.questiongenerator.services;

import com.example.questiongenerator.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface ExamineService {

    Collection<Question> getQuestions(int amount);
}
