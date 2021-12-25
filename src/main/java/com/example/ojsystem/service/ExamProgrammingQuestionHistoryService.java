package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamProgrammingQuestionHistory;

public interface ExamProgrammingQuestionHistoryService {
    /**
     * 根据用户提交的选择题信息添加选择题记录
     * 输入examProgrammingQuestionHistory
     * 输出int
     */
    public int addExamProgrammingQuestionHistoryInfo(int examProgrammingQuestionScore,ExamProgrammingQuestionHistory examProgrammingQuestionHistory,int userId,int examQuestionId);
    /**
     根据用户id和考题id查询编程题结果
     输入examQuestionId,userId
     输出String
     **/
    public String checkExamProgrammingQuestionResultHistoryByExamQuestionIdAndUserId(int examQuestionId,int userId);

}
