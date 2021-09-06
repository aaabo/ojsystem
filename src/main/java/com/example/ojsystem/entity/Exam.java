package com.example.ojsystem.entity;

public class Exam {
    private int examId;
    private String examStartTime;
    private String examEndTime;
    private Boolean examIsPublish;//是否发布
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

    public Boolean getExamIsPublish() {
        return examIsPublish;
    }

    public void setExamIsPublish(Boolean examIsPublish) {
        this.examIsPublish = examIsPublish;
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
