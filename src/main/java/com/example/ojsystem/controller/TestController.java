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
     * 输出成功输出true 失败输出false
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
        i= testService.saveTestInfo(test);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 根据输入的测试信息来修改测试
     * 输入test
     * 输出成功输出true 失败输出false
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
        i= testService.alterTestInfo(test);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 根据输入的测试id来删除对应的测试
     * 输入testId
     * 输出成功输出true 失败输出false
     */
    @RequestMapping(value="/deleteTestInfoByTestId",method = RequestMethod.POST)
    public Object removeTestInfoByTestId(HttpServletRequest request){
        int i=0;
        i= testService.cancelTestInfoByTestId(Integer.valueOf(request.getParameter("testId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 查询（应该用不到了）
     * 输入null
     * 输出List<Test>
     */
    @RequestMapping(value="/queryTestInfoByTestStatus",method = RequestMethod.POST)
    public Object queryTestInfoByTestStatus(HttpServletRequest request){
        return testService.checkTestInfoByTestStatus();
    }

    /**
     * 根据testId和输入的testStatus修改测试状态
     * 输入testId,testStatus
     * 输出成功输出true 失败输出false
     */
    @RequestMapping(value="/modifyTestStatusByTestId",method = RequestMethod.POST)
    public Object modifyTestStatusByTestId(HttpServletRequest request){
        int i=0;
        Test test=new Test();
        test.setTestId(Integer.valueOf(request.getParameter("testId")));
        test.setTestStatus(request.getParameter("testStatus"));
        i=testService.alterTestStatusByTestId(test);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 根据测试名称,测试状态，创建人来查询测试信息
     * 输入test
     * 输出List<Test>
     *
     */
    @RequestMapping(value="/searchTestInfo",method = RequestMethod.POST)
    public Object querySearchTestInfo(HttpServletRequest request){
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
        return testService.checkSearchTestInfo(test);
    }


    /**
     * 查询为结束的测试
     * 输入null
     * 输出List<Test>
     */
    @RequestMapping(value="/queryNotFinishTestInfo",method = RequestMethod.POST)
    public Object queryNotFinishTestInfo(HttpServletRequest request){
        return testService.checkNotFinishTestInfo();
    }

    /**
     * 根据testId来查询对应的测试信息
     * 输入testId
     * 输出Test
     */
    @RequestMapping(value="/queryTestInfoByTestId",method = RequestMethod.POST)
    public Object queryTestInfoByTestId(HttpServletRequest request){
        return testService.checkTestInfoByTestId(Integer.valueOf(request.getParameter("testId")));
    }

}
