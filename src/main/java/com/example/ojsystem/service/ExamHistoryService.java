package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamHistory;
import com.example.ojsystem.entity.ExamUserJoinTool;

import java.util.List;

public interface ExamHistoryService {

    /**
     * 根据考试Id查询考试排行榜
     * 输入examId
     * 输出List<ExamHistory>
     */
    public List<ExamHistory> queryExamRankById(int examId);

    /**
     * 根据用户Id查询参加的考试信息
     * 输入userId
     * 输出List<ExamHistory>
     */
    public List<ExamHistory> queryExamHistoryInfoByUserId(int userId);

    /**
     * 根据用户Id查询是否参加过对应的考试
     * 输入userId,examId
     * 输出List<ExamHistory>
     */
    public int queryUserIfJoinExam(int userId,int examId);

    /**
     * 查询考试用户参加情况
     * 输入examId
     * 输出ExamUserJoinTool
     */
    public ExamUserJoinTool queryExamUserJoinInfo(int examId);

    public int queryExamChoiceQuestionResultScore(int examId,int userId);

    public int queryExamCompletionQuestionResultScore(int examId,int userId);

    public int queryExamProgrammingQuestionResultScore(int examId,int userId);

    public int addExamHistory(int userId,int examId,int examChoiceQuestionTotals,int examCompletionQuestionTotals,int examProgrammingTotals);
}
