package com.example.ojsystem.entity;

import java.util.List;

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
    private Boolean isExam;
    private QuestionLabel questionLabel;

    public Exercise(){

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

    public QuestionLabel getQuestionLabel() {
        return questionLabel;
    }

    public void setQuestionLabel(QuestionLabel questionLabel) {
        this.questionLabel = questionLabel;
    }

    public Boolean getIsExam() {
        return isExam;
    }

    public void setIsExam(Boolean isExam) {
        this.isExam = isExam;
    }
    @Override
    public String toString() {
        return "Exercise{" +
                "exerciseId=" + exerciseId +
                ", exerciseTitle='" + exerciseTitle + '\'' +
                ", exerciseCorrectTimes=" + exerciseCorrectTimes +
                ", exerciseSubmitTimes=" + exerciseSubmitTimes +
                ", exerciseDescription='" + exerciseDescription + '\'' +
                ", exerciseInput='" + exerciseInput + '\'' +
                ", exerciseOutPut='" + exerciseOutPut + '\'' +
                ", exerciseSampleInput='" + exerciseSampleInput + '\'' +
                ", exerciseSampleOutput='" + exerciseSampleOutput + '\'' +
                ", questionLabel=" + questionLabel +
                '}';
    }
}
