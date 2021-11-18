package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.TestProgrammingQuestionHistoryMapper;
import com.example.ojsystem.entity.TestProgrammingQuestionHistory;
import com.example.ojsystem.entity.TestProgrammingQuestionResultTool;
import com.example.ojsystem.entity.TestProgrammingQuestionUserSubmitStateTool;
import com.example.ojsystem.service.TestProgrammingQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class TestProgrammingQuestionHistoryServiceImpl implements TestProgrammingQuestionHistoryService{

    @Autowired
    TestProgrammingQuestionHistoryMapper testProgrammingQuestionHistoryMapper;
    /**
     * 将提交的测试习题记录保存到后台
     * 输入testProgrammingQuestionHistory
     * 输出int
     *
     * @param testProgrammingQuestionHistory
     */
    public int addTestProgrammingQuestionHistoryInfo(TestProgrammingQuestionHistory testProgrammingQuestionHistory) {
        //这里进行判题
        testProgrammingQuestionHistory.setTestProgrammingResult("结果未判断");
        return testProgrammingQuestionHistoryMapper.addTestProgrammingQuestionHistoryInfo(testProgrammingQuestionHistory);
    }

    /**
     * 查询测试的提交状态
     * 输入testId
     * 输出测试的状态
     *
     * @param testId
     */
    public List<TestProgrammingQuestionResultTool> queryTestRealStatus(int testId) {
        List<TestProgrammingQuestionResultTool> testProgrammingQuestionResultTools=testProgrammingQuestionHistoryMapper.queryTestUserAndTestProgrammingQuestionId(testId);
        for(int i=0;i<testProgrammingQuestionResultTools.size();i++){
            testProgrammingQuestionResultTools.get(i).setAcceptNumber(new Float(0));
            for(int o = 0; o<testProgrammingQuestionResultTools.get(i).getTestProgrammingQuestionResultStateTools().size(); o++){
                //获取对应测试习题的对错情况
                TestProgrammingQuestionUserSubmitStateTool testProgrammingQuestionUserSubmitStateTool=testProgrammingQuestionHistoryMapper.queryTestProgrammingQuestionUserSubmitStateByTestProgrammingQuestionIdAndUserId(testProgrammingQuestionResultTools.get(i).getTestProgrammingQuestionResultStateTools().get(o).getTestProgrammingQuestionId(),testProgrammingQuestionResultTools.get(i).getUserId());
                if(testProgrammingQuestionUserSubmitStateTool.getSuccess()>0){
                    testProgrammingQuestionResultTools.get(i).getTestProgrammingQuestionResultStateTools().get(o).setTestProgrammingQuestionResult("success");
                    testProgrammingQuestionResultTools.get(i).setAcceptNumber(testProgrammingQuestionResultTools.get(i).getAcceptNumber()+1);
                    continue;
                }else if(testProgrammingQuestionUserSubmitStateTool.getNoSuccess()>0){
                    testProgrammingQuestionResultTools.get(i).getTestProgrammingQuestionResultStateTools().get(o).setTestProgrammingQuestionResult("error");
                    testProgrammingQuestionResultTools.get(i).setAcceptNumber(testProgrammingQuestionResultTools.get(i).getAcceptNumber()-new Float(0.01));
                    continue;
                }else{
                    testProgrammingQuestionResultTools.get(i).getTestProgrammingQuestionResultStateTools().get(o).setTestProgrammingQuestionResult("null");
                    continue;
                }
            }
        }
        Collections.sort(testProgrammingQuestionResultTools, new Comparator<TestProgrammingQuestionResultTool>() {
            public int compare(TestProgrammingQuestionResultTool o1, TestProgrammingQuestionResultTool o2) {
                return o2.getAcceptNumber().compareTo(o1.getAcceptNumber());
            }
        });
        return testProgrammingQuestionResultTools;
    }

    /**
     * 查询测试的提交实时提交情况
     * 输入testId
     * 输出测试的提交实时提交状态
     *
     * @param testId
     */
    public List<TestProgrammingQuestionHistory> queryTestProgrammingRealStatus(int testId) {
        List<TestProgrammingQuestionHistory> testProgrammingQuestionHistories=testProgrammingQuestionHistoryMapper.queryTestProgrammingRealStatus(testId);
        return testProgrammingQuestionHistories;
    }

    /**
     * 根据测试编程题记录编号来查询对应的测试编程题记录
     * 输入testProgrammingQuestionId
     * 输出TestProgrammingQuestionHistory
     *
     * @param testProgrammingQuestionHistoryId
     */
    public TestProgrammingQuestionHistory queryTestProgrammingHistoryByTestProgrammingQuestionHistoryId(int testProgrammingQuestionHistoryId) {
        return testProgrammingQuestionHistoryMapper.queryTestProgrammingHistoryByTestProgrammingQuestionHistoryId(testProgrammingQuestionHistoryId);
    }

    /**
     * 查询测试的提交实时提交情况通过提交的查询信息
     * 输入testId
     * 输出测试的提交实时提交状态
     *
     * @param testProgrammingQuestionHistory
     */
    public List<TestProgrammingQuestionHistory> queryTestProgrammingRealStatusBySearchInfo(TestProgrammingQuestionHistory testProgrammingQuestionHistory) {
        return testProgrammingQuestionHistoryMapper.queryTestProgrammingRealStatusBySearchInfo(testProgrammingQuestionHistory);
    }
}
