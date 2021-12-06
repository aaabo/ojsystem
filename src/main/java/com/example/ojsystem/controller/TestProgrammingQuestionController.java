package com.example.ojsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
        i= testProgrammingQuestionService.saveTestProgrammingQuestionInfo(testProgrammingQuestion);
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
        JSONArray jsonArray=JSONArray.parseArray(testProgrammingQuestions);//把前台接收的string数组转化为json数组        System.out.println("数据:"+testProgrammingQuestions2);
        for(int o=0;o<jsonArray.size();o++){
            JSONObject jsonObject=(JSONObject)jsonArray.get(o);
            TestProgrammingQuestion testProgrammingQuestion1=new TestProgrammingQuestion();
            Exercise exercise=new Exercise();
            Test test=new Test();
            exercise.setExerciseId((Integer)jsonObject.get("exerciseId"));
            test.setTestId((Integer)jsonObject.get("testId"));
            testProgrammingQuestion1.setExercise(exercise);
            testProgrammingQuestion1.setTest(test);
            i= testProgrammingQuestionService.saveTestProgrammingQuestionInfo(testProgrammingQuestion1);
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
    public Object removeTestProgrammingQuestionByTestProgrammingQuestionId(HttpServletRequest request){
        int i=0;
        i= testProgrammingQuestionService.cancelTestProgrammingQuestionByTestProgrammingQuestionId(Integer.valueOf(request.getParameter("testProgrammingQuestionId")));
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
        return testProgrammingQuestionService.checkTestProgrammingQuestionAndIsSuccess(Integer.valueOf(request.getParameter("testId")),(Integer)request.getSession().getAttribute("userId"));
    }

    /**
     * 查询对应测试的全部习题  测试详情使用（exerciseId 为testProgrammingId exerciseCorrectTimes，exerciseSubmitTimes为正确率）
     * 输入testId
     * 输出List<Exercise>
     */
    @RequestMapping(value="/queryTestProgrammingQuestionByTestId",method = RequestMethod.POST)
    public Object queryTestProgrammingQuestionByTestId(HttpServletRequest request){
        return testProgrammingQuestionService.checkTestProgrammingQuestionByTestId(Integer.valueOf(request.getParameter("testId")));
    }

    /**
     * 查询对应测试的全部测试编程题
     * 输入testId
     * 输出List<TestProgrammingQuestion>
     */
    @RequestMapping(value="/queryTestProgrammingQuestionInfoByTestId",method = RequestMethod.POST)
    public Object queryTestProgrammingQuestionInfoByTestId(HttpServletRequest request){
        return testProgrammingQuestionService.checkTestProgrammingQuestionInfoByTestId(Integer.valueOf(request.getParameter("testId")));
    }
    /**
     * 根据测试编程题编号查询对应的习题信息
     * 输入testProgrammingQuestionId
     * 输出List<Exercise>
     */
    @RequestMapping(value="/queryExerciseByTestProgrammingQuestionId",method = RequestMethod.POST)
    public Object queryExerciseByTestProgrammingQuestionId(HttpServletRequest request){
        return testProgrammingQuestionService.checkExerciseByTestProgrammingQuestionId(Integer.valueOf(request.getParameter("testProgrammingQuestionId")));
    }

    /**
     * 根据测试编程题编号查询testId
     * 输入testProgrammingQuestionId
     * 输出Integer
     */
    @RequestMapping(value="/queryTestIdByTestProgrammingQuestionId",method = RequestMethod.POST)
    public Object queryTestIdByTestProgrammingQuestionId(HttpServletRequest request){
        return testProgrammingQuestionService.checkTestIdByTestProgrammingQuestionId(Integer.valueOf(request.getParameter("testProgrammingQuestionId")));
    }
}
