package com.example.ojsystem.entity;

import java.util.List;

public class TestStanding {
    private int userId;
    private String userName;
    private List<TestProgrammingQuestionResultStateTool> testProgrammingQuestionResultStateTools;
    private Float acceptNumber;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<TestProgrammingQuestionResultStateTool> getTestProgrammingQuestionResultStateTools() {
        return testProgrammingQuestionResultStateTools;
    }

    public void setTestProgrammingQuestionResultStateTools(List<TestProgrammingQuestionResultStateTool> testProgrammingQuestionResultStateTools) {
        this.testProgrammingQuestionResultStateTools = testProgrammingQuestionResultStateTools;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Float getAcceptNumber() {
        return acceptNumber;
    }

    public void setAcceptNumber(Float acceptNumber) {
        this.acceptNumber = acceptNumber;
    }


    @Override
    public String toString() {
        return "TestStanding{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", testProgrammingQuestionResultStateTools=" + testProgrammingQuestionResultStateTools +
                ", acceptNumber=" + acceptNumber +
                '}';
    }
}
