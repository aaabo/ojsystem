package com.example.ojsystem.entity;

public class Student {
    private int studentId;
    private String studentAccount;
    private String studentPassword;
    private String studentName;
    private String studentProfile;
    private int studnetSolved;
    private int studnetSubmit;
    private Classes classes;





    public Student(){

    }



    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    public String getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(String studentAccount) {
        this.studentAccount = studentAccount;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(String studentProfile) {
        this.studentProfile = studentProfile;
    }


    public int getStudnetSolved() {
        return studnetSolved;
    }

    public void setStudnetSolved(int studnetSolved) {
        this.studnetSolved = studnetSolved;
    }

    public int getStudnetSubmit() {
        return studnetSubmit;
    }

    public void setStudnetSubmit(int studnetSubmit) {
        this.studnetSubmit = studnetSubmit;
    }
}
