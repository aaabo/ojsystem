package com.example.ojsystem.service;

import com.example.ojsystem.entity.TestProgrammingQuestionHistory;
import com.example.ojsystem.entity.TestStanding;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestProgrammingQuestionHistoryService {
    /**
     * 将提交的测试习题记录保存到后台
     * 输入testProgrammingQuestionHistory
     * 输出int
     */
    public int saveTestProgrammingQuestionHistoryInfo(TestProgrammingQuestionHistory testProgrammingQuestionHistory);

    /**
     * 查询测试的提交状态
     * 输入testId
     * 输出测试的状态
     */
    public List<TestStanding> checkTestStandingInfo(int testId);

    /**
     * 查询测试的提交实时提交情况
     * 输入testId
     * 输出测试的提交实时提交状态
     */
    public List<TestProgrammingQuestionHistory> checkTestProgrammingRealStatus(int testId);

    /**
     * 根据测试编程题记录编号来查询对应的测试编程题记录
     * 输入testProgrammingQuestionHistoryId
     * 输出TestProgrammingQuestionHistory
     */
    public TestProgrammingQuestionHistory checkTestProgrammingHistoryByTestProgrammingQuestionHistoryId(int testProgrammingQuestionHistoryId);


    /**
     * 查询测试的提交实时提交情况通过提交的查询信息
     * 输入testId
     * 输出测试的提交实时提交状态
     */
    public List<TestProgrammingQuestionHistory> checkTestProgrammingRealStatusBySearchInfo(@Param("testProgrammingQuestionHistory") TestProgrammingQuestionHistory testProgrammingQuestionHistory);
}
