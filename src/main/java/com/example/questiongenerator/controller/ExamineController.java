package com.example.questiongenerator.controller;

import com.example.questiongenerator.model.Question;
import com.example.questiongenerator.service.ExaminerServiceImpl;
import com.example.questiongenerator.services.ExamineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamineController {
    private ExamineService examinerService;

    public ExamineController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/java/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return this.examinerService.getQuestions(amount);
    }
}
