package com.example.ojsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.ojsystem.entity.ExamCompletionQuestionAnswerHistory;
import com.example.ojsystem.entity.ExamCompletionQuestionHistory;
import com.example.ojsystem.entity.ExamQuestionHistory;
import com.example.ojsystem.service.ExamCompletionQuestionHistoryService;
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
@RequestMapping("/examCompletionQuestionHistory")
public class ExamCompletionQuestionHistoryController {
    @Autowired
    ExamCompletionQuestionHistoryService examCompletionQuestionHistoryService;

    /**
     * 根据用户提交的填空题信息添加填空题记录
     * 输入userId,examQuestionId
     * 输出int
     */
    @RequestMapping(value="/addExamCompletionQuestionHistoryInfo",method = RequestMethod.POST)
    public Object addExamCompletionQuestionHistoryInfo(HttpServletRequest request){
        List<ExamQuestionHistory> examQuestionHistories=new ArrayList<ExamQuestionHistory>();
        String addExamQuestionHistories = request.getParameter("addExamQuestionHistories");
        examQuestionHistories= JSON.parseArray(addExamQuestionHistories,ExamQuestionHistory.class);//把前台接收的string数组转化为json数组
        HttpSession session=request.getSession();
        int userId=(Integer)session.getAttribute("userId");
        int i=0;
        i=examCompletionQuestionHistoryService.addExamCompletionQuestionHistoryInfo(examQuestionHistories,userId);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
