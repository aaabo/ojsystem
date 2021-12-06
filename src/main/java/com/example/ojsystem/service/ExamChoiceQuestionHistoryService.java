package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamChoiceQuestionHistory;
import com.example.ojsystem.entity.ExamQuestionHistory;

import java.util.List;

public interface ExamChoiceQuestionHistoryService {
    /**
     * 根据用户提交的选择题信息添加选择题记录
     * 输入examQuestionHistories,userId
     * 输出int
     */
    public int saveExamChoiceQuestionHistoryInfo(List<ExamQuestionHistory> examQuestionHistories, int userId);


}
