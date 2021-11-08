package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.TestProgrammingQuestionHistoryMapper;
import com.example.ojsystem.entity.TestProgrammingQuestionHistory;
import com.example.ojsystem.entity.TestProgrammingQuestionResultTool;
import com.example.ojsystem.entity.TestProgrammingQuestionUserSubmitStateTool;
import com.example.ojsystem.service.TestProgrammingQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            for(int o = 0; o<testProgrammingQuestionResultTools.get(i).getTestProgrammingQuestionResultStateTools().size(); o++){
                TestProgrammingQuestionUserSubmitStateTool testProgrammingQuestionUserSubmitStateTool=testProgrammingQuestionHistoryMapper.queryTestProgrammingQuestionUserSubmitStateByTestProgrammingQuestionIdAndUserId(testProgrammingQuestionResultTools.get(i).getTestProgrammingQuestionResultStateTools().get(o).getTestProgrammingQuestionId(),testProgrammingQuestionResultTools.get(i).getUserId());
                if(testProgrammingQuestionUserSubmitStateTool.getSuccess()>0){
                    testProgrammingQuestionResultTools.get(i).getTestProgrammingQuestionResultStateTools().get(o).setTestProgrammingQuestionResult("success");
                    continue;
                }else if(testProgrammingQuestionUserSubmitStateTool.getNoSuccess()>0){
                    testProgrammingQuestionResultTools.get(i).getTestProgrammingQuestionResultStateTools().get(o).setTestProgrammingQuestionResult("error");
                    continue;
                }else{
                    testProgrammingQuestionResultTools.get(i).getTestProgrammingQuestionResultStateTools().get(o).setTestProgrammingQuestionResult("null");
                    continue;
                }
            }
        }

        return testProgrammingQuestionResultTools;
    }
}
