package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Exercise;
import com.example.ojsystem.entity.TestProgrammingQuestion;
import com.example.ojsystem.entity.TestProgrammingQuestionHistory;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.TestProgrammingQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
        i=testProgrammingQuestionHistoryService.addTestProgrammingQuestionHistoryInfo(testProgrammingQuestionHistory);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 查询测试的提交状态
     * 输入testId
     * 输出测试的状态
     */
    @RequestMapping(value="/queryTestRealStatus",method = RequestMethod.POST)
    public Object queryTestRealStatus(HttpServletRequest request){
        return testProgrammingQuestionHistoryService.queryTestRealStatus(Integer.valueOf(request.getParameter("testId")));
    }
}
