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
}
