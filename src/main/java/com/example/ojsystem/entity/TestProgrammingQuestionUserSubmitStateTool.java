package com.example.ojsystem.entity;

public class TestProgrammingQuestionUserSubmitStateTool {
    private int success;
    private int noSuccess;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getNoSuccess() {
        return noSuccess;
    }

    public void setNoSuccess(int noSuccess) {
        this.noSuccess = noSuccess;
    }

    @Override
    public String toString() {
        return "TestProgrammingQuestionUserSubmitStateTool{" +
                "success=" + success +
                ", noSuccess=" + noSuccess +
                '}';
    }
}
