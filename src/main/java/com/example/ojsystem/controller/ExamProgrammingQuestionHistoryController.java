package com.example.ojsystem.controller;


import com.alibaba.fastjson.JSON;
import com.example.ojsystem.entity.ExamProgrammingQuestionHistory;
import com.example.ojsystem.entity.ExamQuestion;
import com.example.ojsystem.entity.ExamQuestionHistory;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.ExamProgrammingQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/examProgrammingHistory")
public class ExamProgrammingQuestionHistoryController {
    @Autowired
    ExamProgrammingQuestionHistoryService examProgrammingQuestionHistoryService;
    /**
     * 根据学生id和考试编程信息添加考试编程题记录
     * 输入examProgrammingHistory
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/addExamProgrammingQuestionHistory",method = RequestMethod.POST)
    public Boolean addExamProgrammingQuestionHistory(HttpServletRequest request){
        int i=0;
        int examQuestionId=Integer.valueOf(request.getParameter("examQuestionId"));
        int userId=Integer.valueOf(request.getParameter("userId"));
        int examProgrammingQuestionScore=Integer.valueOf(request.getParameter("examProgrammingQuestionScore"));
        String examProgrammingQuestionCode=request.getParameter("examProgrammingQuestionCode");
        ExamProgrammingQuestionHistory examProgrammingQuestionHistory=new ExamProgrammingQuestionHistory();
        examProgrammingQuestionHistory.setExamProgrammingQuestionCode(examProgrammingQuestionCode);

//        HttpSession session=request.getSession();
//        int userId=(Integer)session.getAttribute("userId");
        i=examProgrammingQuestionHistoryService.addExamProgrammingQuestionHistoryInfo(examProgrammingQuestionScore,examProgrammingQuestionHistory,userId,examQuestionId);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
    @RequestMapping(value = "/queryExamProgrammingQuestionResultHistoryByExamQuestionIdAndUserId",method = RequestMethod.POST)
    public String queryExamProgrammingQuestionResultHistoryByExamQuestionIdAndUserId(HttpServletRequest request) {
        int userId = Integer.valueOf(request.getParameter("userId"));
        int examQuestionId = Integer.valueOf(request.getParameter("examQuestionId"));
        System.out.println(examProgrammingQuestionHistoryService.checkExamProgrammingQuestionResultHistoryByExamQuestionIdAndUserId(examQuestionId, userId));
        return examProgrammingQuestionHistoryService.checkExamProgrammingQuestionResultHistoryByExamQuestionIdAndUserId(examQuestionId, userId);
    }
}
