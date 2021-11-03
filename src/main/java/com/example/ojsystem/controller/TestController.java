package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Group;
import com.example.ojsystem.entity.Test;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;
    /**
     * 根据输入的测试信息来添加测试
     * 输入test
     * 输出int
     */
    @RequestMapping(value="/addTestInfo",method = RequestMethod.POST)
    public Object addTestInfo(HttpServletRequest request){
        int i=0;
        Test test=new Test();
        test.setTestName(request.getParameter("testName"));
        test.setTestStartTime(request.getParameter("testStartTime"));
        test.setTestEndTime(request.getParameter("testEndTime"));
        test.setTestLanguage(request.getParameter("testLanguage"));
        test.setTestStatus(request.getParameter("testStatus"));
        Group  group=new Group();
        group.setGroupId(Integer.valueOf(request.getParameter("groupId")));
        test.setGroup(group);
        User user=new User();
        user.setUserId((Integer) request.getSession().getAttribute("userId"));
        test.setUser(user);
        i= testService.addTestInfo(test);
        return i;
    }

    /**
     * 根据输入的测试信息来修改测试
     * 输入test
     * 输出int
     */
    @RequestMapping(value="/modifyTestInfo",method = RequestMethod.POST)
    public Object modifyTestInfo(HttpServletRequest request){
        int i=0;
        Test test=new Test();
        test.setTestId(Integer.valueOf(request.getParameter("testId")));
        test.setTestName(request.getParameter("testName"));
        test.setTestStartTime(request.getParameter("testStartTime"));
        test.setTestEndTime(request.getParameter("testEndTime"));
        test.setTestLanguage(request.getParameter("testLanguage"));
        test.setTestStatus(request.getParameter("testStatus"));
        Group  group=new Group();
        group.setGroupId(Integer.valueOf(request.getParameter("groupId")));
        test.setGroup(group);
        i= testService.modifyTestInfo(test);
        return i;
    }

    /**
     * 根据输入的测试id来删除对应的测试
     * 输入testId
     * 输出int
     */
    @RequestMapping(value="/deleteTestInfoByTestId",method = RequestMethod.POST)
    public Object deleteTestInfoByTestId(HttpServletRequest request){
        int i=0;
        i= testService.deleteTestInfoByTestId(Integer.valueOf(request.getParameter("testId")));
        return i;
    }

    /**
     * 根据输入的测试id来删除对应的测试
     * 输入null
     * 输出List<Test>
     */
    @RequestMapping(value="/queryTestInfoByTestStatus",method = RequestMethod.POST)
    public Object queryTestInfoByTestStatus(HttpServletRequest request){
        return testService.queryTestInfoByTestStatus();
    }

    /**
     * 根据testId和输入的testStatus修改测试状态
     * 输入testId,testStatus
     * 输出int
     */
    @RequestMapping(value="/modifyTestStatusByTestId",method = RequestMethod.POST)
    public Object modifyTestStatusByTestId(HttpServletRequest request){
        Test test=new Test();
        test.setTestId(Integer.valueOf(request.getParameter("testId")));
        test.setTestStatus(request.getParameter("testStatus"));
        return testService.modifyTestStatusByTestId(test);
    }

    /**
     * 根据测试名称,测试状态，创建人来查询测试信息
     * 输入test
     * 输出List<Test>
     *
     */
    @RequestMapping(value="/searchTestInfo",method = RequestMethod.POST)
    public Object searchTestInfo(HttpServletRequest request){
        Test test=new Test();
        String testName=request.getParameter("testName");
        String testStatus=request.getParameter("testStatus");
        String userName=request.getParameter("userName");
        if(testName.equals("")){
            test.setTestName(testName);
        }else{
            test.setTestName("%"+testName+"%");
        }
        test.setTestStatus(testStatus);
        User user=new User();
        if(userName.equals("")){
            user.setUserName(userName);
        }else{
            user.setUserName("%"+userName+"%");
        }
        test.setUser(user);
        return testService.modifyTestStatusByTestId(test);
    }
}
