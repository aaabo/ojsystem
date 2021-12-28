package com.example.ojsystem.entity;

import java.util.List;

public class UserExamProgrammingDrawTool {
    private int examQuestionId;
    private List<ExamProgrammingTotalAndScore> examProgrammingTotalAndScores;

    public int getExamQuestionId() {
        return examQuestionId;
    }

    public void setExamQuestionId(int examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    public List<ExamProgrammingTotalAndScore> getExamProgrammingTotalAndScores() {
        return examProgrammingTotalAndScores;
    }

    public void setExamProgrammingTotalAndScores(List<ExamProgrammingTotalAndScore> examProgrammingTotalAndScores) {
        this.examProgrammingTotalAndScores = examProgrammingTotalAndScores;
    }
}
