package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Exam;
import com.example.ojsystem.entity.ExamQuestion;
import com.example.ojsystem.service.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/examQuestion")
public class ExamQuestionController {
    @Autowired
    ExamQuestionService examQuestionService;
    /**
     * 根据考试id查询对应全部的题目信息
     * 输入examId
     * 输出ExamQuestion
     */
    @RequestMapping(value="/queryExamQuestionByExamId",method = RequestMethod.POST)
    public Object queryExamQuestionByExamId(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        ExamQuestion examQuestion=new ExamQuestion();
        examQuestion.setChoiceQuestions(examQuestionService.queryExamQuestionChoiceByExamId(examId));
        examQuestion.setCompletionQuestions(examQuestionService.queryExamQuestionCompletionByExamId(examId));
        examQuestion.setExercises(examQuestionService.queryExamQuestionProgrammingByExamId(examId));
        return examQuestion;
    }

    /**
     * 根据考试id查询对应考试选择题
     * 输入examId
     * 输出ExamQuestion
     */
    @RequestMapping(value="/queryExamQuestionChoiceByExamId",method = RequestMethod.POST)
    public Object queryExamQuestionChoiceByExamId(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        return examQuestionService.queryExamQuestionChoiceByExamId(examId);
    }

    /**
     * 根据考试id查询对应考试填空题
     * 输入examId
     * 输出ExamQuestion
     */
    @RequestMapping(value="/queryExamQuestionCompletionByExamId",method = RequestMethod.POST)
    public Object queryExamQuestionCompletionByExamId(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        return examQuestionService.queryExamQuestionCompletionByExamId(examId);
    }

    /**
     * 根据考试id查询对应考试编程题
     * 输入examId
     * 输出ExamQuestion
     */
    @RequestMapping(value="/queryExamQuestionProgrammingByExamId",method = RequestMethod.POST)
    public Object queryExamQuestionProgrammingByExamId(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        return  examQuestionService.queryExamQuestionProgrammingByExamId(examId);
    }

    /**
     * 根据题目类型和题目编号添加考试题目
     * 输入examId,questionId
     * 输出int
     */
    @RequestMapping(value="/addExamQuestion",method = RequestMethod.POST)
    public Object addExamQuestion(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        int questionId=Integer.valueOf(request.getParameter("questionId"));
        String examQuestionType=request.getParameter("examQuestionType");
        int i=0;
        i=examQuestionService.addExamQuestion(examId,questionId,examQuestionType);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 根据题目类型和题目编号题目类型删除对应的考试题目
     * 输入examId,questionId,examQuestionType
     * 输出int
     */
    @RequestMapping(value="/deleteExamQuestion",method = RequestMethod.POST)
    public Object deleteExamQuestion(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        int questionId=Integer.valueOf(request.getParameter("questionId"));
        String examQuestionType=request.getParameter("examQuestionType");
        int i=0;
        i=examQuestionService.deleteExamQuestion(examId,questionId,examQuestionType);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
