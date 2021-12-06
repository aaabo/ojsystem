package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.TestProgrammingQuestionHistoryMapper;
import com.example.ojsystem.entity.TestProgrammingQuestionHistory;
import com.example.ojsystem.entity.TestStanding;
import com.example.ojsystem.entity.TestProgrammingQuestionUserSubmitStateTool;
import com.example.ojsystem.service.TestProgrammingQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public int saveTestProgrammingQuestionHistoryInfo(TestProgrammingQuestionHistory testProgrammingQuestionHistory) {
        //这里进行判题
        testProgrammingQuestionHistory.setTestProgrammingResult("结果未判断");
        return testProgrammingQuestionHistoryMapper.insertTestProgrammingQuestionHistoryInfo(testProgrammingQuestionHistory);
    }

    /**
     * 查询测试的提交状态
     * 输入testId
     * 输出测试的状态
     *
     * @param testId
     */
    public List<TestStanding> checkTestStanding(int testId) {
        List<TestStanding> testStandings =testProgrammingQuestionHistoryMapper.selectTestUserAndTestProgrammingQuestionId(testId);
        for(int i = 0; i< testStandings.size(); i++){
            testStandings.get(i).setAcceptNumber(new Float(0));
            for(int o = 0; o< testStandings.get(i).getTestProgrammingQuestionResultStateTools().size(); o++){
                //获取对应测试习题的对错情况 对或者错的类
                TestProgrammingQuestionUserSubmitStateTool testProgrammingQuestionUserSubmitStateTool=testProgrammingQuestionHistoryMapper.selectTestProgrammingQuestionUserSubmitStateByTestProgrammingQuestionIdAndUserId(testStandings.get(i).getTestProgrammingQuestionResultStateTools().get(o).getTestProgrammingQuestionId(), testStandings.get(i).getUserId());
                if(testProgrammingQuestionUserSubmitStateTool.getSuccess()>0){
                    testStandings.get(i).getTestProgrammingQuestionResultStateTools().get(o).setTestProgrammingQuestionResult("success");
                    testStandings.get(i).setAcceptNumber(testStandings.get(i).getAcceptNumber()+1);
                    continue;
                }else if(testProgrammingQuestionUserSubmitStateTool.getNoSuccess()>0){
                    testStandings.get(i).getTestProgrammingQuestionResultStateTools().get(o).setTestProgrammingQuestionResult("error");
                    testStandings.get(i).setAcceptNumber(testStandings.get(i).getAcceptNumber()-new Float(0.01));
                    continue;
                }else{
                    testStandings.get(i).getTestProgrammingQuestionResultStateTools().get(o).setTestProgrammingQuestionResult("null");
                    continue;
                }
            }
        }
        Collections.sort(testStandings, new Comparator<TestStanding>() {
            public int compare(TestStanding o1, TestStanding o2) {
                return o2.getAcceptNumber().compareTo(o1.getAcceptNumber());
            }
        });
        return testStandings;
    }

    /**
     * 查询测试的提交实时提交情况
     * 输入testId
     * 输出测试的提交实时提交状态
     *
     * @param testId
     */
    public List<TestProgrammingQuestionHistory> checkTestProgrammingRealStatus(int testId) {
        return testProgrammingQuestionHistoryMapper.selectTestProgrammingRealStatus(testId);
    }

    /**
     * 根据测试编程题记录编号来查询对应的测试编程题记录
     * 输入testProgrammingQuestionId
     * 输出TestProgrammingQuestionHistory
     *
     * @param testProgrammingQuestionHistoryId
     */
    public TestProgrammingQuestionHistory checkTestProgrammingHistoryByTestProgrammingQuestionHistoryId(int testProgrammingQuestionHistoryId) {
        return testProgrammingQuestionHistoryMapper.selectTestProgrammingHistoryByTestProgrammingQuestionHistoryId(testProgrammingQuestionHistoryId);
    }

    /**
     * 查询测试的提交实时提交情况通过提交的查询信息
     * 输入testId
     * 输出测试的提交实时提交状态
     *
     * @param testProgrammingQuestionHistory
     */
    public List<TestProgrammingQuestionHistory> checkTestProgrammingRealStatusBySearchInfo(TestProgrammingQuestionHistory testProgrammingQuestionHistory) {
        return testProgrammingQuestionHistoryMapper.selectTestProgrammingRealStatusBySearchInfo(testProgrammingQuestionHistory);
    }
}
