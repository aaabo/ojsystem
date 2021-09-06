package com.example.ojsystem.entity;

public class ExerciseHistory {
    private int exerciseHistoryId;
    private String exerciseSubmitTime;
    private String exerciseResult;
    private String exerciseSubmitLanguage;
    private String exerciseCode;

    private Exercise exercise;
    private Student student;


    public ExerciseHistory(int exerciseHistoryId, String exerciseSubmitTime, String exerciseResult, String exerciseSubmitLanguage, String exerciseCode) {
        this.exerciseHistoryId = exerciseHistoryId;
        this.exerciseSubmitTime = exerciseSubmitTime;
        this.exerciseResult = exerciseResult;
        this.exerciseSubmitLanguage = exerciseSubmitLanguage;
        this.exerciseCode = exerciseCode;
    }

    public ExerciseHistory(){

    }

    public int getExerciseHistoryId() {
        return exerciseHistoryId;
    }

    public void setExerciseHistoryId(int exerciseHistoryId) {
        this.exerciseHistoryId = exerciseHistoryId;
    }

    public String getExerciseSubmitTime() {
        return exerciseSubmitTime;
    }

    public void setExerciseSubmitTime(String exerciseSubmitTime) {
        this.exerciseSubmitTime = exerciseSubmitTime;
    }

    public String getExerciseResult() {
        return exerciseResult;
    }

    public void setExerciseResult(String exerciseResult) {
        this.exerciseResult = exerciseResult;
    }

    public String getExerciseSubmitLanguage() {
        return exerciseSubmitLanguage;
    }

    public void setExerciseSubmitLanguage(String exerciseSubmitLanguage) {
        this.exerciseSubmitLanguage = exerciseSubmitLanguage;
    }

    public String getExerciseCode() {
        return exerciseCode;
    }

    public void setExerciseCode(String exerciseCode) {
        this.exerciseCode = exerciseCode;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
