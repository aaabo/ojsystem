package com.example.ojsystem.entity;

import java.util.List;

public class TestProgrammingQuestionResultTool{
    private int userId;
    private String userName;
    private List<TestProgrammingQuestionResultStateTool> testProgrammingQuestionResultStateTools;
    private Integer acceptNumber;

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

    public Integer getAcceptNumber() {
        return acceptNumber;
    }

    public void setAcceptNumber(Integer acceptNumber) {
        this.acceptNumber = acceptNumber;
    }


    @Override
    public String toString() {
        return "TestProgrammingQuestionResultTool{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", testProgrammingQuestionResultStateTools=" + testProgrammingQuestionResultStateTools +
                ", acceptNumber=" + acceptNumber +
                '}';
    }
}
