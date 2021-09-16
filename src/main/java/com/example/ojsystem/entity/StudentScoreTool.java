package com.example.ojsystem.entity;

import com.example.ojsystem.entity.Student;

import java.util.Comparator;

public class StudentScoreTool {
    private int studentId;
    private String studentName;
    private int choiceScore;
    private int programmingScore2;
    private int totalScore;


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getChoiceScore() {
        return choiceScore;
    }

    public void setChoiceScore(int choiceScore) {
        this.choiceScore = choiceScore;
    }

    public int getProgrammingScore() {
        return programmingScore2;
    }

    public void setProgrammingScore(int programmingScore2) {
        this.programmingScore2 = programmingScore2;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "StudentScoreTool{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", choiceScore=" + choiceScore +
                ", programmingScore=" + programmingScore2 +
                '}';
    }



}



