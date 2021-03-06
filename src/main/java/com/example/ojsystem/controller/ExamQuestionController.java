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
        List<ExamQuestion> examQuestions=new ArrayList<ExamQuestion>();
        examQuestions=examQuestionService.checkExamQuestionByExamId(examId);

        return examQuestions;
    }

    /**
     * 根据考试id查询对应考试选择题
     * 输入examId
     * 输出ExamQuestion
     */
    @RequestMapping(value="/queryExamQuestionChoiceByExamId",method = RequestMethod.POST)
    public Object queryExamQuestionChoiceByExamId(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        return examQuestionService.checkExamQuestionChoiceByExamId(examId);
    }

    /**
     * 根据考试id查询对应考试填空题
     * 输入examId
     * 输出ExamQuestion
     */
    @RequestMapping(value="/queryExamQuestionCompletionByExamId",method = RequestMethod.POST)
    public Object queryExamQuestionCompletionByExamId(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        return examQuestionService.checkExamQuestionCompletionByExamId(examId);
    }

    /**
     * 根据考试id查询对应考试编程题
     * 输入examId
     * 输出ExamQuestion
     */
    @RequestMapping(value="/queryExamQuestionProgrammingByExamId",method = RequestMethod.POST)
    public Object queryExamQuestionProgrammingByExamId(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        return  examQuestionService.checkExamQuestionProgrammingByExamId(examId);
    }

    /**
     * 根据考试id查询对应的编程题信息
     * 输入examId
     * 输出List<ExamQuestion>
     */
    @RequestMapping(value="/queryExamQuestionProgrammingByExamIdAndExamQuestionType",method = RequestMethod.POST)
    public Object queryExamQuestionProgrammingByExamIdAndExamQuestionType(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        String examQuestionType= request.getParameter("examQuestionType");
        return  examQuestionService.checkExamQuestionProgrammingByExamIdAndExamQuestionType(examId,examQuestionType);
    }

    /**
     * 根据题目类型和题目编号添加考试题目
     * 输入examId,questionId
     * 输出int
     */
    @RequestMapping(value="/addExamQuestion",method = RequestMethod.POST)
    public Object addExamQuestionInfo(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        int questionId=Integer.valueOf(request.getParameter("questionId"));
        String examQuestionType=request.getParameter("examQuestionType");
        int i=0;
        i=examQuestionService.saveExamQuestionInfo(examId,questionId,examQuestionType);
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
    public Object addExamQuestionInfos(HttpServletRequest request){
        String addExamQuestions = request.getParameter("addExamQuestions");
        JSONArray jsonArray=JSONArray.parseArray(addExamQuestions);//把前台接收的string数组转化为json数组
//        System.out.println(jsonArray);
        int i=0;
        for(int o=0;o<jsonArray.size();o++){
            JSONObject jsonObject=(JSONObject)jsonArray.get(o);
            if(o==0){
                i=examQuestionService.saveExamQuestionInfo((Integer)jsonObject.get("examId"),(Integer) jsonObject.get("questionId"),(String)jsonObject.get("examQuestion"));
            }else{
                if(i!=0){
                    i=examQuestionService.saveExamQuestionInfo((Integer)jsonObject.get("examId"),(Integer) jsonObject.get("questionId"),(String)jsonObject.get("examQuestion"));
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
    public Object removeExamQuestionInfo(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        int questionId=Integer.valueOf(request.getParameter("questionId"));
        String examQuestionType=request.getParameter("examQuestionType");
        int i=0;
        i=examQuestionService.cancelExamQuestionInfo(examId,questionId,examQuestionType);
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
        return  examQuestionService.checkExamProgrammingResultScoreByExamId(examId);
    }

    /**
     * 根据考试编号查询考试结果的各个分数段
     * 输入examId
     * 输出UserExamScoreEachSegmentNumber
     */
    @RequestMapping(value="/queryUserExamScoreEachSegmentNumberByExamId",method = RequestMethod.POST)
    public Object queryUserExamScoreEachSegmentNumberByExamId(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        return  examQuestionService.checkUserExamScoreEachSegmentNumberByExamId(examId);
    }
}
