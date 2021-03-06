package com.example.ojsystem.dao;

import com.example.ojsystem.entity.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    /**
     * 根据输入的测试信息来添加测试
     * 输入test
     * 输出int
     */
    public int insertTestInfo(@Param("test") Test test);

    /**
     * 根据输入的测试信息来修改测试
     * 输入test
     * 输出int
     */
    public int updateTestInfo(@Param("test")Test test);

    /**
     * 根据输入的测试id来删除对应的测试
     * 输入testId
     * 输出int
     */
    public int deleteTestInfoByTestId(@Param("testId") int testId);

    /**
     * 查询（应该用不到了）
     * 输入null
     * 输出List<Test>
     */
    public List<Test> selectTestInfoByTestStatus();

    /**
     * 根据testId和输入的testStatus修改测试状态
     * 输入testId,testStatus
     * 输出int
     */
    public int updateTestStatusByTestId(@Param("test") Test test);

    /**
     * 根据测试名称,测试状态，创建人来查询测试信息
     * 输入test
     * 输出List<Test>
     */
    public List<Test> selectSearchTestInfo(@Param("test") Test test);

    /**
     * 查询为结束的测试
     * 输入null
     * 输出List<Test>
     */
    public List<Test> selectNotFinishTestInfo();

    /**
     * 根据testId来查询对应的测试信息
     * 输入testId
     * 输出Test
     */
    public Test selectTestInfoByTestId(@Param("testId")int testId);

    /**
     * 根据groupId来删除对应的测试信息
     * 输入groupId
     * 输出Integer
     */
    public Integer deleteTestInfoByGroupId(@Param("groupId")int groupId);
}
