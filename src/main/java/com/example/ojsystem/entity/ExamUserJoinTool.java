package com.example.ojsystem.entity;

public class ExamUserJoinTool
{
    private Integer examUser;
    private Integer examSubmitUser;
    private Integer examNotSubmitUser;

    public Integer getExamUser() {
        return examUser;
    }

    public void setExamUser(Integer examUser) {
        this.examUser = examUser;
    }

    public Integer getExamSubmitUser() {
        return examSubmitUser;
    }

    public void setExamSubmitUser(Integer examSubmitUser) {
        this.examSubmitUser = examSubmitUser;
    }

    public Integer getExamNotSubmitUser() {
        return examNotSubmitUser;
    }

    public void setExamNotSubmitUser(Integer examNotSubmitUser) {
        this.examNotSubmitUser = examNotSubmitUser;
    }

    @Override
    public String toString() {
        return "ExamUserJoinTool{" +
                "examUser=" + examUser +
                ", examSubmitUser=" + examSubmitUser +
                ", examNotSubmitUser=" + examNotSubmitUser +
                '}';
    }
}
