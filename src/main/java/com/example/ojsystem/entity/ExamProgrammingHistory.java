package com.example.ojsystem.entity;

public class ExamProgrammingHistory {
    private int examProgrammingHistoryId;
    private  String examProgrammingResult;
    private String examProgrammingCode;

    private  Student student;
    private ExamProgramming examProgramming;


    public ExamProgrammingHistory(int examProgrammingHistoryId, String examProgrammingResult, String examProgrammingCode) {
        this.examProgrammingHistoryId = examProgrammingHistoryId;
        this.examProgrammingResult = examProgrammingResult;
        this.examProgrammingCode = examProgrammingCode;
    }

    public ExamProgrammingHistory(){

    }

    public int getExamProgrammingHistoryId() {
        return examProgrammingHistoryId;
    }

    public void setExamProgrammingHistoryId(int examProgrammingHistoryId) {
        this.examProgrammingHistoryId = examProgrammingHistoryId;
    }



    public String getExamProgrammingResult() {
        return examProgrammingResult;
    }

    public void setExamProgrammingResult(String examProgrammingResult) {
        this.examProgrammingResult = examProgrammingResult;
    }



    public String getExamProgrammingCode() {
        return examProgrammingCode;
    }

    public void setExamProgrammingCode(String examProgrammingCode) {
        this.examProgrammingCode = examProgrammingCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ExamProgramming getExamProgramming() {
        return examProgramming;
    }

    public void setExamProgramming(ExamProgramming examProgramming) {
        this.examProgramming = examProgramming;
    }
}
