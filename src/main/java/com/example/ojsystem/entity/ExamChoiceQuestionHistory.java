package com.example.ojsystem.entity;

public class ExamChoiceQuestionHistory {
    private int examChoiceQuestionHistoryId;
    private String examChoiceQuestionUserSelection;
    private Float examChoiceQuestionResultScore;


    private ChoiceQuestion choiceQuestion;
    private User user;



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

    public ChoiceQuestion getChoiceQuestion() {
        return choiceQuestion;
    }

    public void setChoiceQuestion(ChoiceQuestion choiceQuestion) {
        this.choiceQuestion = choiceQuestion;
    }

    public Float getExamChoiceQuestionResultScore() {
        return examChoiceQuestionResultScore;
    }

    public void setExamChoiceQuestionResultScore(Float examChoiceQuestionResultScore) {
        this.examChoiceQuestionResultScore = examChoiceQuestionResultScore;
    }
}
