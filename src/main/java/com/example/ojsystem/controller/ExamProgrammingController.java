package com.example.ojsystem.controller;

import com.example.ojsystem.dao.ExamProgrammingMapper;
import com.example.ojsystem.entity.Classes;
import com.example.ojsystem.entity.Exam;
import com.example.ojsystem.entity.ExamProgramming;
import com.example.ojsystem.service.ExamProgrammingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/examProgramming")
public class ExamProgrammingController {

    @Autowired
    ExamProgrammingService examProgrammingService;
    /**
     * 根据考试编程题信息添加考试编程题
     * 输入ExamProgramming
     * 输出int 成功返回添加的id 失败返回0
     */
    @RequestMapping(value="/addProgramExamInfo",method = RequestMethod.POST)
    public int addProgramExamInfo(HttpServletRequest request){
        int i=0;
        int examId=Integer.valueOf(request.getParameter("examId"));
        String examProgrammingTitle=request.getParameter("examProgrammingTitle");
        String examProgrammingDescription=request.getParameter("examProgrammingDescription");
        String examProgrammingInput=request.getParameter("examProgrammingInput");
        String examProgrammingOutput=request.getParameter("examProgrammingOutput");
        String examProgrammingSampleInput=request.getParameter("examProgrammingSampleInput");
        String examProgrammingSampleOutput=request.getParameter("examProgrammingSampleOutput");
        int examProgrammingScore=Integer.valueOf(request.getParameter("examProgrammingScore"));
        Exam exam=new Exam();
        exam.setExamId(examId);
        ExamProgramming examProgramming=new ExamProgramming();
        examProgramming.setExamProgrammingTitle(examProgrammingTitle);
        examProgramming.setExamProgrammingDescription(examProgrammingDescription);
        examProgramming.setExamProgrammingInput(examProgrammingInput);
        examProgramming.setExamProgrammingOutput(examProgrammingOutput);
        examProgramming.setExamProgrammingSampleInput(examProgrammingSampleInput);
        examProgramming.setExamProgrammingSampleOutput(examProgrammingSampleOutput);
        examProgramming.setExamProgrammingScore(examProgrammingScore);
        examProgramming.setExam(exam);
        i=examProgrammingService.addProgramExamInfo(examProgramming);
        if(i!=0){
            return examProgramming.getExamProgrammingId();
        }
        else{
            return 0;
        }
    }

    /**
     * 根据考试编程题信息修改考试编程题
     * 输入ExamProgramming
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/modifyProgramExamInfo",method = RequestMethod.POST)
    public Boolean modifyProgramExamInfo(HttpServletRequest request){
        int i=0;
        int examProgrammingId=Integer.valueOf(request.getParameter("examProgrammingId"));
        String examProgrammingTitle=request.getParameter("examProgrammingTitle");
        String examProgrammingDescription=request.getParameter("examProgrammingDescription");
        String examProgrammingInput=request.getParameter("examProgrammingInput");
        String examProgrammingOutput=request.getParameter("examProgrammingOutput");
        String examProgrammingSampleInput=request.getParameter("examProgrammingSampleInput");
        String examProgrammingSampleOutput=request.getParameter("examProgrammingSampleOutput");
        int examProgrammingScore=Integer.valueOf(request.getParameter("examProgrammingScore"));
        ExamProgramming examProgramming=new ExamProgramming();
        examProgramming.setExamProgrammingTitle(examProgrammingTitle);
        examProgramming.setExamProgrammingDescription(examProgrammingDescription);
        examProgramming.setExamProgrammingInput(examProgrammingInput);
        examProgramming.setExamProgrammingOutput(examProgrammingOutput);
        examProgramming.setExamProgrammingSampleInput(examProgrammingSampleInput);
        examProgramming.setExamProgrammingSampleOutput(examProgrammingSampleOutput);
        examProgramming.setExamProgrammingScore(examProgrammingScore);
        examProgramming.setExamProgrammingId(examProgrammingId);
        i=examProgrammingService.modifyProgramExamInfo(examProgramming);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据考试id查询全部考试编程题
     * 输入examId
     * 输出int
     */

    @RequestMapping(value="/queryProgrammingInfoById",method = RequestMethod.POST)
    public Object queryProgrammingInfoById(HttpServletRequest request){
        return examProgrammingService.queryProgrammingInfoById(Integer.valueOf(request.getParameter("examId")));
    }


    /**
     * 根据考试编程题id删除考试编程题
     * 输入examProgrammingId
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/deleteProgramExamInfo",method = RequestMethod.POST)
    public Boolean deleteProgramExamInfo(HttpServletRequest request){
        int i=0;
        i=examProgrammingService.deleteProgramExamInfo(Integer.valueOf(request.getParameter("examProgrammingId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据考试id查询考试编程题总分
     * 输入examId
     * 输出int
     */
    @RequestMapping(value="/queryProgramExamTotalScoreInfo",method = RequestMethod.POST)
    public Object queryProgramExamTotalScoreInfo(HttpServletRequest request){
        return examProgrammingService.queryProgramExamTotalScoreInfo(Integer.valueOf(request.getParameter("examId")));
    }

}
