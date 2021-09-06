package com.example.ojsystem.entity;

public class ExamProgrammingAnswer {
    private int examProgrammingAnswerId;
    private String examProgrammingAnswerInput;
    private  String examProgrammingAnswerOutput;


    private ExamProgramming examProgramming;

    public ExamProgrammingAnswer(int examProgrammingAnswerId, String examProgrammingAnswerInput, String examProgrammingAnswerOutput) {
        this.examProgrammingAnswerId = examProgrammingAnswerId;
        this.examProgrammingAnswerInput = examProgrammingAnswerInput;
        this.examProgrammingAnswerOutput = examProgrammingAnswerOutput;
    }

    public ExamProgrammingAnswer(){

    }

    public int getExamProgrammingAnswerId() {
        return examProgrammingAnswerId;
    }

    public void setExamProgrammingAnswerId(int examProgrammingAnswerId) {
        this.examProgrammingAnswerId = examProgrammingAnswerId;
    }

    public String getExamProgrammingAnswerInput() {
        return examProgrammingAnswerInput;
    }

    public void setExamProgrammingAnswerInput(String examProgrammingAnswerInput) {
        this.examProgrammingAnswerInput = examProgrammingAnswerInput;
    }

    public String getExamProgrammingAnswerOutput() {
        return examProgrammingAnswerOutput;
    }

    public void setExamProgrammingAnswerOutput(String examProgrammingAnswerOutput) {
        this.examProgrammingAnswerOutput = examProgrammingAnswerOutput;
    }

    public ExamProgramming getExamProgramming() {
        return examProgramming;
    }

    public void setExamProgramming(ExamProgramming examProgramming) {
        this.examProgramming = examProgramming;
    }
}
