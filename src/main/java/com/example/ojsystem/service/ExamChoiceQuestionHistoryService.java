package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamChoiceQuestionHistory;
import com.example.ojsystem.entity.StudentScoreTool;

import java.util.List;

public interface ExamChoiceQuestionHistoryService {
    /**
     * 根据学生id 选择题id 学生选项添加学生选择题记录
     * 输入ExamChoiceQuestionHistory
     * 输出int
     */
    public int addExamChoiceQuestionHistory(ExamChoiceQuestionHistory examChoiceQuestionHistory);

    /**
     * 根据考试id查询学生的选择题分数
     * 输入examId
     * 输出List<StudentScoreTool>
     */
    public List<StudentScoreTool> queryStudentExamChoiceScore(int examId);
}
