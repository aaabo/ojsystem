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
        questionLabel.setImportant(Boolean.valueOf(request.getParameter("important")));
        if(Boolean.valueOf(request.getParameter("important"))==true){
            questionLabel.setSecondKnowledgePoint(questionLabel.getSecondKnowledgePoint()+"*");
        }
        i=questionLabelService.saveQuestionLabelInfo(questionLabel);
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
        return questionLabelService.checkQuestionLabelInfo();
    }

    /**
     * 删除对应的问题标签信息  级联删除选择 填空 编程的标签
     * 输入questionLabelId
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/deleteQuestionLabelInfo",method = RequestMethod.POST)
    public Object removeQuestionLabelInfo(HttpServletRequest request){
        int i=0;

        i=questionLabelService.cancelQuestionLabelInfo(Integer.valueOf(request.getParameter("questionLabelId")));
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
    @RequestMapping(value="/modifyQuestionLabelInfo",method = RequestMethod.POST)
    public Object modifyQuestionLabelInfo(HttpServletRequest request){
        int i=0;
        QuestionLabel questionLabel=new QuestionLabel();
        questionLabel.setQuestionLabelId(Integer.valueOf(request.getParameter("questionLabelId")));
        questionLabel.setChapter(request.getParameter("chapter"));
        questionLabel.setFirstKnowledgePoint(request.getParameter("firstKnowledgePoint"));
        questionLabel.setSecondKnowledgePoint(request.getParameter("secondKnowledgePoint"));
        questionLabel.setImportant(Boolean.valueOf(request.getParameter("important")));
        i=questionLabelService.alterQuestionLabelInfo(questionLabel);
        if(i>0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 获取全部的问题标签的章节信息(去重)
     * 输入无
     * 成功输出List<String>
     */
    @RequestMapping(value="/queryChapterInfo",method = RequestMethod.POST)
    public Object queryChapterInfo(HttpServletRequest request){

        return questionLabelService.checkChapterInfo();
    }

    /**
     * 获取全部的问题标签的章节信息查询第一知识点
     * 输入chapter
     * 成功输出List<String>
     */
    @RequestMapping(value="/queryFirstKnowledgePointInfoByChapter",method = RequestMethod.POST)
    public Object queryFirstKnowledgePointInfoByChapter(HttpServletRequest request){

        return questionLabelService.checkFirstKnowledgePointInfoByChapter(request.getParameter("chapter"));
    }

    /**
     * 根据章节和第一知识点查询问题标签信息
     * 输入chapter firstKnowledgePoint
     * 成功输出List<QuestionLabel>
     */
    @RequestMapping(value="/querySecondKnowledgePointInfoByChapter",method = RequestMethod.POST)
    public Object querySecondKnowledgePointInfoByChapter(HttpServletRequest request){

        return questionLabelService.checkSecondKnowledgePointInfoByChapter(request.getParameter("chapter"),request.getParameter("firstKnowledgePoint"));
    }
}
