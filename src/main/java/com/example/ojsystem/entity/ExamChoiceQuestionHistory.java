package com.example.ojsystem.entity;

public class ExamChoiceQuestionHistory {
    private int examChoiceQuestionHistoryId;
    private String examChoiceQuestionUserSelection;

    private User user;
    private ExamQuestion examQuestion;


    public int getExamChoiceQuestionHistoryId() {
        return examChoiceQuestionHistoryId;
    }

    public void setExamChoiceQuestionHistoryId(int examChoiceQuestionHistoryId) {
        this.examChoiceQuestionHistoryId = examChoiceQuestionHistoryId;
    }

    public String getExamChoiceQuestionUserSelection() {
        return examChoiceQuestionUserSelection;
    }

    public void setExamChoiceQuestionUserSelection(String examChoiceQuestionUserSelection) {
        this.examChoiceQuestionUserSelection = examChoiceQuestionUserSelection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ExamQuestion getExamQuestion() {
        return examQuestion;
    }

    public void setExamQuestion(ExamQuestion examQuestion) {
        this.examQuestion = examQuestion;
    }
}
