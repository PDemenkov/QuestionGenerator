package com.example.questiongenerator.controller;

import com.example.questiongenerator.model.Question;
import com.example.questiongenerator.service.QuestionServiceImpl;
import com.example.questiongenerator.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

//    @PostMapping("/add")
//    public Question addQuestion(@RequestParam(value = "question") String question,
//                                @RequestParam(value = "answer") String answer) {
//        return this.questionService.addQuestion(question, answer);
//    }
    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question) {
        return this.questionService.addQuestion(question);
    }

    @DeleteMapping("/remove")
    public Question deleteQuestions(@RequestBody Question question) {
        return this.questionService.questionRemove(question);
    }

    @GetMapping("/find")
    public Question findQuestion(@RequestBody Question question) {
        return questionService.find(question);
    }

    @GetMapping("/getAll")
    public Collection<Question> printAllQuestions() {
        return this.questionService.getAll();
    }

    @GetMapping("/randomQuestion")
    public Question randomQuestion() {
        return this.questionService.getRandomQuestion();
    }

}
