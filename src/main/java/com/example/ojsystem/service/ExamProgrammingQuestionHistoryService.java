package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamProgrammingQuestionHistory;

public interface ExamProgrammingQuestionHistoryService {
    /**
     * 根据学生id和考试编程信息添加考试编程题记录
     * 输入examProgrammingQuestionHistory
     * 输出int
     */
    public int addExamProgrammingQuestionHistory(ExamProgrammingQuestionHistory examProgrammingQuestionHistory);


}
