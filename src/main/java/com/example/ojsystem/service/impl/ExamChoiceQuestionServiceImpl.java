package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamChoiceQuestionMapper;
import com.example.ojsystem.entity.ExamChoiceQuestion;
import com.example.ojsystem.service.ExamChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamChoiceQuestionServiceImpl implements ExamChoiceQuestionService {
    @Autowired
    ExamChoiceQuestionMapper examChoiceQuestionMapper;

    /**
     * 根据考试id和选择题信息添加选择题信息
     * 输入examChoiceQuestion
     * 输出int
     *
     * @param examChoiceQuestion
     */
    public int addChoiceQuestionExamInfo(ExamChoiceQuestion examChoiceQuestion) {
        return examChoiceQuestionMapper.addChoiceQuestionExamInfo(examChoiceQuestion);
    }

    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<ExamChoiceQuestion>
     *
     * @param examId
     */
    public List<ExamChoiceQuestion> queryChoiceQuestionInfoById(int examId) {
        return examChoiceQuestionMapper.queryChoiceQuestionInfoById(examId);
    }

    /**
     * 根据新输入的选择题信息修改选择题
     * 输入examChoiceQuestion
     * 输出int
     *
     * @param examChoiceQuestion
     */
    public int modifyChoiceQuestionExamInfo(ExamChoiceQuestion examChoiceQuestion) {
        return examChoiceQuestionMapper.modifyChoiceQuestionExamInfo(examChoiceQuestion);
    }

    /**
     * 根据输入的examChoiceId删除选择题信息
     * 输入examChoiceQuestionId
     * 输出int
     *
     * @param examChoiceQuestionId
     */
    public int deleteChoiceQuestionExamInfo(int examChoiceQuestionId) {
        return examChoiceQuestionMapper.deleteChoiceQuestionExamInfo(examChoiceQuestionId);
    }

    /**
     * 根据输入的examId查询考试的选择题总分
     * 输入examId
     * 输出int
     *
     * @param examId
     */
    public int queryChoiceQuestionTotalScore(int examId) {
        return examChoiceQuestionMapper.queryChoiceQuestionTotalScore(examId);
    }


}
