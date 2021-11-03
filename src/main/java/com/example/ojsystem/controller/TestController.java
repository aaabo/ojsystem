package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Group;
import com.example.ojsystem.entity.Test;
import com.example.ojsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
        Group  group=new Group();
        group.setGroupId(Integer.valueOf(request.getParameter("groupId")));
        test.setGroup(group);
        i= testService.addTestInfo(test);
        return i;
    }
}
