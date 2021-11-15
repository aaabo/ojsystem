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
    public int addTestProgrammingQuestionInfo(TestProgrammingQuestion testProgrammingQuestion) {
        return testProgrammingQuestionMapper.addTestProgrammingQuestionInfo(testProgrammingQuestion);
    }

    /**
     * 从测试习题信息中删除对应的习题信息
     * 输入testProgrammingQuestionId
     * 输出int
     *
     * @param testProgrammingQuestionId
     */
    public int deleteTestProgrammingQuestionByTestProgrammingQuestionId(int testProgrammingQuestionId) {
        return testProgrammingQuestionMapper.deleteTestProgrammingQuestionByTestProgrammingQuestionId(testProgrammingQuestionId);
    }

    /**
     * 查询用户的测试习题是否正确并输出全部测试习题
     * 输入testId,userId
     * 输出List<Exercise>
     *
     * @param testId
     */
    public List<Exercise> queryTestProgrammingQuestionAndIsSuccess(Integer testId,Integer userId) {
        List<Exercise> exercises=testProgrammingQuestionMapper.queryTestProgrammingQuestionByTestId(testId);
        for(int i=0;i<exercises.size();i++){
            //赋值习题描述为改用户的提交题目的结果
            exercises.get(i).setExerciseDescription(testProgrammingQuestionMapper.queryTestProgrammingResultByUserIdAndTestProgrammingQuestionId(userId,exercises.get(i).getExerciseId()));
        }

        return exercises;
    }

    /**
     * 查询对应测试的全部习题
     * 输入testId
     * 输出List<Exercise>
     *
     * @param testId
     */
    public List<Exercise> queryTestProgrammingQuestionByTestId(Integer testId) {
        return testProgrammingQuestionMapper.queryTestProgrammingQuestionByTestId(testId);
    }

    /**
     * 根据测试编程题编号查询对应的习题信息
     * 输入testProgrammingQuestionId
     * 输出Exercise
     *
     * @param testProgrammingQuestionId
     */
    public Exercise queryExerciseByTestProgrammingQuestionId(Integer testProgrammingQuestionId) {
        return testProgrammingQuestionMapper.queryExerciseByTestProgrammingQuestionId(testProgrammingQuestionId);
    }
}
