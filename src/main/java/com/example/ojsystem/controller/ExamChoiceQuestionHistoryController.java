package com.example.ojsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ojsystem.entity.ExamChoiceQuestionHistory;
import com.example.ojsystem.entity.ExamQuestion;
import com.example.ojsystem.entity.ExamQuestionHistory;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.ExamChoiceQuestionHistoryService;
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
    @RequestMapping("/examChoiceQuestionHistory")
public class ExamChoiceQuestionHistoryController {
    @Autowired
    ExamChoiceQuestionHistoryService examChoiceQuestionHistoryService;
    /**
     * 根据用户id 考试题目id 用户选项添加用户选择题记录
     * 输入ExamChoiceQuestionHistory
     * 输出 成功返回true 失败返回false
     */
    @RequestMapping(value="/addExamChoiceQuestionHistory",method = RequestMethod.POST)
    public Boolean addExamChoiceQuestionHistory(HttpServletRequest request){
        int i=0;
        List<ExamQuestionHistory> examQuestionHistories=new ArrayList<ExamQuestionHistory>();
        String addExamQuestionHistories = request.getParameter("addExamQuestionHistories");
        examQuestionHistories= JSON.parseArray(addExamQuestionHistories,ExamQuestionHistory.class);//把前台接收的string数组转化为json数组
        HttpSession session=request.getSession();
        int userId=(Integer)session.getAttribute("userId");
        examChoiceQuestionHistoryService.addExamChoiceQuestionHistoryInfo(examQuestionHistories,userId);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
