package com.example.questiongenerator.service;

import com.example.questiongenerator.exception.IllegalNumberOfQuestions;
import com.example.questiongenerator.model.Question;
import com.example.questiongenerator.services.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamineServiceImplTest {

    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerServiceImpl;

    @Test
    void testGetQuestions() {
        when(questionService.getAll()).thenReturn(new ArrayList<>());
        assertTrue(examinerServiceImpl.getQuestions(0).isEmpty());
        verify(questionService).getAll();
    }

    @Test
    void GetQuestionsException() {
        when(questionService.getAll()).thenThrow(new IllegalNumberOfQuestions("Вопросов больше чем в списке"));
        assertThrows(IllegalNumberOfQuestions.class, () -> examinerServiceImpl.getQuestions(10));
        verify(questionService).getAll();
    }

    @Test
    void testGetQuestionsWhenReturnRandom() {
        ArrayList<Question> questionList = new ArrayList<>();
        Question question6 = new Question("Question6", "Question6");
        Question question4 = new Question("Question4", "Question4");
        questionList.add(question4);
        questionList.add(question6);
        when(questionService.getRandomQuestion()).thenReturn(question4);
        when(questionService.getAll()).thenReturn(questionList);
        assertEquals(1, examinerServiceImpl.getQuestions(1).size());
        verify(questionService).getRandomQuestion();
        verify(questionService).getAll();
    }
}
