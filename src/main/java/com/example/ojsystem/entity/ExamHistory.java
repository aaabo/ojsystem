package com.example.ojsystem.entity;

public class ExamHistory {
    private int examHistoryId;
    private int examUserChoiceTotals;//考试学生选择得分
    private int examUserProgrammingTotals;//考试学生编程总分

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

    public int getExamUserChoiceTotals() {
        return examUserChoiceTotals;
    }

    public void setExamUserChoiceTotals(int examUserChoiceTotals) {
        this.examUserChoiceTotals = examUserChoiceTotals;
    }

    public int getExamUserProgrammingTotals() {
        return examUserProgrammingTotals;
    }

    public void setExamUserProgrammingTotals(int examUserProgrammingTotals) {
        this.examUserProgrammingTotals = examUserProgrammingTotals;
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
}
