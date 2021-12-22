package com.example.ojsystem.controller;

import com.example.ojsystem.entity.ChoiceQuestion;
import com.example.ojsystem.entity.QuestionLabel;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.ChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/choiceQuestion")
public class ChoiceQuestionController {
    @Autowired
    ChoiceQuestionService choiceQuestionService;

    /**
     * 根据输入的选择题信息添加到选择题题库中 并添加选择题标签信息
     * 输入choiceQuestion
     * 输出int
     */

    @RequestMapping(value="/addChoiceQuestionInfo",method = RequestMethod.POST)
    public Object addChoiceQuestionInfo(HttpServletRequest request,@RequestBody ChoiceQuestion choiceQuestion){

        int i=choiceQuestionService.saveChoiceQuestionInfo(choiceQuestion);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据输入的选择题信息修改对应的选择题
     * 输入choiceQuestion
     * 输出int
     */
    @RequestMapping(value="/modifyChoiceQuestionInfo",method = RequestMethod.POST)
    public Object modifyChoiceQuestionInfo(HttpServletRequest request,@RequestBody ChoiceQuestion choiceQuestion){

        int i=choiceQuestionService.alterChoiceQuestionInfo(choiceQuestion);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 查询自己私有创建的选择题目和共有的选择题目
     * 输入userId
     * 输出int
     */
    @RequestMapping(value="/queryChoiceQuestionInfo",method = RequestMethod.POST)
    public Object queryChoiceQuestionInfo(HttpServletRequest request){
        HttpSession session=request.getSession();
        int userId=(Integer)session.getAttribute("userId");
        return choiceQuestionService.checkChoiceQuestionInfo(userId);
    }

    /**
     * 根据选择题id删除对应的选择题
     * 输入choiceQuestionId
     * 输出int
     */
    @RequestMapping(value="/deleteChoiceQuestionInfoByChoiceQuestionId",method = RequestMethod.POST)
    public Object removeChoiceQuestionInfoByChoiceQuestionId(HttpServletRequest request){
        int i=choiceQuestionService.cancelChoiceQuestionInfoByChoiceQuestionId(Integer.valueOf(request.getParameter("choiceQuestionId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 根据输入的查询信息
     * 输入choiceQuestion
     * 输出List<ChoiceQuestion>
     */
    @RequestMapping(value="/queryChoiceQuestionInfoBySearchInfo",method = RequestMethod.POST)
    public Object queryChoiceQuestionInfoBySearchInfo(HttpServletRequest request){
        HttpSession session=request.getSession();
        int currentUserId=(Integer)session.getAttribute("userId");
        ChoiceQuestion choiceQuestion=new ChoiceQuestion();
        QuestionLabel questionLabel=new QuestionLabel();
        List<ChoiceQuestion> choiceQuestions=new ArrayList<ChoiceQuestion>();
        List<ChoiceQuestion> choiceQuestions2=new ArrayList<ChoiceQuestion>();
        List<QuestionLabel> questionLabels=new ArrayList<QuestionLabel>();
        List<Integer> choiceQuestionIds=new ArrayList<Integer>();
        int userId=Integer.valueOf(request.getParameter("userId"));
        String chapter=request.getParameter("chapter");
        String firstKnowledge=request.getParameter("firstKnowledge");
        int questionLabelId=Integer.valueOf(request.getParameter("questionLabelId"));
        User user=new User();
        if(userId!=0){
            user.setUserId(userId);
        }else{
            user.setUserId(0);
        }
        choiceQuestion.setUser(user);
        if(!chapter.equals("")){
            questionLabel.setChapter(chapter);
        }
        if(!firstKnowledge.equals("")){
            questionLabel.setFirstKnowledgePoint(firstKnowledge);
        }
        if(questionLabelId!=0){
            questionLabel.setQuestionLabelId(questionLabelId);
        }
        questionLabels.add(questionLabel);
        choiceQuestion.setQuestionLabels(questionLabels);
        choiceQuestions= choiceQuestionService.checkChoiceQuestionIdBySearchInfo(choiceQuestion,currentUserId);
        //查询出来的选择题只有选中的一个标签 需要用对应的id查询全部的标签
        for(int i=0;i<choiceQuestions.size();i++){
            ChoiceQuestion choiceQuestion2=new ChoiceQuestion();
            choiceQuestion2=choiceQuestionService.checkChoiceQuestionInfoByChoiceQuestionId(choiceQuestions.get(i).getChoiceQuestionId());
            choiceQuestions2.add(choiceQuestion2);
        }

        return  choiceQuestions2;
    }




    /**
     * 根据输入的考试编号查询考试选择题信息
     * 输入examId
     * 输出List<ChoiceQuestion>
     */
    @RequestMapping(value="/queryChoiceQuestionInfoByExamId",method = RequestMethod.POST)
    public Object queryChoiceQuestionInfoByExamId(HttpServletRequest request){
        return choiceQuestionService.checkChoiceQuestionInfoByExamId(Integer.valueOf(request.getParameter("examId")));
    }


    /**
     * 根据输入choiceQuestionId判断是否在考试或测试中
     * 输入choiceQuestionId
     * 输出true 或者false
     */
    @RequestMapping(value="/queryChoiceQuestionIsExamByChoiceQuestionId",method = RequestMethod.POST)
    public Object queryChoiceQuestionIsExamByChoiceQuestionId(HttpServletRequest request){
        return choiceQuestionService.checkChoiceQuestionIsExamByChoiceQuestionId(Integer.valueOf(request.getParameter("choiceQuestionId")));
    }
}
