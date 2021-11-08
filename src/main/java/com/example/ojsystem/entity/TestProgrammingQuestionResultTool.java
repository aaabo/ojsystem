package com.example.ojsystem.entity;

import java.util.List;

public class TestProgrammingQuestionResultTool {
    private int userId;
    private List<TestProgrammingQuestionResultStateTool> testProgrammingQuestionResultStateTools;

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

    @Override
    public String toString() {
        return "TestProgrammingQuestionResultTool{" +
                "userId=" + userId +
                ", testProgrammingQuestionResultStateTools=" + testProgrammingQuestionResultStateTools +
                '}';
    }
}
