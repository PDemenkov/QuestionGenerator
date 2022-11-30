package com.example.questiongenerator.controller;

import com.example.questiongenerator.model.Question;
import com.example.questiongenerator.service.ExaminerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
@RequestMapping("/exam")
public class ExamineController {
    ExaminerServiceImpl examinerService;

    public ExamineController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/java/amount")
    public Collection<Question> getQuestions(@RequestParam(value = "amount") int amount) {
        return this.examinerService.getQuestions(amount);
    }
}
