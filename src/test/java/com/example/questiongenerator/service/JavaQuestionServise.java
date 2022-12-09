package com.example.questiongenerator.service;

import com.example.questiongenerator.exception.EmptySetSizeException;
import com.example.questiongenerator.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JavaQuestionServise {

    private QuestionServiceImpl questionService;

    private List<Question> questions = List.of(
            new Question("q1", "a1"),
            new Question("q2", "a2"),
            new Question("q3", "a3"),
            new Question("q4", "a4"),
            new Question("q5", "a5")
    );

    @BeforeEach
    void setUp() {
        this.questionService = new QuestionServiceImpl();
        questions.forEach(questionService::addQuestion);
    }

    @Test
    void addQuestion() {
        Question question = new Question("q6", "a6");
    Question actual = this.questionService.addQuestion(question);
        assertThat(actual).isEqualTo(question);
        assertThat(this.questionService.getAll())
                .hasSize(6)
                .contains(question);

    }

    @Test
    void removeQuestionTest() {
        Question expected = this.questions.get(0);
        Question actual = this.questionService.questionRemove(expected);
        assertThat(actual).isEqualTo(expected);
        assertThat(this.questionService.getAll())
                .hasSize(4)
                .doesNotContain(expected);
    }

    @Test
    void    getRandomQuestion() {
        Question actual = this.questionService.getRandomQuestion();
        assertThat(actual).isIn(questions);
    }

    @Test
    void  getAllTest() {
        assertThat(this.questionService.getAll()).hasSize(5).containsAll(this.questions);
    }

//    @Test
//    void whenListIsEmptyThenGetRandomQuestio() {
//        assertThatThrownBy(() -> questionService.getRandomQuestion())
//                .isInstanceOf(EmptySetSizeException.class);
//    }
}
