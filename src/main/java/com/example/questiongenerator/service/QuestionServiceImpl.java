package com.example.questiongenerator.service;

import com.example.questiongenerator.exception.EmptySetSizeException;
import com.example.questiongenerator.exception.QuestionNotExistException;
import com.example.questiongenerator.model.Question;
import com.example.questiongenerator.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final static Random RANDOM = new Random();
    private final Set<Question> questionSet = new HashSet<>();

    @Override
    public Question addQuestion(String question, String answer) {
        Question questionObj = new Question(question, answer);
        this.questionSet.add(questionObj);
        return questionObj;
    }

    @Override
    public Question addQuestion(Question question) {
        this.questionSet.add(question);
        return question;
    }

    @Override
    public Question questionRemove(Question question) {
        if (!questionSet.contains(question)) {
            throw new QuestionNotExistException("Такого вопроса нет");
        } else {
            questionSet.remove(question);
        }
        return question;
    }


    @Override
    public Question find(Question question) {
        if (!questionSet.contains(question)) {
            throw new QuestionNotExistException("Вопрос не найден");
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return this.questionSet;
    }

    @Override
    public Question getRandomQuestion() {
        Question[] arrayNum = questionSet.toArray(new Question[questionSet.size()]);
        Random rnd = new Random();
        if (questionSet.size() == 0) {
            throw new EmptySetSizeException("Список пуст");
        }
        int randomNum = rnd.nextInt(questionSet.size());
        return arrayNum[randomNum];
    }

//    @Override
//    public Question getRandomQuestion() {
//        return questionSet
//                .stream()
//                .skip(RANDOM.nextInt(0, questionSet.size()))
//                .findFirst()
//                .orElseThrow();
//    }

}
