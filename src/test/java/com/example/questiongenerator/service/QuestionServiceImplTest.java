package com.example.questiongenerator.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.example.questiongenerator.exception.QuestionNotExistException;
import com.example.questiongenerator.model.Question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.Random;

class QuestionServiceImplTest {
    @Mock
    Random rnd = new Random();
    @InjectMocks
    QuestionServiceImpl questionService = new QuestionServiceImpl();


    @BeforeEach
    void setUp() {
        Question question = new Question("Question1", "Answer1");
        questionService.addQuestion(question);
        Question question2 = new Question("Question2", "Answer2");
        questionService.addQuestion(question2);
        Question question3 = new Question("Question3", "Answer3");
        questionService.addQuestion(question3);
    }

    @Test
    void AddQuestionEqualsObjects() {
        Question actualAddQuestionResult =questionService.addQuestion("Question", "Answer");
        assertEquals("Answer", actualAddQuestionResult.getAnswer());
        assertEquals("Question", actualAddQuestionResult.getQuestion());
    }

    @Test
    void AddQuestionAsObject() {
        Question question4 = new Question("Question4", "Answer4");
        assertSame(question4, questionService.addQuestion(question4));
        assertEquals(4, questionService.getAll().size());
    }

    @Test
    void QuestionRemove() {
        Question question = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");
        questionService.questionRemove(question);
        questionService.questionRemove(question2);
        assertEquals(1, questionService.getAll().size());
    }
        @Test
        void QuestionRemoveException() {
            Question question2 = new Question("Question5", "Answer5");
        assertThrows(QuestionNotExistException.class,
                () -> questionService.questionRemove(question2));
    }

    @Test
    void tFind() {
        Question question = new Question("Question1", "Answer1");
        assertSame(question, questionService.find(question));
    }

    @Test
    void FindException() {
        Question question = new Question("Question13", "Answer13");
        assertThrows(QuestionNotExistException.class, () -> questionService.find(question));
    }

    @Test
    void getRandomQuestion() {
//
//        Mockito.when(rnd.nextInt(Integer.MAX_VALUE)).thenReturn(1);
////        Mockito.when(rnd.nextInt(1,52)).thenReturn(1);
    }

    @Test
    void getAll() {
        assertSame(3,questionService.getAll().size());
        assertTrue((new QuestionServiceImpl()).getAll().isEmpty());
    }
}

