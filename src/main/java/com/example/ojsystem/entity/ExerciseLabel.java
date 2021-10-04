package com.example.ojsystem.entity;

public class ExerciseLabel {
    private int exerciseLabelId;
    private String firstPoint;
    private String secondPoint;

    public int getExerciseLabelId() {
        return exerciseLabelId;
    }

    public void setExerciseLabelId(int exerciseLabelId) {
        this.exerciseLabelId = exerciseLabelId;
    }

    public String getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(String firstPoint) {
        this.firstPoint = firstPoint;
    }

    public String getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(String secondPoint) {
        this.secondPoint = secondPoint;
    }

    @Override
    public String toString() {
        return "ExerciseLabel{" +
                "exerciseLabelId=" + exerciseLabelId +
                ", firstPoint='" + firstPoint + '\'' +
                ", secondPoint='" + secondPoint + '\'' +
                '}';
    }
}
