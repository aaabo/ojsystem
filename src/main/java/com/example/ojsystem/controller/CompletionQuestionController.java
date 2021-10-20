package com.example.ojsystem.controller;

import com.example.ojsystem.entity.CompletionQuestion;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.CompletionQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/completionQuestion")
public class CompletionQuestionController {
    @Autowired
    CompletionQuestionService completionQuestionService;

    /**
     * 根据输入的填空题信息添加到填空题题库中
     * 输入completionQuestion
     * 输出int
     */
    @RequestMapping(value="/addCompletionQuestionInfo",method = RequestMethod.POST)
    public Object addCompletionQuestionInfo(HttpServletRequest request){
        User user=new User();
        CompletionQuestion completionQuestion=new CompletionQuestion();
        int userId=Integer.valueOf(request.getParameter("userId"));
        String completionQuestionDifficulty=request.getParameter("completionQuestionDifficulty");
        String completionQuestionDescription=request.getParameter("completionQuestionDescription");
        user.setUserId(userId);
        completionQuestion.setCompletionQuestionDescription(completionQuestionDescription);
        completionQuestion.setCompletionQuestionDifficulty(completionQuestionDifficulty);
        completionQuestion.setIsPrivate(false);
        completionQuestion.setUser(user);
        int i=completionQuestionService.addCompletionQuestionInfo(completionQuestion);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 根据输入的填空题信息修改对应的填空题信息
     * 输入completionQuestion
     * 输出int
     */
    @RequestMapping(value="/modifyCompletionQuestionInfo",method = RequestMethod.POST)
    public Object modifyCompletionQuestionInfo(HttpServletRequest request){
        CompletionQuestion completionQuestion=new CompletionQuestion();
        int completionQuestionId=Integer.valueOf(request.getParameter("completionQuestionId"));
        String completionQuestionDifficulty=request.getParameter("completionQuestionDifficulty");
        String completionQuestionDescription=request.getParameter("completionQuestionDescription");
        completionQuestion.setCompletionQuestionDescription(completionQuestionDescription);
        completionQuestion.setCompletionQuestionDifficulty(completionQuestionDifficulty);
        completionQuestion.setIsPrivate(false);
        completionQuestion.setCompletionQuestionId(completionQuestionId);
        int i=completionQuestionService.modifyCompletionQuestionInfo(completionQuestion);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 根据输入的填空题编号删除对应的填空题信息
     * 输入completionQuestionId
     * 输出int
     */
    @RequestMapping(value="/deleteCompletionQuestionInfoByCompletionQuestionId",method = RequestMethod.POST)
    public Object deleteCompletionQuestionInfoByCompletionQuestionId(HttpServletRequest request){
        int i=completionQuestionService.deleteCompletionQuestionInfoByCompletionQuestionId(Integer.valueOf(request.getParameter("completionQuestionId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 根据用户来查询填空题信息
     * 输入userId
     * 输出int
     */
    @RequestMapping(value="/queryCompletionQuestionInfoByUserId",method = RequestMethod.POST)
    public Object queryCompletionQuestionInfoByUserId(HttpServletRequest request){
        HttpSession session=request.getSession();
        return completionQuestionService.queryCompletionQuestionInfoByUserId((Integer)session.getAttribute("userId"));
    }
}
