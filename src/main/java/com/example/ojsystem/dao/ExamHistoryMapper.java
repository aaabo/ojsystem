package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExamHistory;
import com.example.ojsystem.entity.ExamUserJoinTool;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExamHistoryMapper {
    /**
     * 根据考试Id查询考试排行榜
     * 输入examId
     * 输出List<ExamHistory>
     */
    public List<ExamHistory> queryExamRankById(@Param("examId") int examId);

    /**
     * 根据用户Id查询参加的考试信息
     * 输入userId
     * 输出List<ExamHistory>
     */
    public List<ExamHistory> queryExamHistoryInfoByUserId(@Param("userId") int userId);

    /**
     * 根据用户Id查询是否参加过对应的考试
     * 输入userId,examId
     * 输出List<ExamHistory>
     */
    public int queryUserIfJoinExam(@Param("userId") int userId,@Param("examId") int examId);

    /**
     * 查询考试用户参加情况
     * 输入examId
     * 输出ExamUserJoinTool
     */
    public ExamUserJoinTool queryExamUserJoinInfo(@Param("examId") int examId);

    /**
     * 查询考试结果信息
     * 输入examId
     * 输出List<ExamHistory>
     */
    public List<ExamHistory> queryExamHistoryInfo(@Param("examId")int examId);

    public int queryExamChoiceQuestionResultScore(@Param("examId") int examId,@Param("userId") int userId);

    public int queryExamCompletionQuestionResultScore(@Param("examId") int examId,@Param("userId") int userId);

    public int queryExamProgrammingQuestionResultScore(@Param("examId") int examId,@Param("userId") int userId);

    public int addExamHistory(@Param("userId")int userId,@Param("examId")int examId,@Param("examChoiceQuestionTotals")int examChoiceQuestionTotals,
                              @Param("examCompletionQuestionTotals")int examCompletionQuestionTotals,@Param("examProgrammingTotals")int examProgrammingTotals);
}
