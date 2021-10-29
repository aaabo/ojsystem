package com.example.ojsystem.service;

public interface ExamCompletionQuestionHistoryService {
    /**
     * 根据用户提交的填空题信息添加填空题记录
     * 输入userId,examQuestionId
     * 输出int
     */
    public int addExamCompletionQuestionHistoryInfo(int userId,int examQuestionId);
}
