package com.example.ojsystem.entity;

import java.util.List;

public class ExamQuestionHistory {
    private int examQuestionId;
    private ExamChoiceQuestionHistory examChoiceQuestionHistory;
    private ExamCompletionQuestionHistory examCompletionQuestionHistory;
    private  ExamProgrammingQuestionHistory examProgrammingQuestionHistory;

    public int getExamQuestionId() {
        return examQuestionId;
    }

    public void setExamQuestionId(int examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    public ExamChoiceQuestionHistory getExamChoiceQuestionHistory() {
        return examChoiceQuestionHistory;
    }

    public void setExamChoiceQuestionHistory(ExamChoiceQuestionHistory examChoiceQuestionHistory) {
        this.examChoiceQuestionHistory = examChoiceQuestionHistory;
    }

    public ExamCompletionQuestionHistory getExamCompletionQuestionHistory() {
        return examCompletionQuestionHistory;
    }

    public void setExamCompletionQuestionHistory(ExamCompletionQuestionHistory examCompletionQuestionHistory) {
        this.examCompletionQuestionHistory = examCompletionQuestionHistory;
    }

    public ExamProgrammingQuestionHistory getExamProgrammingQuestionHistory() {
        return examProgrammingQuestionHistory;
    }

    public void setExamProgrammingQuestionHistory(ExamProgrammingQuestionHistory examProgrammingQuestionHistory) {
        this.examProgrammingQuestionHistory = examProgrammingQuestionHistory;
    }

    @Override
    public String toString() {
        return "ExamQuestionHistory{" +
                "examQuestionId=" + examQuestionId +
                ", examChoiceQuestionHistory=" + examChoiceQuestionHistory +
                ", examCompletionQuestionHistory=" + examCompletionQuestionHistory +
                ", examProgrammingQuestionHistory=" + examProgrammingQuestionHistory +
                '}';
    }
}
