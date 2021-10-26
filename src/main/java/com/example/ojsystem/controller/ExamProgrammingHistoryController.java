package com.example.ojsystem.controller;


import com.example.ojsystem.entity.ExamProgrammingQuestionHistory;
import com.example.ojsystem.entity.ExamQuestion;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.ExamProgrammingQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/examProgrammingHistory")
public class ExamProgrammingHistoryController {

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
        int userId=Integer.valueOf(request.getParameter("userId"));
        int examQuestionId=Integer.valueOf(request.getParameter("examQuestionId"));
        String examProgrammingCode=request.getParameter("examProgrammingCode");
        ExamProgrammingQuestionHistory examProgrammingQuestionHistory=new ExamProgrammingQuestionHistory();
        User user=new User();
        user.setUserId(userId);
        ExamQuestion examQuestion=new ExamQuestion();
//        examQuestion.setQuestionId(examQuestionId);
        examProgrammingQuestionHistory.setUser(user);
//        examProgrammingQuestionHistory.setExamQuestion(examQuestion);
        examProgrammingQuestionHistory.setExamProgrammingQuestionCode(examProgrammingCode);
        i=examProgrammingQuestionHistoryService.addExamProgrammingQuestionHistory(examProgrammingQuestionHistory);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
