package com.example.ojsystem.controller;

import com.example.ojsystem.entity.*;
import com.example.ojsystem.service.TestProgrammingQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/testProgrammingHistory")
public class TestProgrammingQuestionHistoryController {
    @Autowired
    TestProgrammingQuestionHistoryService testProgrammingQuestionHistoryService;
    /**
     * 将提交的测试习题记录保存到后台
     * 输入testProgrammingQuestionHistory
     * 输出成功输出true 失败输出false
     */
    @RequestMapping(value="/addTestProgrammingQuestionHistoryInfo",method = RequestMethod.POST)
    public Object addTestProgrammingQuestionHistoryInfo(HttpServletRequest request){
        int i=0;
        TestProgrammingQuestion testProgrammingQuestion=new TestProgrammingQuestion();
        testProgrammingQuestion.setTestProgrammingQuestionId(Integer.valueOf(request.getParameter("testProgrammingQuestionId")));
        TestProgrammingQuestionHistory testProgrammingQuestionHistory=new TestProgrammingQuestionHistory();
        testProgrammingQuestionHistory.setTestProgrammingQuestion(testProgrammingQuestion);
        testProgrammingQuestionHistory.setTestProgrammingSubmitTime(request.getParameter("testProgrammingSubmitTime"));
        testProgrammingQuestionHistory.setTestProgrammingCode(request.getParameter("testProgrammingCode"));
        User user=new User();
        user.setUserId((Integer)request.getSession().getAttribute("userId"));
        testProgrammingQuestionHistory.setUser(user);
        i=testProgrammingQuestionHistoryService.saveTestProgrammingQuestionHistoryInfo(testProgrammingQuestionHistory);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 查询测试的提交状态  testStanding使用
     * 输入testId
     * 输出测试的状态
     */
    @RequestMapping(value="/queryTestRealStatus",method = RequestMethod.POST)
    public Object queryTestStanding(HttpServletRequest request){
        return testProgrammingQuestionHistoryService.checkTestStanding(Integer.valueOf(request.getParameter("testId")));
    }


    /**
     * 查询测试的提交实时提交情况
     * 输入testId
     * 输出测试的提交实时提交状态
     */
    @RequestMapping(value="/queryTestProgrammingRealStatus",method = RequestMethod.POST)
    public Object queryTestProgrammingRealStatus(HttpServletRequest request){
        return testProgrammingQuestionHistoryService.checkTestProgrammingRealStatus(Integer.valueOf(request.getParameter("testId")));
    }

    /**
     * 根据测试编程题记录编号来查询对应的测试编程题记录
     * 输入testProgrammingQuestionId
     * 输出TestProgrammingQuestionHistory
     */
    @RequestMapping(value="/queryTestProgrammingHistoryByTestProgrammingQuestionHistoryId",method = RequestMethod.POST)
    public Object queryTestProgrammingHistoryByTestProgrammingQuestionHistoryId(HttpServletRequest request){
        return testProgrammingQuestionHistoryService.checkTestProgrammingHistoryByTestProgrammingQuestionHistoryId(Integer.valueOf(request.getParameter("testProgrammingQuestionHistoryId")));
    }


    /**
     * 根据习题id或者用户id来查询习题记录 新增通过语言和结果查询
     * 输入exerciseId和userId
     * 输出List<ExerciseHistory>
     */
    @RequestMapping(value="/queryTestProgrammingRealStatusBySearchInfo",method = RequestMethod.POST)
    public Object queryExerciseRealTimeStatusInfo(HttpServletRequest request){
        Integer testProgrammingQuestionId=Integer.valueOf(request.getParameter("testProgrammingQuestionId"));
        String userName=request.getParameter("userName");
        String testProgrammingResult=request.getParameter("testProgrammingResult");
        TestProgrammingQuestionHistory testProgrammingQuestionHistory=new TestProgrammingQuestionHistory();
        User user=new User();
        TestProgrammingQuestion testProgrammingQuestion=new TestProgrammingQuestion();
        testProgrammingQuestion.setTestProgrammingQuestionId(testProgrammingQuestionId);
        Test test=new Test();
        test.setTestId(Integer.valueOf(request.getParameter("testId")));
        testProgrammingQuestion.setTest(test);
        if(userName!=null){
            user.setUserName("%"+userName+"%");
        }else{
            user.setUserName(userName);
        }
        testProgrammingQuestionHistory.setUser(user);
        testProgrammingQuestionHistory.setTestProgrammingResult(testProgrammingResult);
        testProgrammingQuestionHistory.setTestProgrammingQuestion(testProgrammingQuestion);
        return testProgrammingQuestionHistoryService.checkTestProgrammingRealStatusBySearchInfo(testProgrammingQuestionHistory);

    }
}
