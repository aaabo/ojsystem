package com.example.ojsystem.entity;

import java.util.List;

public class ExamProgrammingScoreTool {
    private Integer userId;
    private List<ExamProgrammingQuestionHistory> examProgrammingQuestionHistories;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<ExamProgrammingQuestionHistory> getExamProgrammingQuestionHistories() {
        return examProgrammingQuestionHistories;
    }

    public void setExamProgrammingQuestionHistories(List<ExamProgrammingQuestionHistory> examProgrammingQuestionHistories) {
        this.examProgrammingQuestionHistories = examProgrammingQuestionHistories;
    }


}
