package com.example.ojsystem.entity;

public class ExamHistory {
    private int examHistoryId;
    private int examChoiceTotals;//考试选择得分
    private int examProgrammingTotals;//考试编程总分

    private Student student;
    private Exam exam;

    public ExamHistory(int examHistoryId, int examChoiceTotals, int examProgrammingTotals) {
        this.examHistoryId = examHistoryId;
        this.examChoiceTotals = examChoiceTotals;
        this.examProgrammingTotals = examProgrammingTotals;
    }

    public ExamHistory() {

    }

    public int getExamHistoryId() {
        return examHistoryId;
    }

    public void setExamHistoryId(int examHistoryId) {
        this.examHistoryId = examHistoryId;
    }


    public int getExamChoiceTotals() {
        return examChoiceTotals;
    }

    public void setExamChoiceTotals(int examChoiceTotals) {
        this.examChoiceTotals = examChoiceTotals;
    }

    public int getExamProgrammingTotals() {
        return examProgrammingTotals;
    }

    public void setExamProgrammingTotals(int examProgrammingTotals) {
        this.examProgrammingTotals = examProgrammingTotals;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
