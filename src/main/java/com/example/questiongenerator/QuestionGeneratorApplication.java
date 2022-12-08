package com.example.questiongenerator;

import com.example.questiongenerator.controller.ExamineController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@OpenAPIDefinition
public class QuestionGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionGeneratorApplication.class, args);
    }

}
