package com.example.ojsystem.entity;

import java.util.List;

public class ExamProgrammingScoreTool {
    private User user;
    private List<ExamProgrammingQuestionHistory> examProgrammingQuestionHistories;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ExamProgrammingQuestionHistory> getExamProgrammingQuestionHistories() {
        return examProgrammingQuestionHistories;
    }

    public void setExamProgrammingQuestionHistories(List<ExamProgrammingQuestionHistory> examProgrammingQuestionHistories) {
        this.examProgrammingQuestionHistories = examProgrammingQuestionHistories;
    }

    @Override
    public String toString() {
        return "ExamProgrammingScoreTool{" +
                "user=" + user +
                ", examProgrammingQuestionHistories=" + examProgrammingQuestionHistories +
                '}';
    }
}
