package com.example.ojsystem.entity;

public class Exam {
    private int examId;
    private String examName;
    private String examStartTime;
    private String examEndTime;
    private String examType;//考试状态
    private int examChoiceTotals;//考试选择总分
    private int examProgrammingTotals;//考试编程总分
    private String examLanguage;

    private Classes classes;
    private Teacher teacher;


    public Exam() {
    }


    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(String examStartTime) {
        this.examStartTime = examStartTime;
    }

    public String getExamEndTime() {
        return examEndTime;
    }

    public void setExamEndTime(String examEndTime) {
        this.examEndTime = examEndTime;
    }


    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
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

    public String getExamLanguage() {
        return examLanguage;
    }

    public void setExamLanguage(String examLanguage) {
        this.examLanguage = examLanguage;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
