package com.example.ojsystem.controller;

import com.example.ojsystem.entity.ChoiceQuestion;
import com.example.ojsystem.service.ChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

        int i=choiceQuestionService.addChoiceQuestionInfo(choiceQuestion);
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
        System.out.println(choiceQuestion);

        int i=choiceQuestionService.modifyChoiceQuestionInfo(choiceQuestion);
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
        return choiceQuestionService.queryChoiceQuestionInfo(userId);
    }

    /**
     * 根据选择题id删除对应的选择题
     * 输入choiceQuestionId
     * 输出int
     */
    @RequestMapping(value="/deleteChoiceQuestionInfoByChoiceQuestionId",method = RequestMethod.POST)
    public Object deleteChoiceQuestionInfoByChoiceQuestionId(HttpServletRequest request){
        return choiceQuestionService.deleteChoiceQuestionInfoByChoiceQuestionId(Integer.valueOf(request.getParameter("choiceQuestionId")));
    }
}
