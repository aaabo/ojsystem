package com.example.ojsystem.entity;

public class ExerciseAnswer {
    private  int exerciseAnswerId;
    private String exerciseAnswerInput;
    private String exerciseAnswerOutput;

    private Exercise exercise;

    public ExerciseAnswer(int exerciseAnswerId, String exerciseAnswerInput, String exerciseAnswerOutput) {
        this.exerciseAnswerId = exerciseAnswerId;
        this.exerciseAnswerInput = exerciseAnswerInput;
        this.exerciseAnswerOutput = exerciseAnswerOutput;
    }
    public ExerciseAnswer() {

    }

    public int getExerciseAnswerId() {
        return exerciseAnswerId;
    }

    public void setExerciseAnswerId(int exerciseAnswerId) {
        this.exerciseAnswerId = exerciseAnswerId;
    }

    public String getExerciseAnswerInput() {
        return exerciseAnswerInput;
    }

    public void setExerciseAnswerInput(String exerciseAnswerInput) {
        this.exerciseAnswerInput = exerciseAnswerInput;
    }

    public String getExerciseAnswerOutput() {
        return exerciseAnswerOutput;
    }

    public void setExerciseAnswerOutput(String exerciseAnswerOuput) {
        this.exerciseAnswerOutput = exerciseAnswerOutput;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
