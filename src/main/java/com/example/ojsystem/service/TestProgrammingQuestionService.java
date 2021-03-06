package com.example.ojsystem.service;

import com.example.ojsystem.entity.Exercise;
import com.example.ojsystem.entity.TestProgrammingQuestion;

import java.util.List;

public interface TestProgrammingQuestionService {
    /**
     * 将习题信息添加到测试习题信息中
     * 输入testProgrammingQuestion
     * 输出int
     */
    public int saveTestProgrammingQuestionInfo(TestProgrammingQuestion testProgrammingQuestion);

    /**
     * 从测试习题信息中删除对应的习题信息
     * 输入testProgrammingQuestionId
     * 输出int
     */
    public int cancelTestProgrammingQuestionByTestProgrammingQuestionId(int testProgrammingQuestionId);

    /**
     * 查询用户的测试习题是否正确并输出全部测试习题
     * 输入testId,userId
     * 输出List<Exercise>
     */
    public List<Exercise> checkTestProgrammingQuestionAndIsSuccess(Integer testId,Integer userId);

    /**
     * 查询对应测试的全部习题  测试详情使用（exerciseId 为testProgrammingId exerciseCorrectTimes，exerciseSubmitTimes为正确率）
     * 输入testId
     * 输出List<Exercise>
     */
    public List<Exercise> checkTestProgrammingQuestionByTestId(Integer testId);

    /**
     * 查询对应测试的全部测试编程题
     * 输入testId
     * 输出List<TestProgrammingQuestion>
     */
    public List<TestProgrammingQuestion> checkTestProgrammingQuestionInfoByTestId(Integer testId);

    /**
     * 根据测试编程题编号查询对应的习题信息
     * 输入testProgrammingQuestionId
     * 输出Exercise
     */
    public Exercise checkExerciseByTestProgrammingQuestionId(Integer testProgrammingQuestionId);

    /**
     * 根据测试编程题编号查询testId
     * 输入testProgrammingQuestionId
     * 输出Integer
     */
    public Integer checkTestIdByTestProgrammingQuestionId(Integer testProgrammingQuestionId);
}
