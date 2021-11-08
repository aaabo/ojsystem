package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.AdminMapper;
import com.example.ojsystem.dao.TestMapper;
import com.example.ojsystem.entity.Test;
import com.example.ojsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    TestMapper testMapper;

    /**
     * 根据输入的测试信息来添加测试
     * 输入test
     * 输出int
     *
     * @param test
     */
    public int addTestInfo(Test test) {
        return testMapper.addTestInfo(test);
    }

    /**
     * 根据输入的测试信息来修改测试
     * 输入test
     * 输出int
     *
     * @param test
     */
    public int modifyTestInfo(Test test) {
        return testMapper.modifyTestInfo(test);
    }

    /**
     * 根据输入的测试id来删除对应的测试
     * 输入testId
     * 输出int
     *
     * @param testId
     */
    public int deleteTestInfoByTestId(int testId) {
        return testMapper.deleteTestInfoByTestId(testId);
    }

    /**
     * 查询（应该用不到了）
     * 输入null
     * 输出List<Test>
     */
    public List<Test> queryTestInfoByTestStatus() {
        return testMapper.queryTestInfoByTestStatus();
    }

    /**
     * 根据testId和输入的testStatus修改测试状态
     * 输入testId,testStatus
     * 输出int
     *
     * @param test
     */
    public int modifyTestStatusByTestId(Test test) {
        return testMapper.modifyTestStatusByTestId(test);
    }

    /**
     * 根据测试名称,测试状态，创建人来查询测试信息
     * 输入test
     * 输出List<Test>
     *
     * @param test
     */
    public List<Test> searchTestInfo(Test test) {
        return testMapper.searchTestInfo(test);
    }

    /**
     * 查询为结束的测试
     * 输入null
     * 输出List<Test>
     */
    public List<Test> queryNotFinishTestInfo() {
        return testMapper.queryNotFinishTestInfo();
    }
}
