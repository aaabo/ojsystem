package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamHistoryMapper;
import com.example.ojsystem.dao.ExamProgrammingQuestionHistoryMapper;
import com.example.ojsystem.dao.ExamQuestionMapper;
import com.example.ojsystem.entity.*;
import com.example.ojsystem.service.ExamHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamHistoryServiceImpl implements ExamHistoryService{

    @Autowired
    ExamHistoryMapper examHistoryMapper;
    @Autowired
    ExamQuestionMapper examQuestionMapper;
    @Autowired
    ExamProgrammingQuestionHistoryMapper examProgrammingQuestionHistoryMapper;
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
    public Boolean checkUserIfJoinExam(int userId, int examId) {
        Integer i=examHistoryMapper.selectUserIfJoinExam(userId,examId);
        if(i!=null){
            return true;
        }else{
            return false;
        }
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

    /**
     * 查询考试的用户的编程题记录信息
     * 输入examId
     * 输出List<ExamProgrammingScoreTool>
     *
     * @param examId
     */
    public List<ExamProgrammingScoreTool> checkExamUserProgrammingQuestionHistoryInfo(int examId) {
        return examHistoryMapper.selectExamUserProgrammingQuestionHistoryInfo(examId);
    }

    /**
     * 查询各个考试编程题总分和编程题画图用
     * 输入examId
     * 输出List<ExamProgrammingScoreTool>
     *
     * @param examId
     */
    public List<UserExamProgrammingDrawTool> checkExamUserProgrammingQuestionScoreInfoDrawInfo(int examId) {
        List<ExamQuestion> examQuestions=examQuestionMapper.selectExamQuestionProgrammingByExamId(examId);
        List<UserExamProgrammingDrawTool> userExamProgrammingDrawTools=new ArrayList<UserExamProgrammingDrawTool>();
        List<ExamProgrammingTotalAndScore> examProgrammingTotalAndScores=new ArrayList<ExamProgrammingTotalAndScore>();
        for(int i=0;i<examQuestions.size();i++){
            UserExamProgrammingDrawTool userExamProgrammingDrawTool=new UserExamProgrammingDrawTool();
            examProgrammingTotalAndScores=examHistoryMapper.selectExamUserProgrammingQuestionScoreInfoDrawInfo(examId);
            userExamProgrammingDrawTool.setExamQuestionId(examQuestions.get(i).getExamQuestionId());
            for(int o=0;o<examProgrammingTotalAndScores.size();o++){
                Integer score=examProgrammingQuestionHistoryMapper.selectExamProgrammingQuestionScoreHistoryByExamQuestionIdAndUserId(examQuestions.get(i).getExamQuestionId(),examProgrammingTotalAndScores.get(o).getUserId());
                if(score==null){
                    examProgrammingTotalAndScores.get(o).setScore(0);
                }else{
                    examProgrammingTotalAndScores.get(o).setScore(score);
                }

            }
            userExamProgrammingDrawTool.setExamProgrammingTotalAndScores(examProgrammingTotalAndScores);
            userExamProgrammingDrawTools.add(userExamProgrammingDrawTool);
        }

        return userExamProgrammingDrawTools;
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
