package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamProgrammingQuestionHistory;

public interface ExamProgrammingQuestionHistoryService {
    /**
     * 根据用户提交的选择题信息添加选择题记录
     * 输入examProgrammingQuestionHistory
     * 输出int
     */
    public int saveExamProgrammingQuestionHistoryInfo(ExamProgrammingQuestionHistory examProgrammingQuestionHistory,int userId,int examQuestionId);


}
