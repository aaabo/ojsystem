package com.example.ojsystem.service;

import com.example.ojsystem.entity.TestProgrammingQuestionHistory;
import com.example.ojsystem.entity.TestProgrammingQuestionResultTool;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestProgrammingQuestionHistoryService {
    /**
     * 将提交的测试习题记录保存到后台
     * 输入testProgrammingQuestionHistory
     * 输出int
     */
    public int addTestProgrammingQuestionHistoryInfo(TestProgrammingQuestionHistory testProgrammingQuestionHistory);

    /**
     * 查询测试的提交状态
     * 输入testId
     * 输出测试的状态
     */
    public List<TestProgrammingQuestionResultTool> queryTestRealStatus(int testId);

    /**
     * 查询测试的提交实时提交情况
     * 输入testId
     * 输出测试的提交实时提交状态
     */
    public List<TestProgrammingQuestionHistory> queryTestProgrammingRealStatus(int testId);

    /**
     * 根据测试编程题记录编号来查询对应的测试编程题记录
     * 输入testProgrammingQuestionHistoryId
     * 输出TestProgrammingQuestionHistory
     */
    public TestProgrammingQuestionHistory queryTestProgrammingHistoryByTestProgrammingQuestionHistoryId(int testProgrammingQuestionHistoryId);


    /**
     * 查询测试的提交实时提交情况通过提交的查询信息
     * 输入testId
     * 输出测试的提交实时提交状态
     */
    public List<TestProgrammingQuestionHistory> queryTestProgrammingRealStatusBySearchInfo(@Param("testProgrammingQuestionHistory") TestProgrammingQuestionHistory testProgrammingQuestionHistory);
}
