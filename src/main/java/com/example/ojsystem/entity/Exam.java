package com.example.ojsystem.entity;

import java.util.List;

public class Exam {
    private int examId;
    private String examName;
    private String examStartTime;
    private String examEndTime;
    private String examStatus;//考试状态
    private String examLanguage;
    private int examChoiceQuestionScore;
    private int examCompletionQuestionScore;
    private int examProgrammingScore;

    private Group group;
    private User user;
    private ExamQuestion examQuestion;

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

    public String getExamLanguage() {
        return examLanguage;
    }

    public void setExamLanguage(String examLanguage) {
        this.examLanguage = examLanguage;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus;
    }

    public ExamQuestion getExamQuestion() {
        return examQuestion;
    }

    public void setExamQuestion(ExamQuestion examQuestion) {
        this.examQuestion = examQuestion;
    }

    public int getExamChoiceQuestionScore() {
        return examChoiceQuestionScore;
    }

    public void setExamChoiceQuestionScore(int examChoiceQuestionScore) {
        this.examChoiceQuestionScore = examChoiceQuestionScore;
    }

    public int getExamCompletionQuestionScore() {
        return examCompletionQuestionScore;
    }

    public void setExamCompletionQuestionScore(int examCompletionQuestionScore) {
        this.examCompletionQuestionScore = examCompletionQuestionScore;
    }

    public int getExamProgrammingScore() {
        return examProgrammingScore;
    }

    public void setExamProgrammingScore(int examProgrammingScore) {
        this.examProgrammingScore = examProgrammingScore;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", examName='" + examName + '\'' +
                ", examStartTime='" + examStartTime + '\'' +
                ", examEndTime='" + examEndTime + '\'' +
                ", examStatus='" + examStatus + '\'' +
                ", examLanguage='" + examLanguage + '\'' +
                ", examChoiceQuestionScore=" + examChoiceQuestionScore +
                ", examCompletionQuestionScore=" + examCompletionQuestionScore +
                ", examProgrammingScore=" + examProgrammingScore +
                ", group=" + group +
                ", user=" + user +
                ", examQuestion=" + examQuestion +
                '}';
    }
}
