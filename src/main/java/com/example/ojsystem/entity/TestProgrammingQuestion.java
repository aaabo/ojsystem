package com.example.ojsystem.entity;

public class TestProgrammingQuestion {
    private int testProgrammingQuestionId;

    private Test test;
    private Exercise exercise;

    public int getTestProgrammingQuestionId() {
        return testProgrammingQuestionId;
    }

    public void setTestProgrammingQuestionId(int testProgrammingQuestionId) {
        this.testProgrammingQuestionId = testProgrammingQuestionId;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public String toString() {
        return "TestProgrammingQuestion{" +
                "testProgrammingQuestionId=" + testProgrammingQuestionId +
                ", test=" + test +
                ", exercise=" + exercise +
                '}';
    }
}
