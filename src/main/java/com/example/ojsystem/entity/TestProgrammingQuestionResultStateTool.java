package com.example.ojsystem.entity;

public class TestProgrammingQuestionResultStateTool {
    private int testProgrammingQuestionId;
    private String testProgrammingQuestionResult;

    public int getTestProgrammingQuestionId() {
        return testProgrammingQuestionId;
    }

    public void setTestProgrammingQuestionId(int testProgrammingQuestionId) {
        this.testProgrammingQuestionId = testProgrammingQuestionId;
    }

    public String getTestProgrammingQuestionResult() {
        return testProgrammingQuestionResult;
    }

    public void setTestProgrammingQuestionResult(String testProgrammingQuestionResult) {
        this.testProgrammingQuestionResult = testProgrammingQuestionResult;
    }

    @Override
    public String toString() {
        return "TestProgrammingQuestionResultStateTool{" +
                "testProgrammingQuestionId=" + testProgrammingQuestionId +
                ", testProgrammingQuestionResult='" + testProgrammingQuestionResult + '\'' +
                '}';
    }
}
