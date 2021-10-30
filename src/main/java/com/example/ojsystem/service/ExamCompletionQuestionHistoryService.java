package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamCompletionQuestionHistory;
import com.example.ojsystem.entity.ExamQuestionHistory;

import java.util.List;

public interface ExamCompletionQuestionHistoryService {
    /**
     * 根据用户提交的填空题信息添加填空题记录
     * 输入examQuestionHistories,userId
     * 输出int
     */
    public int addExamCompletionQuestionHistoryInfo(List<ExamQuestionHistory> examQuestionHistories, int userId);
}
