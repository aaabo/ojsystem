package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamChoiceQuestionHistoryMapper;
import com.example.ojsystem.entity.ExamChoiceQuestionHistory;
import com.example.ojsystem.entity.StudentScoreTool;
import com.example.ojsystem.service.ExamChoiceQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamChoiceQuestionHistoryImpl implements ExamChoiceQuestionHistoryService{
    @Autowired
    ExamChoiceQuestionHistoryMapper examChoiceQuestionHistoryMapper;

    /**
     * 根据学生id 选择题id 学生选项添加学生选择题记录
     * 输入ExamChoiceQuestionHistory
     * 输出int
     *
     * @param examChoiceQuestionHistory
     */
    public int addExamChoiceQuestionHistory(ExamChoiceQuestionHistory examChoiceQuestionHistory) {
        return examChoiceQuestionHistoryMapper.addExamChoiceQuestionHistory(examChoiceQuestionHistory);
    }

    /**
     * 根据考试id查询学生的选择题分数
     * 输入examId
     * 输出List<StudentScoreTool>
     *
     * @param examId
     */
    public List<StudentScoreTool> queryStudentExamChoiceScore(int examId) {
        return examChoiceQuestionHistoryMapper.queryStudentExamChoiceScore(examId);
    }
}
