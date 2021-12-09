package com.example.ojsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ojsystem.entity.*;
import com.example.ojsystem.service.CompletionQuestionService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        String completionQuestionInfo=request.getParameter("completionQuestionInfo");
        CompletionQuestion completionQuestion=JSON.parseObject(completionQuestionInfo,CompletionQuestion.class);
        int i=completionQuestionService.saveCompletionQuestionInfo(completionQuestion);
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
        String completionQuestionInfo=request.getParameter("completionQuestionInfo");
        CompletionQuestion completionQuestion=JSON.parseObject(completionQuestionInfo,CompletionQuestion.class);
        int i=completionQuestionService.alterCompletionQuestionInfo(completionQuestion);
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
    public Object removeCompletionQuestionInfoByCompletionQuestionId(HttpServletRequest request){
        int i=completionQuestionService.cancelCompletionQuestionInfoByCompletionQuestionId(Integer.valueOf(request.getParameter("completionQuestionId")));
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
        return completionQuestionService.checkCompletionQuestionInfoByUserId((Integer)session.getAttribute("userId"));
    }

    /**
     * 根据查询信息来查询填空题信息
     * 输入completionQuestion
     * 输出List<CompletionQuestion>
     */
    @RequestMapping(value="/queryCompletionQuestionInfoBySearchInfo",method = RequestMethod.POST)
    public Object queryCompletionQuestionInfoBySearchInfo(HttpServletRequest request){
        List<CompletionQuestion> completionQuestions=new ArrayList<CompletionQuestion>();
        List<CompletionQuestion> completionQuestions2=new ArrayList<CompletionQuestion>();
        HttpSession session=request.getSession();
        int currentUserId=(Integer)session.getAttribute("userId");
        int userId=Integer.valueOf(request.getParameter("userId"));
        String chapter=request.getParameter("chapter");
        String firstKnowledge=request.getParameter("firstKnowledge");
        int questionLabelId=Integer.valueOf(request.getParameter("questionLabelId"));
        List<QuestionLabel> questionLabels=new ArrayList<QuestionLabel>();
        User user=new User();
        CompletionQuestion completionQuestion=new CompletionQuestion();
        QuestionLabel questionLabel=new QuestionLabel();
        if(userId!=0){
            user.setUserId(userId);
        }else{
            user.setUserId(0);
        }
        if(!chapter.equals("")){
            questionLabel.setChapter(chapter);
        }
        if(!firstKnowledge.equals("")){
            questionLabel.setFirstKnowledgePoint(firstKnowledge);
        }
        if(questionLabelId!=0){
            questionLabel.setQuestionLabelId(questionLabelId);
        }
        completionQuestion.setUser(user);
        questionLabels.add(questionLabel);
        completionQuestion.setQuestionLabels(questionLabels);
        completionQuestions=completionQuestionService.checkCompletionQuestionBySearchInfo(completionQuestion,currentUserId);
//        for(int i=0;i<completionQuestions1.size();i++){
//            CompletionQuestion completionQuestion1=new CompletionQuestion();
//            completionQuestion1=completionQuestionService.queryCompletionQuestionIdByCompletionQuestionId(completionQuestions1.get(i).getCompletionQuestionId());
//            completionQuestions2.add(completionQuestion1);
//        }
        return completionQuestions;
    }

    /**
     * 根据输入的考试编号查询考试填空题信息
     * 输入examId
     * 输出List<CompletionQuestion>
     */
    @RequestMapping(value="/queryCompletionQuestionInfoByExamId",method = RequestMethod.POST)
    public Object queryCompletionQuestionInfoByExamId(HttpServletRequest request){
        return completionQuestionService.checkCompletionQuestionInfoByExamId(Integer.valueOf(request.getParameter("examId")));
    }

}
