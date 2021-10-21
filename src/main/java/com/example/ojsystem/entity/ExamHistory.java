package com.example.ojsystem.entity;

public class ExamHistory {
    private int examHistoryId;
    private int examChoiceQuestionTotals;//考试学生选择得分
    private int examProgrammingTotals;//考试学生编程总分
    private int examCompletionQuestionTotals;//考试学生填空总分
    private int examTotals;//考试总分
    private User user;
    private Exam exam;

    public ExamHistory() {

    }

    public int getExamHistoryId() {
        return examHistoryId;
    }

    public void setExamHistoryId(int examHistoryId) {
        this.examHistoryId = examHistoryId;
    }

    public int getExamChoiceQuestionTotals() {
        return examChoiceQuestionTotals;
    }

    public void setExamChoiceQuestionTotals(int examChoiceQuestionTotals) {
        this.examChoiceQuestionTotals = examChoiceQuestionTotals;
    }

    public int getExamProgrammingTotals() {
        return examProgrammingTotals;
    }

    public void setExamProgrammingTotals(int examProgrammingTotals) {
        this.examProgrammingTotals = examProgrammingTotals;
    }

    public int getExamCompletionQuestionTotals() {
        return examCompletionQuestionTotals;
    }

    public void setExamCompletionQuestionTotals(int examCompletionQuestionTotals) {
        this.examCompletionQuestionTotals = examCompletionQuestionTotals;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public int getExamTotals() {
        return examTotals;
    }

    public void setExamTotals(int examTotals) {
        this.examTotals = examTotals;
    }
}
