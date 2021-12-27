package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamHistory;
import com.example.ojsystem.entity.ExamProgrammingScoreTool;
import com.example.ojsystem.entity.ExamUserJoinTool;

import java.util.List;

public interface ExamHistoryService {

    /**
     * 根据考试Id查询考试排行榜
     * 输入examId
     * 输出List<ExamHistory>
     */
    public List<ExamHistory> checkExamRankById(int examId);

    /**
     * 根据用户Id查询参加的考试信息
     * 输入userId
     * 输出List<ExamHistory>
     */
    public List<ExamHistory> checkExamHistoryInfoByUserId(int userId);

    /**
     * 根据用户Id查询是否参加过对应的考试
     * 输入userId,examId
     * 输出List<ExamHistory>
     */
    public Boolean checkUserIfJoinExam(int userId,int examId);
    /**
     * 查询考试用户参加情况
     * 输入examId
     * 输出ExamUserJoinTool
     */
    public ExamUserJoinTool checkExamUserJoinInfo(int examId);

    /**
     * 查询考试结果信息
     * 输入examId
     * 输出List<ExamHistory>
     */
    public List<ExamHistory> checkExamHistoryInfo(int examId);

    /**
     * 查询考试的用户的编程题记录信息
     * 输入examId
     * 输出List<ExamProgrammingScoreTool>
     */
    public List<ExamProgrammingScoreTool> checkExamUserProgrammingQuestionHistoryInfo(int examId);

    public int checkExamChoiceQuestionResultScore(int examId,int userId);

    public int checkExamCompletionQuestionResultScore(int examId,int userId);

    public int checkExamProgrammingQuestionResultScore(int examId,int userId);

    public int saveExamHistory(int userId,int examId,int examChoiceQuestionTotals,int examCompletionQuestionTotals,int examProgrammingTotals);
}
