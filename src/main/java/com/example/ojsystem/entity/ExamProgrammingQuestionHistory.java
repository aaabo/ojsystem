package com.example.ojsystem.entity;

public class ExamProgrammingQuestionHistory {
    private int examProgrammingQuestionHistoryId;
    private  String examProgrammingQuestionResult;
    private String examProgrammingQuestionCode;

    private CompletionQuestion completionQuestion;
    private  User user;




    public ExamProgrammingQuestionHistory(){

    }


    public int getExamProgrammingQuestionHistoryId() {
        return examProgrammingQuestionHistoryId;
    }

    public void setExamProgrammingQuestionHistoryId(int examProgrammingQuestionHistoryId) {
        this.examProgrammingQuestionHistoryId = examProgrammingQuestionHistoryId;
    }

    public String getExamProgrammingQuestionResult() {
        return examProgrammingQuestionResult;
    }

    public void setExamProgrammingQuestionResult(String examProgrammingQuestionResult) {
        this.examProgrammingQuestionResult = examProgrammingQuestionResult;
    }

    public String getExamProgrammingQuestionCode() {
        return examProgrammingQuestionCode;
    }

    public void setExamProgrammingQuestionCode(String examProgrammingQuestionCode) {
        this.examProgrammingQuestionCode = examProgrammingQuestionCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CompletionQuestion getCompletionQuestion() {
        return completionQuestion;
    }

    public void setCompletionQuestion(CompletionQuestion completionQuestion) {
        this.completionQuestion = completionQuestion;
    }
}
