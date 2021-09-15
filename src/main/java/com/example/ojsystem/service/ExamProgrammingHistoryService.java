package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamProgrammingHistory;
import com.example.ojsystem.entity.StudentScoreTool;

import java.util.List;

public interface ExamProgrammingHistoryService {
    /**
     * 根据学生id和考试编程信息添加考试编程题记录
     * 输入examProgrammingHistory
     * 输出int
     */
    public int addExamProgrammingHistory(ExamProgrammingHistory examProgrammingHistory);

    /**
     * 根据考试id查询所有学生的编程题分数
     * 输入examId
     * 输出List<StudentScoreTool>
     */
    public List<StudentScoreTool> queryStudentExamProgrammingScore(int examId);
}
