package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamChoiceQuestionHistory;

public interface ExamChoiceQuestionHistoryService {
    /**
     * 根据学生id 选择题id 学生选项添加学生选择题记录
     * 输入ExamChoiceQuestionHistory
     * 输出int
     */
    public int addExamChoiceQuestionHistory(ExamChoiceQuestionHistory examChoiceQuestionHistory);
}
