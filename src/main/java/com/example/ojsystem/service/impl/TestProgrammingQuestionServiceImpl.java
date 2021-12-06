package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.TestProgrammingQuestionMapper;
import com.example.ojsystem.entity.Exercise;
import com.example.ojsystem.entity.TestProgrammingQuestion;
import com.example.ojsystem.service.TestProgrammingQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestProgrammingQuestionServiceImpl implements TestProgrammingQuestionService{
    @Autowired
    TestProgrammingQuestionMapper testProgrammingQuestionMapper;
    /**
     * 将习题信息添加到测试习题信息中
     * 输入testProgrammingQuestion
     * 输出int
     *
     * @param testProgrammingQuestion
     */
    public int saveTestProgrammingQuestionInfo(TestProgrammingQuestion testProgrammingQuestion) {
        return testProgrammingQuestionMapper.insertTestProgrammingQuestionInfo(testProgrammingQuestion);
    }

    /**
     * 从测试习题信息中删除对应的习题信息
     * 输入testProgrammingQuestionId
     * 输出int
     *
     * @param testProgrammingQuestionId
     */
    public int cancelTestProgrammingQuestionByTestProgrammingQuestionId(int testProgrammingQuestionId) {
        return testProgrammingQuestionMapper.deleteTestProgrammingQuestionByTestProgrammingQuestionId(testProgrammingQuestionId);
    }

    /**
     * 查询用户的测试习题是否正确并输出全部测试习题
     * 输入testId,userId
     * 输出List<Exercise>
     *
     * @param testId
     */
    public List<Exercise> checkTestProgrammingQuestionAndIsSuccess(Integer testId,Integer userId) {
        List<Exercise> exercises=testProgrammingQuestionMapper.selectTestProgrammingQuestionByTestId(testId);
        for(int i=0;i<exercises.size();i++){
            //赋值习题描述为改用户的提交题目的结果
            exercises.get(i).setExerciseDescription(testProgrammingQuestionMapper.selectTestProgrammingResultByUserIdAndTestProgrammingQuestionId(userId,exercises.get(i).getExerciseId()));
        }

        return exercises;
    }

    /**
     * 查询对应测试的全部习题  测试详情使用（exerciseId 为testProgrammingId exerciseCorrectTimes，exerciseSubmitTimes为正确率）
     * 输入testId
     * 输出List<Exercise>
     *
     * @param testId
     */
    public List<Exercise> checkTestProgrammingQuestionByTestId(Integer testId) {
        return testProgrammingQuestionMapper.selectTestProgrammingQuestionByTestId(testId);
    }

    /**
     * 查询对应测试的全部测试编程题
     * 输入testId
     * 输出List<TestProgrammingQuestion>
     *
     * @param testId
     */
    public List<TestProgrammingQuestion> checkTestProgrammingQuestionInfoByTestId(Integer testId) {
        return testProgrammingQuestionMapper.selectTestProgrammingQuestionInfoByTestId(testId);
    }

    /**
     * 根据测试编程题编号查询对应的习题信息
     * 输入testProgrammingQuestionId
     * 输出Exercise
     *
     * @param testProgrammingQuestionId
     */
    public Exercise checkExerciseByTestProgrammingQuestionId(Integer testProgrammingQuestionId) {
        return testProgrammingQuestionMapper.selectExerciseByTestProgrammingQuestionId(testProgrammingQuestionId);
    }

    /**
     * 根据测试编程题编号查询testId
     * 输入testProgrammingQuestionId
     * 输出Integer
     *
     * @param testProgrammingQuestionId
     */
    public Integer checkTestIdByTestProgrammingQuestionId(Integer testProgrammingQuestionId) {
        return testProgrammingQuestionMapper.selectTestIdByTestProgrammingQuestionId(testProgrammingQuestionId);
    }
}
