package com.example.ojsystem.entity;

public class Exercise {
    private int exerciseId;
    private String exerciseTitle;
    private int exerciseCorrectTimes;
    private int exerciseSubmitTimes;
    private String exerciseDescription;
    private String exerciseInput;
    private String exerciseOutPut;
    private  String exerciseSampleInput;
    private  String exerciseSampleOutput;

    private ExerciseLabel exerciseLabel;

    public Exercise(){

    }

    public Exercise(int exerciseId, String exerciseTitle, int exerciseCorrectTimes, int exerciseSubmitTimes, String exerciseDescription, String exerciseInput, String exerciseOutPut, String exerciseSampleInput, String exerciseSampleOutput) {
        this.exerciseId = exerciseId;
        this.exerciseTitle = exerciseTitle;
        this.exerciseCorrectTimes = exerciseCorrectTimes;
        this.exerciseSubmitTimes = exerciseSubmitTimes;
        this.exerciseDescription = exerciseDescription;
        this.exerciseInput = exerciseInput;
        this.exerciseOutPut = exerciseOutPut;
        this.exerciseSampleInput = exerciseSampleInput;
        this.exerciseSampleOutput = exerciseSampleOutput;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.exerciseTitle = exerciseTitle;
    }

    public int getExerciseCorrectTimes() {
        return exerciseCorrectTimes;
    }

    public void setExerciseCorrectTimes(int exerciseCorrectTimes) {
        this.exerciseCorrectTimes = exerciseCorrectTimes;
    }

    public int getExerciseSubmitTimes() {
        return exerciseSubmitTimes;
    }

    public void setExerciseSubmitTimes(int exerciseSubmitTimes) {
        this.exerciseSubmitTimes = exerciseSubmitTimes;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public String getExerciseInput() {
        return exerciseInput;
    }

    public void setExerciseInput(String exerciseInput) {
        this.exerciseInput = exerciseInput;
    }

    public String getExerciseOutPut() {
        return exerciseOutPut;
    }

    public void setExerciseOutPut(String exerciseOutPut) {
        this.exerciseOutPut = exerciseOutPut;
    }

    public String getExerciseSampleInput() {
        return exerciseSampleInput;
    }

    public void setExerciseSampleInput(String exerciseSampleInput) {
        this.exerciseSampleInput = exerciseSampleInput;
    }

   

    public String getExerciseSampleOutput() {
        return exerciseSampleOutput;
    }

    public void setExerciseSampleOutput(String exerciseSampleOutput) {
        this.exerciseSampleOutput = exerciseSampleOutput;
    }

    public ExerciseLabel getExerciseLabel() {
        return exerciseLabel;
    }

    public void setExerciseLabel(ExerciseLabel exerciseLabel) {
        this.exerciseLabel = exerciseLabel;
    }
}
