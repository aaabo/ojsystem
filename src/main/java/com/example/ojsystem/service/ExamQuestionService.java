package com.example.ojsystem.service;

import com.example.ojsystem.entity.*;

import java.util.List;

public interface ExamQuestionService {
    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<ChoiceQuestion>
     */
    public List<ChoiceQuestion> queryExamQuestionChoiceByExamId(int examId);

    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<CompletionQuestion>
     */
    public List<CompletionQuestion> queryExamQuestionCompletionByExamId(int examId);

    /**
     * 根据考试id查询对应的编程题信息
     * 输入examId
     * 输出List<Exercise>
     */
    public List<Exercise> queryExamQuestionProgrammingByExamId(int examId);


    /**
     * 根据题目类型和题目编号添加考试题目
     * 输入examId,questionId
     * 输出int
     */
    public int addExamQuestion(int examId,int questionId,String examQuestionType);

    /**
     * 根据题目类型和题目编号题目类型删除对应的考试题目
     * 输入examId,questionId,examQuestionType
     * 输出int
     */
    public int deleteExamQuestion(int examId,int questionId,String examQuestionType);

    /**
     * 根据考试编号查询编程题的各题平均分
     * 输入examId
     * 输出List<ExamProgrammingResultScoreTool>
     */
    public List<ExamProgrammingResultScoreTool> queryExamProgrammingResultScoreByExamId(int examId);

    /**
     * 根据考试编号查询考试结果的各个分数段
     * 输入examId
     * 输出UserExamScoreEachSegmentNumber
     */
    public UserExamScoreEachSegmentNumber queryUserExamScoreEachSegmentNumberByExamId(int examId);
}
