package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamHistoryMapper;
import com.example.ojsystem.entity.ExamHistory;
import com.example.ojsystem.entity.ExamUserJoinTool;
import com.example.ojsystem.service.ExamHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamHistoryServiceImpl implements ExamHistoryService{

    @Autowired
    ExamHistoryMapper examHistoryMapper;
    /**
     * 根据考试Id查询考试排行榜
     * 输入examId
     * 输出List<ExamHistory>
     *
     * @param examId
     */
    public List<ExamHistory> queryExamRankById(int examId) {
        return examHistoryMapper.queryExamRankById(examId);
    }

    /**
     * 根据用户Id查询参加的考试信息
     * 输入userId
     * 输出List<ExamHistory>
     *
     * @param userId
     */
    public List<ExamHistory> queryExamHistoryInfoByUserId(int userId) {
        return examHistoryMapper.queryExamHistoryInfoByUserId(userId);
    }

    /**
     * 根据用户Id查询是否参加过对应的考试
     * 输入userId,examId
     * 输出List<ExamHistory>
     *
     * @param userId
     * @param examId
     */
    public int queryUserIfJoinExam(int userId, int examId) {
        return examHistoryMapper.queryUserIfJoinExam(userId,examId);
    }

    /**
     * 查询考试用户参加情况
     * 输入examId
     * 输出ExamUserJoinTool
     *
     * @param examId
     */
    public ExamUserJoinTool queryExamUserJoinInfo(int examId) {
        return examHistoryMapper.queryExamUserJoinInfo(examId);
    }

    /**
     * 查询考试结果信息
     * 输入examId
     * 输出List<ExamHistory>
     *
     * @param examId
     */
    public List<ExamHistory> queryExamHistoryInfo(int examId) {
        return examHistoryMapper.queryExamHistoryInfo(examId);
    }

    public int queryExamChoiceQuestionResultScore(int examId,int userId){
        return examHistoryMapper.queryExamChoiceQuestionResultScore(examId,userId);
    }

    public int queryExamCompletionQuestionResultScore(int examId,int userId){
        return examHistoryMapper.queryExamCompletionQuestionResultScore(examId,userId);
    }

    public int queryExamProgrammingQuestionResultScore(int examId,int userId){
        return examHistoryMapper.queryExamProgrammingQuestionResultScore(examId,userId);
    }

    public int addExamHistory(int userId,int examId,int examChoiceQuestionTotals,int examCompletionQuestionTotals,int examProgrammingTotals){
        return examHistoryMapper.addExamHistory(userId,examId,examChoiceQuestionTotals,examCompletionQuestionTotals,examProgrammingTotals);
    }
}
