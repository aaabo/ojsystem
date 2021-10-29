package com.example.ojsystem.entity;

public class ExamProgrammingResultScoreTool {
    private String exerciseTitle;
    private Float avgExamProgrammingScore;

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.exerciseTitle = exerciseTitle;
    }

    public Float getAvgExamProgrammingScore() {
        return avgExamProgrammingScore;
    }

    public void setAvgExamProgrammingScore(Float avgExamProgrammingScore) {
        this.avgExamProgrammingScore = avgExamProgrammingScore;
    }

    @Override
    public String toString() {
        return "ExamProgrammingResultScoreTool{" +
                "exerciseTitle='" + exerciseTitle + '\'' +
                ", avgExamProgrammingScore=" + avgExamProgrammingScore +
                '}';
    }
}

