package com.example.ojsystem.service;

import com.example.ojsystem.entity.Test;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface TestService {
    /**
     * 根据输入的测试信息来添加测试
     * 输入test
     * 输出int
     */
    public int addTestInfo(Test test);

    /**
     * 根据输入的测试信息来修改测试
     * 输入test
     * 输出int
     */
    public int modifyTestInfo(Test test);


    /**
     * 根据输入的测试id来删除对应的测试
     * 输入testId
     * 输出int
     */
    public int deleteTestInfoByTestId(int testId);

    /**
     * 查询（应该用不到了）
     * 输入null
     * 输出List<Test>
     */
    public List<Test> queryTestInfoByTestStatus();

    /**
     * 根据testId和输入的testStatus修改测试状态
     * 输入testId,testStatus
     * 输出int
     */
    public int modifyTestStatusByTestId(Test test);

    /**
     * 根据测试名称,测试状态，创建人来查询测试信息
     * 输入test
     * 输出List<Test>
     */
    public List<Test> searchTestInfo(Test test);

    /**
     * 查询为结束的测试
     * 输入null
     * 输出List<Test>
     */
    public List<Test> queryNotFinishTestInfo();
}
