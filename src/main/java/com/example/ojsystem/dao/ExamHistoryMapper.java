package com.example.ojsystem.dao;

import com.example.ojsystem.entity.*;
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
    public List<ExamHistory> selectExamRankById(@Param("examId") int examId);

    /**
     * 根据用户Id查询参加的考试信息
     * 输入userId
     * 输出List<ExamHistory>
     */
    public List<ExamHistory> selectExamHistoryInfoByUserId(@Param("userId") int userId);

    /**
     * 根据用户Id查询是否参加过对应的考试
     * 输入userId,examId
     * 输出List<ExamHistory>
     */
    public Integer selectUserIfJoinExam(@Param("userId") int userId,@Param("examId") int examId);

    /**
     * 查询考试用户参加情况
     * 输入examId
     * 输出ExamUserJoinTool
     */
    public ExamUserJoinTool selectExamUserJoinInfo(@Param("examId") int examId);

    /**
     * 查询考试结果信息
     * 输入examId
     * 输出List<ExamHistory>
     */
    public List<ExamHistory> selectExamHistoryInfo(@Param("examId")int examId);

    /**
     * 查询考试的用户的编程题记录信息
     * 输入examId
     * 输出List<ExamProgrammingScoreTool>
     */
    public List<ExamProgrammingScoreTool> selectExamUserProgrammingQuestionHistoryInfo(@Param("examId") int examId);

    /**
     * 查询各个考试编程题总分和编程题画图用
     * 输入examId
     * 输出List<ExamProgrammingScoreTool>
     *
     * @param examId
     */
    public List<ExamProgrammingTotalAndScore> selectExamUserProgrammingQuestionScoreInfoDrawInfo(@Param("examId") int examId);

    public int selectExamChoiceQuestionResultScore(@Param("examId") int examId,@Param("userId") int userId);

    public int selectExamCompletionQuestionResultScore(@Param("examId") int examId,@Param("userId") int userId);

    public int selectExamProgrammingQuestionResultScore(@Param("examId") int examId,@Param("userId") int userId);

    public int insertExamHistory(@Param("userId")int userId,@Param("examId")int examId,@Param("examChoiceQuestionTotals")int examChoiceQuestionTotals,
                              @Param("examCompletionQuestionTotals")int examCompletionQuestionTotals,@Param("examProgrammingTotals")int examProgrammingTotals);
}
