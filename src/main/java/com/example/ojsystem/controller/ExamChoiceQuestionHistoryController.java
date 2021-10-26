package com.example.ojsystem.controller;

import com.example.ojsystem.entity.ExamChoiceQuestionHistory;
import com.example.ojsystem.entity.ExamQuestion;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.ExamChoiceQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/examChoiceQuestionHistory")
public class ExamChoiceQuestionHistoryController {
    @Autowired
    ExamChoiceQuestionHistoryService examChoiceQuestionHistoryService;
    /**
     * 根据用户id 选择题id 用户选项添加用户选择题记录
     * 输入ExamChoiceQuestionHistory
     * 输出 成功返回true 失败返回false
     */
    @RequestMapping(value="/addExamChoiceQuestionHistory",method = RequestMethod.POST)
    public Boolean addExamChoiceQuestionHistory(HttpServletRequest request){
        int i=0;
        int userId=Integer.valueOf(request.getParameter("userId"));
        int examChoiceQuestionId=Integer.valueOf(request.getParameter("examChoiceQuestionId"));
        String examChoiceQuestionUserSelection=request.getParameter("examChoiceQuestionUserSelection");
        User user=new User();
        user.setUserId(userId);
//        ExamQuestion examQuestion=new ExamQuestion();
//        examQuestion.setQuestionId(examChoiceQuestionId);
        ExamChoiceQuestionHistory examChoiceQuestionHistory=new ExamChoiceQuestionHistory();
        examChoiceQuestionHistory.setExamChoiceQuestionUserSelection(examChoiceQuestionUserSelection);
        examChoiceQuestionHistory.setUser(user);
//        examChoiceQuestionHistory.setExamQuestion(examQuestion);
        i=examChoiceQuestionHistoryService.addExamChoiceQuestionHistory(examChoiceQuestionHistory);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
