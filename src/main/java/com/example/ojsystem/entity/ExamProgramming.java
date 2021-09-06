package com.example.ojsystem.entity;

public class ExamProgramming {
    private int examProgrammingId;
    private String examProgrammingTitle;
    private String examProgrammingDescription;
    private String examProgrammingInput;
    private String examProgrammingOutPut;
    private String examProgrammingSampleInput;
    private String examProgrammingSampleOutput;
    private int examProgrammingScore;

    private Exam exam;

    public ExamProgramming(int examProgrammingId, String examProgrammingTitle, String examProgrammingDescription, String examProgrammingInput, String examProgrammingOutPut, String examProgrammingSampleInput, String examProgrammingSampleOutput, int examProgrammingScore) {
        this.examProgrammingId = examProgrammingId;
        this.examProgrammingTitle = examProgrammingTitle;
        this.examProgrammingDescription = examProgrammingDescription;
        this.examProgrammingInput = examProgrammingInput;
        this.examProgrammingOutPut = examProgrammingOutPut;
        this.examProgrammingSampleInput = examProgrammingSampleInput;
        this.examProgrammingSampleOutput = examProgrammingSampleOutput;
        this.examProgrammingScore = examProgrammingScore;
    }

    public ExamProgramming(){

    }

    public int getExamProgrammingId() {
        return examProgrammingId;
    }

    public void setExamProgrammingId(int examProgrammingId) {
        this.examProgrammingId = examProgrammingId;
    }

    public String getExamProgrammingTitle() {
        return examProgrammingTitle;
    }

    public void setExamProgrammingTitle(String examProgrammingTitle) {
        this.examProgrammingTitle = examProgrammingTitle;
    }

    public String getExamProgrammingDescription() {
        return examProgrammingDescription;
    }

    public void setExamProgrammingDescription(String examProgrammingDescription) {
        this.examProgrammingDescription = examProgrammingDescription;
    }

    public String getExamProgrammingInput() {
        return examProgrammingInput;
    }

    public void setExamProgrammingInput(String examProgrammingInput) {
        this.examProgrammingInput = examProgrammingInput;
    }

    public String getExamProgrammingOutPut() {
        return examProgrammingOutPut;
    }

    public void setExamProgrammingOutPut(String examProgrammingOutPut) {
        this.examProgrammingOutPut = examProgrammingOutPut;
    }

    public String getExamProgrammingSampleInput() {
        return examProgrammingSampleInput;
    }

    public void setExamProgrammingSampleInput(String examProgrammingSampleInput) {
        this.examProgrammingSampleInput = examProgrammingSampleInput;
    }

    public String getExamProgrammingSampleOutput() {
        return examProgrammingSampleOutput;
    }

    public void setExamProgrammingSampleOutput(String examProgrammingSampleOutput) {
        this.examProgrammingSampleOutput = examProgrammingSampleOutput;
    }

    public int getExamProgrammingScore() {
        return examProgrammingScore;
    }

    public void setExamProgrammingScore(int examProgrammingScore) {
        this.examProgrammingScore = examProgrammingScore;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
