package com.example.ojsystem.controller;

import com.alibaba.fastjson.JSON;
import com.example.ojsystem.entity.*;
import com.example.ojsystem.service.TestProgrammingQuestionService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/testProgramming")
public class TestProgrammingQuestionController {
    @Autowired
    TestProgrammingQuestionService testProgrammingQuestionService;
    /**
     * 将习题信息添加到测试习题信息中
     * 输入testProgrammingQuestion
     * 输出成功输出true 失败输出false
     */
    @RequestMapping(value="/addTestProgrammingQuestionInfo",method = RequestMethod.POST)
    public Object addTestProgrammingQuestionInfo(HttpServletRequest request){
        int i=0;
        TestProgrammingQuestion testProgrammingQuestion=new TestProgrammingQuestion();
        Test test=new Test();
        test.setTestId(Integer.valueOf(request.getParameter("testId")));
        Exercise exercise=new Exercise();
        exercise.setExerciseId(Integer.valueOf(request.getParameter("exerciseId")));
        testProgrammingQuestion.setTest(test);
        testProgrammingQuestion.setExercise(exercise);
        i= testProgrammingQuestionService.addTestProgrammingQuestionInfo(testProgrammingQuestion);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 批量添加习题信息添加到测试习题信息中
     * 输入testProgrammingQuestions
     * 输出成功输出true 失败输出false
     */
    @RequestMapping(value="/addTestProgrammingQuestionInfos",method = RequestMethod.POST)
    public Object addTestProgrammingQuestionInfos(HttpServletRequest request){
        int i=0;
        TestProgrammingQuestion testProgrammingQuestion=new TestProgrammingQuestion();
        String testProgrammingQuestions=request.getParameter("testProgrammingQuestions");
        List<TestProgrammingQuestion> testProgrammingQuestions2= JSON.parseArray(testProgrammingQuestions,TestProgrammingQuestion.class);
        for(int o=0;o<testProgrammingQuestions2.size();o++){
            i= testProgrammingQuestionService.addTestProgrammingQuestionInfo(testProgrammingQuestions2.get(o));
        }

        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 从测试习题信息中删除对应的习题信息
     * 输入testProgrammingQuestionId
     * 输出int
     */
    @RequestMapping(value="/deleteTestProgrammingQuestionByTestProgrammingQuestionId",method = RequestMethod.POST)
    public Object deleteTestProgrammingQuestionByTestProgrammingQuestionId(HttpServletRequest request){
        int i=0;
        i= testProgrammingQuestionService.deleteTestProgrammingQuestionByTestProgrammingQuestionId(Integer.valueOf(request.getParameter("testProgrammingQuestionId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 查询用户的测试习题是否正确并输出全部测试习题
     * 输入testId,userId
     * 输出List<Exercise>
     */
    @RequestMapping(value="/queryTestProgrammingQuestionAndIsSuccess",method = RequestMethod.POST)
    public Object queryTestProgrammingQuestionAndIsSuccess(HttpServletRequest request){
        return testProgrammingQuestionService.queryTestProgrammingQuestionAndIsSuccess(Integer.valueOf(request.getParameter("testId")),(Integer)request.getSession().getAttribute("userId"));
    }

    /**
     * 查询对应测试的全部习题
     * 输入testId
     * 输出List<Exercise>
     */
    @RequestMapping(value="/queryTestProgrammingQuestionByTestId",method = RequestMethod.POST)
    public Object queryTestProgrammingQuestionByTestId(HttpServletRequest request){
        return testProgrammingQuestionService.queryTestProgrammingQuestionByTestId(Integer.valueOf(request.getParameter("testId")));
    }

    /**
     * 根据测试编程题编号查询对应的习题信息
     * 输入testProgrammingQuestionId
     * 输出List<Exercise>
     */
    @RequestMapping(value="/queryExerciseByTestProgrammingQuestionId",method = RequestMethod.POST)
    public Object queryExerciseByTestProgrammingQuestionId(HttpServletRequest request){
        return testProgrammingQuestionService.queryExerciseByTestProgrammingQuestionId(Integer.valueOf(request.getParameter("testProgrammingQuestionId")));
    }

    /**
     * 根据测试编程题编号查询testId
     * 输入testProgrammingQuestionId
     * 输出Integer
     */
    @RequestMapping(value="/queryTestIdByTestProgrammingQuestionId",method = RequestMethod.POST)
    public Object queryTestIdByTestProgrammingQuestionId(HttpServletRequest request){
        return testProgrammingQuestionService.queryTestIdByTestProgrammingQuestionId(Integer.valueOf(request.getParameter("testProgrammingQuestionId")));
    }
}
