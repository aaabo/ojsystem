package com.example.ojsystem.entity;

import java.util.List;

public class ExamQuestionHistory {
    private int id;
    private int examQuestionId;
    private int examChoiceQuestionUserSelection;
    private String examProgrammingQuestionCode;
    private List<ExamCompletionQuestionAnswerHistory> examCompletionQuestionAnswerHistories;
    private Float score;

    public int getExamQuestionId() {
        return examQuestionId;
    }

    public void setExamQuestionId(int examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    public int getExamChoiceQuestionUserSelection() {
        return examChoiceQuestionUserSelection;
    }

    public void setExamChoiceQuestionUserSelection(int examChoiceQuestionUserSelection) {
        this.examChoiceQuestionUserSelection = examChoiceQuestionUserSelection;
    }

    public String getExamProgrammingQuestionCode() {
        return examProgrammingQuestionCode;
    }

    public void setExamProgrammingQuestionCode(String examProgrammingQuestionCode) {
        this.examProgrammingQuestionCode = examProgrammingQuestionCode;
    }

    public List<ExamCompletionQuestionAnswerHistory> getExamCompletionQuestionAnswerHistories() {
        return examCompletionQuestionAnswerHistories;
    }

    public void setExamCompletionQuestionAnswerHistories(List<ExamCompletionQuestionAnswerHistory> examCompletionQuestionAnswerHistories) {
        this.examCompletionQuestionAnswerHistories = examCompletionQuestionAnswerHistories;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
