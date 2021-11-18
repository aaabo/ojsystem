package com.example.ojsystem.dao;

import com.example.ojsystem.entity.TestProgrammingQuestionHistory;
import com.example.ojsystem.entity.TestProgrammingQuestionResultTool;
import com.example.ojsystem.entity.TestProgrammingQuestionUserSubmitStateTool;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestProgrammingQuestionHistoryMapper {
    /**
     * 将提交的测试习题记录保存到后台
     * 输入testProgrammingQuestionHistory
     * 输出int
     */
    public int addTestProgrammingQuestionHistoryInfo(@Param("testProgrammingQuestionHistory") TestProgrammingQuestionHistory testProgrammingQuestionHistory);



    /**
     * 根据测试编号将查询考试的用户和题目
     * 输入testId
     * 输出 List<TestProgrammingQuestionResultTool>
     */
    public List<TestProgrammingQuestionResultTool> queryTestUserAndTestProgrammingQuestionId(@Param("testId") int  testId);

    /**
     * 根据用户查询测试题目的正确提交情况
     * 输入userId,testProgrammingQuestionId
     * 输出TestProgrammingQuestionUserSubmitStateTool
     */
    public TestProgrammingQuestionUserSubmitStateTool queryTestProgrammingQuestionUserSubmitStateByTestProgrammingQuestionIdAndUserId(@Param("testProgrammingQuestionId") int  testProgrammingQuestionId,@Param("userId") int  userId);

    /**
     * 查询测试的提交实时提交情况
     * 输入testId
     * 输出测试的提交实时提交状态
     */
    public List<TestProgrammingQuestionHistory> queryTestProgrammingRealStatus(@Param("testId")int testId);

    /**
     * 根据测试编程题的编号查询为该测试的第几题目
     * 输入testId
     * 输出为第几
     */
    public int queryTestProgrammingQuestionOrder(@Param("testId")int testId,@Param("testProgrammingQuestionId") int testProgrammingQuestionId);

    /**
     * 根据测试编程题记录编号来查询对应的测试编程题记录
     * 输入testProgrammingQuestionId
     * 输出TestProgrammingQuestionHistory
     */
    public TestProgrammingQuestionHistory queryTestProgrammingHistoryByTestProgrammingQuestionHistoryId(@Param("testProgrammingQuestionHistoryId") int testProgrammingQuestionHistoryId);

    /**
     * 查询测试的提交实时提交情况通过提交的查询信息
     * 输入testId
     * 输出测试的提交实时提交状态
     */
    public List<TestProgrammingQuestionHistory> queryTestProgrammingRealStatusBySearchInfo(@Param("testProgrammingQuestionHistory") TestProgrammingQuestionHistory testProgrammingQuestionHistory);
}
