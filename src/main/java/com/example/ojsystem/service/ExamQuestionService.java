package com.example.ojsystem.service;

import com.example.ojsystem.entity.*;

import java.util.List;

public interface ExamQuestionService {
    /**
     * 根据考试id查询对应的考试题目信息
     * 输入examId
     * 输出List<ExamQuestion>
     */
    public List<ExamQuestion> checkExamQuestionByExamId(int examId);
    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<ExamQuestion>
     */
    public List<ExamQuestion> checkExamQuestionChoiceByExamId(int examId);

    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<ExamQuestion>
     */
    public List<ExamQuestion> checkExamQuestionCompletionByExamId(int examId);

    /**
     * 根据考试id查询对应的编程题信息
     * 输入examId
     * 输出List<ExamQuestion>
     */
    public List<ExamQuestion> checkExamQuestionProgrammingByExamId(int examId);


    /**
     * 根据考试id查询对应的编程题信息
     * 输入examId
     * 输出List<ExamQuestion>
     */
    public List<ExamQuestion> checkExamQuestionProgrammingByExamIdAndExamQuestionType(int examId,String examQuestionType);


    /**
     * 根据题目类型和题目编号添加考试题目
     * 输入examId,questionId
     * 输出int
     */
    public int saveExamQuestionInfo(int examId,int questionId,String examQuestionType);

    /**
     * 根据题目类型和题目编号题目类型删除对应的考试题目
     * 输入examId,questionId,examQuestionType
     * 输出int
     */
    public int cancelExamQuestionInfo(int examId,int questionId,String examQuestionType);

    /**
     * 根据考试编号查询编程题的各题平均分
     * 输入examId
     * 输出List<ExamProgrammingResultScoreTool>
     */
    public List<ExamProgrammingResultScoreTool> checkExamProgrammingResultScoreByExamId(int examId);

    /**
     * 根据考试编号查询考试结果的各个分数段
     * 输入examId
     * 输出UserExamScoreEachSegmentNumber
     */
    public UserExamScoreEachSegmentNumber checkUserExamScoreEachSegmentNumberByExamId(int examId);


}
