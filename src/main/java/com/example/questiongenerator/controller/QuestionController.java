package com.example.questiongenerator.controller;

import com.example.questiongenerator.model.Question;
import com.example.questiongenerator.service.QuestionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class QuestionController {
    QuestionServiceImpl questionService;

    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/get")
    public Collection<Question> getSpecifiedQuestion(@RequestParam(value = "amount") int amount) {
        return null;
    }

    @PostMapping("/java/add")
    public Question addQuestion(@RequestParam(value = "question") String question,
                                @RequestParam(value = "answer") String answer) {
        return this.questionService.addQuestion(question, answer);

    }

    @DeleteMapping("/java/remove")
    public Question deleteQuestions(@RequestBody Question question) {
        return this.questionService.questionRemove(question);
    }

    @GetMapping("/java/find")
    public Question findQuestion(@RequestBody Question question) {
        return questionService.find(question);
    }

    @GetMapping("/java/getAll")
    public Collection<Question> printAllQuestions() {
        return this.questionService.getAll();
    }

    @GetMapping ("/java/randomQuestion")
    public Question randomQuestion() {
        return this.questionService.getRandomQuestion();
    }

}
