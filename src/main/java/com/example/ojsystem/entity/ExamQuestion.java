package com.example.ojsystem.entity;

import java.util.List;

public class ExamQuestion {
    private int examQuestionId;
    private ChoiceQuestion choiceQuestion;
    private CompletionQuestion completionQuestion;
    private Exercise exercise;


    public int getExamQuestionId() {
        return examQuestionId;
    }

    public void setExamQuestionId(int examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    public ChoiceQuestion getChoiceQuestion() {
        return choiceQuestion;
    }

    public void setChoiceQuestion(ChoiceQuestion choiceQuestion) {
        this.choiceQuestion = choiceQuestion;
    }

    public CompletionQuestion getCompletionQuestion() {
        return completionQuestion;
    }

    public void setCompletionQuestion(CompletionQuestion completionQuestion) {
        this.completionQuestion = completionQuestion;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
