package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamChoiceQuestionHistory;

import java.util.List;

public interface ExamChoiceQuestionHistoryService {
    /**
     * 根根据用户id 选择题id 用户选项添加用户选择题记录
     * 输入ExamChoiceQuestionHistory
     * 输出int
     */
    public int addExamChoiceQuestionHistory(ExamChoiceQuestionHistory examChoiceQuestionHistory);


}
