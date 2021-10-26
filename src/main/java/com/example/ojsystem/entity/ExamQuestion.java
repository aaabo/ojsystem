package com.example.ojsystem.entity;

import java.util.List;

public class ExamQuestion {
    private Exam exam;
    private List<ChoiceQuestion> choiceQuestions;
    private List<CompletionQuestion> completionQuestions;
    private List<Exercise> exercises;

    public List<ChoiceQuestion> getChoiceQuestions() {
        return choiceQuestions;
    }

    public void setChoiceQuestions(List<ChoiceQuestion> choiceQuestions) {
        this.choiceQuestions = choiceQuestions;
    }

    public List<CompletionQuestion> getCompletionQuestions() {
        return completionQuestions;
    }

    public void setCompletionQuestions(List<CompletionQuestion> completionQuestions) {
        this.completionQuestions = completionQuestions;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }


}
