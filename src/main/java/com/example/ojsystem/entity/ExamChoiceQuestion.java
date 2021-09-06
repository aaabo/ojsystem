package com.example.ojsystem.entity;

public class ExamChoiceQuestion {
    private int examChoiceQuestionId;
    private String examChoiceQuestionTitle;
    private  String examChoiceQuestionStemA;
    private  String examChoiceQuestionStemB;
    private  String examChoiceQuestionStemC;
    private  String examChoiceQuestionStemD;
    private String examChoiceQuestionCorrectOption;//正确选项
    private  int examChoiceQuestionScore;

    private  Exam exam;

    public ExamChoiceQuestion(int examChoiceQuestionId, String examChoiceQuestionTitle, String examChoiceQuestionStemA, String examChoiceQuestionStemB, String examChoiceQuestionStemC, String examChoiceQuestionStemD, String examChoiceQuestionCorrectOption, int examChoiceQuestionScore) {
        this.examChoiceQuestionId = examChoiceQuestionId;
        this.examChoiceQuestionTitle = examChoiceQuestionTitle;
        this.examChoiceQuestionStemA = examChoiceQuestionStemA;
        this.examChoiceQuestionStemB = examChoiceQuestionStemB;
        this.examChoiceQuestionStemC = examChoiceQuestionStemC;
        this.examChoiceQuestionStemD = examChoiceQuestionStemD;
        this.examChoiceQuestionCorrectOption = examChoiceQuestionCorrectOption;
        this.examChoiceQuestionScore = examChoiceQuestionScore;
    }

    public ExamChoiceQuestion(){

    }

    public int getExamChoiceQuestionId() {
        return examChoiceQuestionId;
    }

    public void setExamChoiceQuestionId(int examChoiceQuestionId) {
        this.examChoiceQuestionId = examChoiceQuestionId;
    }

    public String getExamChoiceQuestionTitle() {
        return examChoiceQuestionTitle;
    }

    public void setExamChoiceQuestionTitle(String examChoiceQuestionTitle) {
        this.examChoiceQuestionTitle = examChoiceQuestionTitle;
    }

    public String getExamChoiceQuestionStemA() {
        return examChoiceQuestionStemA;
    }

    public void setExamChoiceQuestionStemA(String examChoiceQuestionStemA) {
        this.examChoiceQuestionStemA = examChoiceQuestionStemA;
    }

    public String getExamChoiceQuestionStemB() {
        return examChoiceQuestionStemB;
    }

    public void setExamChoiceQuestionStemB(String examChoiceQuestionStemB) {
        this.examChoiceQuestionStemB = examChoiceQuestionStemB;
    }

    public String getExamChoiceQuestionStemC() {
        return examChoiceQuestionStemC;
    }

    public void setExamChoiceQuestionStemC(String examChoiceQuestionStemC) {
        this.examChoiceQuestionStemC = examChoiceQuestionStemC;
    }

    public String getExamChoiceQuestionStemD() {
        return examChoiceQuestionStemD;
    }

    public void setExamChoiceQuestionStemD(String examChoiceQuestionStemD) {
        this.examChoiceQuestionStemD = examChoiceQuestionStemD;
    }

    public String getExamChoiceQuestionCorrectOption() {
        return examChoiceQuestionCorrectOption;
    }

    public void setExamChoiceQuestionCorrectOption(String examChoiceQuestionCorrectOption) {
        this.examChoiceQuestionCorrectOption = examChoiceQuestionCorrectOption;
    }

    public int getExamChoiceQuestionScore() {
        return examChoiceQuestionScore;
    }

    public void setExamChoiceQuestionScore(int examChoiceQuestionScore) {
        this.examChoiceQuestionScore = examChoiceQuestionScore;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
