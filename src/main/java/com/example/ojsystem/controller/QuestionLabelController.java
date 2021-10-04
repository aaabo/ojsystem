package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Group;
import com.example.ojsystem.entity.QuestionLabel;
import com.example.ojsystem.service.QuestionLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/questionLabel")
public class QuestionLabelController {
    @Autowired
    QuestionLabelService questionLabelService;
    /**
     * 获取问题标签信息并添加
     * 输入questionLabel
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/addQuestionLabelInfo",method = RequestMethod.POST)
    public Object addQuestionLabelInfo(HttpServletRequest request){
        int i=0;
        QuestionLabel questionLabel=new QuestionLabel();
        questionLabel.setChapter(request.getParameter("chapter"));
        questionLabel.setFirstKnowledgePoint(request.getParameter("firstKnowledgePoint"));
        questionLabel.setSecondKnowledgePoint(request.getParameter("secondKnowledgePoint"));
        i=questionLabelService.addQuestionLabelInfo(questionLabel);
        if(i>0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 获取全部的问题标签信息
     * 输入无
     * 成功输出List<QuestionLabel>
     */
    @RequestMapping(value="/queryQuestionLabelInfo",method = RequestMethod.POST)
    public Object queryQuestionLabelInfo(HttpServletRequest request){
        return questionLabelService.queryQuestionLabelInfo();
    }

    /**
     * 删除对应的问题标签信息
     * 输入questionLabelId
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/deleteQuestionLabelInfo",method = RequestMethod.POST)
    public Object deleteQuestionLabelInfo(HttpServletRequest request){
        int i=0;

        i=questionLabelService.deleteQuestionLabelInfo(Integer.valueOf(request.getParameter("questionLabelId")));
        if(i>0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 修改对应的问题标签信息
     * 输入questionLabel
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/updateQuestionLabelInfo",method = RequestMethod.POST)
    public Object updateQuestionLabelInfo(HttpServletRequest request){
        int i=0;
        QuestionLabel questionLabel=new QuestionLabel();
        questionLabel.setQuestionLabelId(Integer.valueOf(request.getParameter("questionLabelId")));
        questionLabel.setChapter(request.getParameter("chapter"));
        questionLabel.setFirstKnowledgePoint(request.getParameter("firstKnowledgePoint"));
        questionLabel.setSecondKnowledgePoint(request.getParameter("secondKnowledgePoint"));
        i=questionLabelService.updateQuestionLabelInfo(questionLabel);
        if(i>0){
            return true;
        }
        else{
            return false;
        }
    }
}
