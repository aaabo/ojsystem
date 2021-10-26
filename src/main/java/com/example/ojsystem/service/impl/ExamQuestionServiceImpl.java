package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamQuestionMapper;
import com.example.ojsystem.entity.ChoiceQuestion;
import com.example.ojsystem.entity.CompletionQuestion;
import com.example.ojsystem.entity.ExamQuestion;
import com.example.ojsystem.entity.Exercise;
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
     * 输出List<ChoiceQuestion>
     *
     * @param examId
     */
    public List<ChoiceQuestion> queryExamQuestionChoiceByExamId(int examId) {
        return examQuestionMapper.queryExamQuestionChoiceByExamId(examId);
    }

    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<CompletionQuestion>
     *
     * @param examId
     */
    public List<CompletionQuestion> queryExamQuestionCompletionByExamId(int examId) {
        return examQuestionMapper.queryExamQuestionCompletionByExamId(examId);
    }

    /**
     * 根据考试id查询对应的编程题信息
     * 输入examId
     * 输出List<Exercise>
     *
     * @param examId
     */
    public List<Exercise> queryExamQuestionProgrammingByExamId(int examId) {
        return examQuestionMapper.queryExamQuestionProgrammingByExamId(examId);
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
    public int addExamQuestion(int examId, int questionId, String examQuestionType) {
        return examQuestionMapper.addExamQuestion(examId,questionId,examQuestionType);
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
    public int deleteExamQuestion(int examId, int questionId, String examQuestionType) {
        return examQuestionMapper.deleteExamQuestion(examId,questionId,examQuestionType);
    }
}
