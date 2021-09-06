package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamChoiceQuestion;

import java.util.List;

public interface ExamChoiceQuestionService {
    /**
     * 根据考试id和选择题信息添加选择题信息
     * 输入examChoiceQuestion
     * 输出int
     */
    public int addChoiceQuestionExamInfo(ExamChoiceQuestion examChoiceQuestion);


    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<ExamChoiceQuestion>
     */
    public List<ExamChoiceQuestion> queryChoiceQuestionInfoById(int examId);

    /**
     * 根据新输入的选择题信息修改选择题
     * 输入examChoiceQuestion
     * 输出int
     */
    public int modifyChoiceQuestionExamInfo(ExamChoiceQuestion examChoiceQuestion);

    /**
     * 根据输入的examChoiceId删除选择题信息
     * 输入examChoiceQuestionId
     * 输出int
     */
    public int deleteChoiceQuestionExamInfo(int examChoiceQuestionId);
}
