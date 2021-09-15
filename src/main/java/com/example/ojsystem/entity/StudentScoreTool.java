package com.example.ojsystem.entity;

import com.example.ojsystem.entity.Student;

public class StudentScoreTool {
    private Student student;
    private int choiceScore;
    private int programmingScore;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getChoiceScore() {
        return choiceScore;
    }

    public void setChoiceScore(int choiceScore) {
        this.choiceScore = choiceScore;
    }

    public int getProgrammingScore() {
        return programmingScore;
    }

    public void setProgrammingScore(int programmingScore) {
        programmingScore = programmingScore;
    }
}
