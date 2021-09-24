package com.example.ojsystem.entity;

public class Exam {
    private int examId;
    private String examName;
    private String examStartTime;
    private String examEndTime;
    private String examType;//考试状态
    private String examLanguage;

    private Group group;
    private User user;


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
}
