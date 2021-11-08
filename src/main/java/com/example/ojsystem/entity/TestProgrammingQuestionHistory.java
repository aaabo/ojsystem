package com.example.ojsystem.entity;

public class TestProgrammingQuestionHistory {
    private int testProgrammingQuestionHistoryId;
    private String testProgrammingSubmitTime;
    private String testProgrammingResult;
    private String testProgrammingCode;

    private User user;
    private TestProgrammingQuestion  testProgrammingQuestion;

    public int getTestProgrammingQuestionHistoryId() {
        return testProgrammingQuestionHistoryId;
    }

    public void setTestProgrammingQuestionHistoryId(int testProgrammingQuestionHistoryId) {
        this.testProgrammingQuestionHistoryId = testProgrammingQuestionHistoryId;
    }

    public String getTestProgrammingSubmitTime() {
        return testProgrammingSubmitTime;
    }

    public void setTestProgrammingSubmitTime(String testProgrammingSubmitTime) {
        this.testProgrammingSubmitTime = testProgrammingSubmitTime;
    }

    public String getTestProgrammingResult() {
        return testProgrammingResult;
    }

    public void setTestProgrammingResult(String testProgrammingResult) {
        this.testProgrammingResult = testProgrammingResult;
    }

    public String getTestProgrammingCode() {
        return testProgrammingCode;
    }

    public void setTestProgrammingCode(String testProgrammingCode) {
        this.testProgrammingCode = testProgrammingCode;
    }

    public TestProgrammingQuestion getTestProgrammingQuestion() {
        return testProgrammingQuestion;
    }

    public void setTestProgrammingQuestion(TestProgrammingQuestion testProgrammingQuestion) {
        this.testProgrammingQuestion = testProgrammingQuestion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TestProgrammingQuestionHistory{" +
                "testProgrammingQuestionHistoryId=" + testProgrammingQuestionHistoryId +
                ", testProgrammingSubmitTime='" + testProgrammingSubmitTime + '\'' +
                ", testProgrammingResult='" + testProgrammingResult + '\'' +
                ", testProgrammingCode='" + testProgrammingCode + '\'' +
                ", user=" + user +
                ", testProgrammingQuestion=" + testProgrammingQuestion +
                '}';
    }
}
