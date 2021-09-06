package com.example.ojsystem.entity;

public class ExamChoiceQuestionHistory {
    private int examChoiceQuestionHistoryId;
    private String examChoiceQuestionUserSelection;

    private Student student;
    private ExamChoiceQuestion examChoiceQuestion;

    public ExamChoiceQuestionHistory(int examChoiceQuestionHistoryId, String examChoiceQuestionUserSelection) {
        this.examChoiceQuestionHistoryId = examChoiceQuestionHistoryId;
        this.examChoiceQuestionUserSelection = examChoiceQuestionUserSelection;
    }

    public ExamChoiceQuestionHistory(){

    }

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ExamChoiceQuestion getExamChoiceQuestion() {
        return examChoiceQuestion;
    }

    public void setExamChoiceQuestion(ExamChoiceQuestion examChoiceQuestion) {
        this.examChoiceQuestion = examChoiceQuestion;
    }
}
