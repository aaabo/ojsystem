package com.example.ojsystem.entity;

public class Teacher {
    private int teacherId;
    private String teacherAccount;
    private String teacherPassword;
    private String teacherName;

    public Teacher(int teacherId, String teacherAccount, String teacherPassword, String teacherName) {
        this.teacherId = teacherId;
        this.teacherAccount = teacherAccount;
        this.teacherPassword = teacherPassword;
        this.teacherName = teacherName;
    }

    public Teacher(){

    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(String teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
