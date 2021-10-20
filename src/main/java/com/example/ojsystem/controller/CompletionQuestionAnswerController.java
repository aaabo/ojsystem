package com.example.ojsystem.controller;

import com.example.ojsystem.entity.CompletionQuestion;
import com.example.ojsystem.entity.CompletionQuestionAnswer;
import com.example.ojsystem.service.CompletionQuestionAnswerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/completionQuestionAnswer")
public class CompletionQuestionAnswerController {
    @Autowired
    CompletionQuestionAnswerService completionQuestionAnswerService;

    /**
     * 根据输入的填空题答案信息添加填空题答案
     * 输入completionQuestionAnswer,completionQuestionId
     * 输出成功输入true 失败输出false
     */
    @RequestMapping(value="/addCompletionQuestionAnswerInfo",method = RequestMethod.POST)
    public Object addCompletionQuestionAnswerInfo(HttpServletRequest request){
        int i=0;
        int completionQuestionId=Integer.valueOf(request.getParameter("completionQuestionId"));
        String completionQuestionAnswer=request.getParameter("completionQuestionAnswer");
        int completionQuestionAnswerNumber=Integer.valueOf(request.getParameter("completionQuestionAnswerNumber"));
        CompletionQuestionAnswer completionQuestionAnswer1=new CompletionQuestionAnswer();
        completionQuestionAnswer1.setCompletionQuestionAnswer(completionQuestionAnswer);
        completionQuestionAnswer1.setCompletionQuestionAnswerNumber(completionQuestionAnswerNumber);
        i=completionQuestionAnswerService.addCompletionQuestionAnswerInfo(completionQuestionAnswer1,completionQuestionId);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 根据填空题编号删除对应的填空题答案信息
     * 输入completionQuestionId
     * 输出int
     */
    @RequestMapping(value="/deleteCompletionQuestionAnswerInfoByCompletionQuestionId",method = RequestMethod.POST)
    public Object deleteCompletionQuestionAnswerInfoByCompletionQuestionId(HttpServletRequest request){
        int i=0;
        int completionQuestionId=Integer.valueOf(request.getParameter("completionQuestionId"));
        i=completionQuestionAnswerService.deleteCompletionQuestionAnswerInfoByCompletionQuestionId(completionQuestionId);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

}
