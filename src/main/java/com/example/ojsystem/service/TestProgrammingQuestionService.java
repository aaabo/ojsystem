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
    public int addTestProgrammingQuestionInfo(TestProgrammingQuestion testProgrammingQuestion);

    /**
     * 从测试习题信息中删除对应的习题信息
     * 输入testProgrammingQuestionId
     * 输出int
     */
    public int deleteTestProgrammingQuestionByTestProgrammingQuestionId(int testProgrammingQuestionId);

    /**
     * 查询对应测试的全部习题
     * 输入testId
     * 输出List<Exercise>
     */
    public List<Exercise> queryTestProgrammingQuestionByTestId(Integer testId,Integer userId);
}
