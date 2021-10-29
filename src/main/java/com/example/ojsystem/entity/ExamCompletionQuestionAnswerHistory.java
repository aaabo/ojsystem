package com.example.ojsystem.entity;

public class ExamCompletionQuestionAnswerHistory {
    private int examCompletionQuestionAnswerHistoryId;
    private String examCompletionQuestionUserAnswer;
    private int examCompletionQuestionUserAnswerNumber;

    public int getExamCompletionQuestionAnswerHistoryId() {
        return examCompletionQuestionAnswerHistoryId;
    }

    public void setExamCompletionQuestionAnswerHistoryId(int examCompletionQuestionAnswerHistoryId) {
        this.examCompletionQuestionAnswerHistoryId = examCompletionQuestionAnswerHistoryId;
    }

    public String getExamCompletionQuestionUserAnswer() {
        return examCompletionQuestionUserAnswer;
    }

    public void setExamCompletionQuestionUserAnswer(String examCompletionQuestionUserAnswer) {
        this.examCompletionQuestionUserAnswer = examCompletionQuestionUserAnswer;
    }

    public int getExamCompletionQuestionUserAnswerNumber() {
        return examCompletionQuestionUserAnswerNumber;
    }

    public void setExamCompletionQuestionUserAnswerNumber(int examCompletionQuestionUserAnswerNumber) {
        this.examCompletionQuestionUserAnswerNumber = examCompletionQuestionUserAnswerNumber;
    }
}
