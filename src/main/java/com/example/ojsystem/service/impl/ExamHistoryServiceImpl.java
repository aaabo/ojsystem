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
    public List<ExamHistory> checkExamRankById(int examId) {
        return examHistoryMapper.selectExamRankById(examId);
    }

    /**
     * 根据用户Id查询参加的考试信息
     * 输入userId
     * 输出List<ExamHistory>
     *
     * @param userId
     */
    public List<ExamHistory> checkExamHistoryInfoByUserId(int userId) {
        return examHistoryMapper.selectExamHistoryInfoByUserId(userId);
    }

    /**
     * 根据用户Id查询是否参加过对应的考试
     * 输入userId,examId
     * 输出List<ExamHistory>
     *
     * @param userId
     * @param examId
     */
    public int checkUserIfJoinExam(int userId, int examId) {
        return examHistoryMapper.selectUserIfJoinExam(userId,examId);
    }

    /**
     * 查询考试用户参加情况
     * 输入examId
     * 输出ExamUserJoinTool
     *
     * @param examId
     */
    public ExamUserJoinTool checkExamUserJoinInfo(int examId) {
        return examHistoryMapper.selectExamUserJoinInfo(examId);
    }

    /**
     * 查询考试结果信息
     * 输入examId
     * 输出List<ExamHistory>
     *
     * @param examId
     */
    public List<ExamHistory> checkExamHistoryInfo(int examId) {
        return examHistoryMapper.selectExamHistoryInfo(examId);
    }

    public int checkExamChoiceQuestionResultScore(int examId,int userId){
        return examHistoryMapper.selectExamChoiceQuestionResultScore(examId,userId);
    }

    public int checkExamCompletionQuestionResultScore(int examId,int userId){
        return examHistoryMapper.selectExamCompletionQuestionResultScore(examId,userId);
    }

    public int checkExamProgrammingQuestionResultScore(int examId,int userId){
        return examHistoryMapper.selectExamProgrammingQuestionResultScore(examId,userId);
    }

    public int saveExamHistory(int userId,int examId,int examChoiceQuestionTotals,int examCompletionQuestionTotals,int examProgrammingTotals){
        return examHistoryMapper.insertExamHistory(userId,examId,examChoiceQuestionTotals,examCompletionQuestionTotals,examProgrammingTotals);
    }
}
