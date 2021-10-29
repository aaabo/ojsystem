package com.example.ojsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ojsystem.entity.Exam;
import com.example.ojsystem.entity.ExamProgrammingResultScoreTool;
import com.example.ojsystem.entity.ExamQuestion;
import com.example.ojsystem.entity.UserExamScoreEachSegmentNumber;
import com.example.ojsystem.service.ExamQuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
     * 根据题目类型和题目编号批量添加考试题目
     * 输入examId,questionId
     * 输出成功输入true失败false
     */
    @RequestMapping(value="/addExamQuestions",method = RequestMethod.POST)
    public Object addExamQuestions(HttpServletRequest request){
        String addExamQuestions = request.getParameter("addExamQuestions");
        JSONArray jsonArray=JSONArray.parseArray(addExamQuestions);//把前台接收的string数组转化为json数组
//        System.out.println(jsonArray);
        int i=0;
        for(int o=0;o<jsonArray.size();o++){
            JSONObject jsonObject=(JSONObject)jsonArray.get(o);
            if(o==0){
                i=examQuestionService.addExamQuestion((Integer)jsonObject.get("examId"),(Integer) jsonObject.get("questionId"),(String)jsonObject.get("examQuestion"));
            }else{
                if(i!=0){
                    i=examQuestionService.addExamQuestion((Integer)jsonObject.get("examId"),(Integer) jsonObject.get("questionId"),(String)jsonObject.get("examQuestion"));
                }
            }
        }
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

    /**
     * 根据考试编号查询编程题的各题平均分
     * 输入examId
     * 输出List<ExamProgrammingResultScoreTool>
     */
    @RequestMapping(value="/queryExamProgrammingResultScoreByExamId",method = RequestMethod.POST)
    public Object queryExamProgrammingResultScoreByExamId(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        return  examQuestionService.queryExamProgrammingResultScoreByExamId(examId);
    }

    /**
     * 根据考试编号查询考试结果的各个分数段
     * 输入examId
     * 输出UserExamScoreEachSegmentNumber
     */
    @RequestMapping(value="/queryUserExamScoreEachSegmentNumberByExamId",method = RequestMethod.POST)
    public Object queryUserExamScoreEachSegmentNumberByExamId(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        return  examQuestionService.queryUserExamScoreEachSegmentNumberByExamId(examId);
    }
}
