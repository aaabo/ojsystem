package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamProgrammingHistory;

public interface ExamProgrammingHistoryService {
    /**
     * 根据学生id和考试编程信息添加考试编程题记录
     * 输入examProgrammingHistory
     * 输出int
     */
    public int addExamProgrammingHistory(ExamProgrammingHistory examProgrammingHistory);
}
