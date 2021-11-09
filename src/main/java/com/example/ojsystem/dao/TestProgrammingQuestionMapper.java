package com.example.ojsystem.dao;

import com.example.ojsystem.entity.Exercise;
import com.example.ojsystem.entity.TestProgrammingQuestion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestProgrammingQuestionMapper {
    /**
     * 将习题信息添加到测试习题信息中
     * 输入testProgrammingQuestion
     * 输出int
     */
    public int addTestProgrammingQuestionInfo(@Param("testProgrammingQuestion") TestProgrammingQuestion testProgrammingQuestion);

    /**
     * 从测试习题信息中删除对应的习题信息
     * 输入testProgrammingQuestionId
     * 输出int
     */
    public int deleteTestProgrammingQuestionByTestProgrammingQuestionId(@Param("testProgrammingQuestionId") int testProgrammingQuestionId);

    /**
     * 查询对应测试的全部习题
     * 输入testId
     * 输出List<Exercise>
     */
    public List<Exercise> queryTestProgrammingQuestionByTestId(@Param("testId") int testId);


    /**
     * 查询用户是否完成对应的习题
     * 输入userId,testProgrammingQuestionId
     * 输出testProgrammingResult
     */
    public String queryTestProgrammingResultByUserIdAndTestProgrammingQuestionId(@Param("userId") Integer userId,@Param("testProgrammingQuestionId") Integer testProgrammingQuestionId);

}
