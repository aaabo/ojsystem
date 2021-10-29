package com.example.ojsystem.entity;

import java.util.List;

public class ExamCompletionQuestionHistory {
    private  int examCompletionQuestionHistoryId;
    private Float examCompletionQuestionResultScore;

    private User user;
    private List<ExamCompletionQuestionAnswerHistory> examCompletionQuestionAnswerHistories;

    public int getExamCompletionQuestionHistoryId() {
        return examCompletionQuestionHistoryId;
    }

    public void setExamCompletionQuestionHistoryId(int examCompletionQuestionHistoryId) {
        this.examCompletionQuestionHistoryId = examCompletionQuestionHistoryId;
    }

    public Float getExamCompletionQuestionResultScore() {
        return examCompletionQuestionResultScore;
    }

    public void setExamCompletionQuestionResultScore(Float examCompletionQuestionResultScore) {
        this.examCompletionQuestionResultScore = examCompletionQuestionResultScore;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ExamCompletionQuestionAnswerHistory> getExamCompletionQuestionAnswerHistories() {
        return examCompletionQuestionAnswerHistories;
    }

    public void setExamCompletionQuestionAnswerHistories(List<ExamCompletionQuestionAnswerHistory> examCompletionQuestionAnswerHistories) {
        this.examCompletionQuestionAnswerHistories = examCompletionQuestionAnswerHistories;
    }

    @Override
    public String toString() {
        return "ExamCompletionQuestionHistory{" +
                "examCompletionQuestionHistoryId=" + examCompletionQuestionHistoryId +
                ", examCompletionQuestionResultScore=" + examCompletionQuestionResultScore +
                ", user=" + user +
                ", examCompletionQuestionAnswerHistories=" + examCompletionQuestionAnswerHistories +
                '}';
    }
}

