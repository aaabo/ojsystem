package com.example.ojsystem.entity;

public class ExamQuestion {
    private int examQuestionId;
    private int questionId;
    private String examQuestionType;
    private Exam exam;


    public int getExamQuestionId() {
        return examQuestionId;
    }

    public void setExamQuestionId(int examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getExamQuestionType() {
        return examQuestionType;
    }

    public void setExamQuestionType(String examQuestionType) {
        this.examQuestionType = examQuestionType;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
