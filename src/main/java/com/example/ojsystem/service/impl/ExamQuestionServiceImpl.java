package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamQuestionMapper;
import com.example.ojsystem.entity.*;
import com.example.ojsystem.service.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamQuestionServiceImpl implements ExamQuestionService{
    @Autowired
    ExamQuestionMapper examQuestionMapper;
    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<ExamQuestion>
     *
     * @param examId
     */
    public List<ExamQuestion> checkExamQuestionChoiceByExamId(int examId) {
        return examQuestionMapper.selectExamQuestionChoiceByExamId(examId);
    }

    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<ExamQuestion>
     *
     * @param examId
     */
    public List<ExamQuestion> checkExamQuestionCompletionByExamId(int examId) {
        return examQuestionMapper.selectExamQuestionCompletionByExamId(examId);
    }

    /**
     * 根据考试id查询对应的编程题信息
     * 输入examId
     * 输出List<ExamQuestion>
     *
     * @param examId
     */
    public List<ExamQuestion> checkExamQuestionProgrammingByExamId(int examId) {
        return examQuestionMapper.selectExamQuestionProgrammingByExamId(examId);
    }

    /**
     * 根据题目类型和题目编号添加考试题目
     * 输入examId,questionId
     * 输出int
     *
     * @param examId
     * @param questionId
     * @param examQuestionType
     */
    public int saveExamQuestionInfo(int examId, int questionId, String examQuestionType) {
        return examQuestionMapper.insertExamQuestionInfo(examId,questionId,examQuestionType);
    }

    /**
     * 根据题目类型和题目编号题目类型删除对应的考试题目
     * 输入examId,questionId,examQuestionType
     * 输出int
     *
     * @param examId
     * @param questionId
     * @param examQuestionType
     */
    public int cancelExamQuestionInfo(int examId, int questionId, String examQuestionType) {
        return examQuestionMapper.deleteExamQuestionInfo(examId,questionId,examQuestionType);
    }

    /**
     * 根据考试编号查询编程题的各题平均分
     * 输入examId
     * 输出List<ExamProgrammingResultScoreTool>
     *
     * @param examId
     */
    public List<ExamProgrammingResultScoreTool> checkExamProgrammingResultScoreByExamId(int examId) {
        return examQuestionMapper.selectExamProgrammingResultScoreByExamId(examId);
    }

    /**
     * 根据考试编号查询考试结果的各个分数段
     * 输入examId
     * 输出UserExamScoreEachSegmentNumber
     *
     * @param examId
     */
    public UserExamScoreEachSegmentNumber checkUserExamScoreEachSegmentNumberByExamId(int examId) {
        return examQuestionMapper.selectUserExamScoreEachSegmentNumberByExamId(examId);
    }
}
