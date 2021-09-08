package com.example.ojsystem.controller;

import com.example.ojsystem.dao.ExamChoiceQuestionMapper;
import com.example.ojsystem.entity.Exam;
import com.example.ojsystem.entity.ExamChoiceQuestion;
import com.example.ojsystem.service.ExamChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/examChoiceQuestion")
public class ExamChoiceQuestionController {
    @Autowired
    ExamChoiceQuestionService examChoiceQuestionService;
    /**
     * 根据考试id和选择题信息添加选择题信息
     * 输入examChoiceQuestion
     * 输出成功返回添加的id 失败返回0
     */
    @RequestMapping(value="/addChoiceQuestionExamInfo",method = RequestMethod.POST)
    public int addChoiceExamInfo(HttpServletRequest request){
        int i=0;
        int examId=Integer.valueOf(request.getParameter("examId"));
        String examChoiceQuestionTitle=request.getParameter("examChoiceQuestionTitle");
        String examChoiceQuestionStemA=request.getParameter("examChoiceQuestionStemA");
        String examChoiceQuestionStemB=request.getParameter("examChoiceQuestionStemB");
        String examChoiceQuestionStemC=request.getParameter("examChoiceQuestionStemC");
        String examChoiceQuestionStemD=request.getParameter("examChoiceQuestionStemD");
        String examChoiceQuestionCorrectOption=request.getParameter("examChoiceQuestionCorrectOption");
        int examChoiceQuestionScore=Integer.valueOf(request.getParameter("examChoiceQuestionScore"));
        ExamChoiceQuestion examChoiceQuestion=new ExamChoiceQuestion();
        Exam exam=new Exam();
        exam.setExamId(examId);
        examChoiceQuestion.setExam(exam);
        examChoiceQuestion.setExamChoiceQuestionStemA(examChoiceQuestionStemA);
        examChoiceQuestion.setExamChoiceQuestionStemB(examChoiceQuestionStemB);
        examChoiceQuestion.setExamChoiceQuestionStemC(examChoiceQuestionStemC);
        examChoiceQuestion.setExamChoiceQuestionStemD(examChoiceQuestionStemD);
        examChoiceQuestion.setExamChoiceQuestionTitle(examChoiceQuestionTitle);
        examChoiceQuestion.setExamChoiceQuestionCorrectOption(examChoiceQuestionCorrectOption);
        examChoiceQuestion.setExamChoiceQuestionScore(examChoiceQuestionScore);
        i=examChoiceQuestionService.addChoiceQuestionExamInfo(examChoiceQuestion);
        if(i!=0){
            return examChoiceQuestion.getExamChoiceQuestionId();
        }
        else{
            return 0;
        }
    }
    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<ExamChoiceQuestion>
     */
    @RequestMapping(value="/queryChoiceQuestionInfoById",method = RequestMethod.POST)
    public Object queryChoiceInfoById(HttpServletRequest request){
        return examChoiceQuestionService.queryChoiceQuestionInfoById(Integer.valueOf(request.getParameter("examId")));
    }


    /**
     * 根据新输入的选择题信息修改选择题
     * 输入examChoiceQuestion
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/modifyChoiceQuestionExamInfo",method = RequestMethod.POST)
    public Boolean modifyChoiceQuestionExamInfo(HttpServletRequest request){
        int i=0;
        int examChoiceQuestionId=Integer.valueOf(request.getParameter("examChoiceQuestionId"));
        String examChoiceQuestionTitle=request.getParameter("examChoiceQuestionTitle");
        String examChoiceQuestionStemA=request.getParameter("examChoiceQuestionStemA");
        String examChoiceQuestionStemB=request.getParameter("examChoiceQuestionStemB");
        String examChoiceQuestionStemC=request.getParameter("examChoiceQuestionStemC");
        String examChoiceQuestionStemD=request.getParameter("examChoiceQuestionStemD");
        String examChoiceQuestionCorrectOption=request.getParameter("examChoiceQuestionCorrectOption");
        int examChoiceQuestionScore=Integer.valueOf(request.getParameter("examChoiceQuestionScore"));
        ExamChoiceQuestion examChoiceQuestion=new ExamChoiceQuestion();
        examChoiceQuestion.setExamChoiceQuestionStemA(examChoiceQuestionStemA);
        examChoiceQuestion.setExamChoiceQuestionStemB(examChoiceQuestionStemB);
        examChoiceQuestion.setExamChoiceQuestionStemC(examChoiceQuestionStemC);
        examChoiceQuestion.setExamChoiceQuestionStemD(examChoiceQuestionStemD);
        examChoiceQuestion.setExamChoiceQuestionTitle(examChoiceQuestionTitle);
        examChoiceQuestion.setExamChoiceQuestionCorrectOption(examChoiceQuestionCorrectOption);
        examChoiceQuestion.setExamChoiceQuestionScore(examChoiceQuestionScore);
        examChoiceQuestion.setExamChoiceQuestionId(examChoiceQuestionId);
        i=examChoiceQuestionService.modifyChoiceQuestionExamInfo(examChoiceQuestion);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据输入的examChoiceId删除选择题信息
     * 输入examChoiceQuestionId
     * 输出int
     */
    @RequestMapping(value="/deleteChoiceQuestionExamInfo",method = RequestMethod.POST)
    public Boolean deleteChoiceQuestionExamInfo(HttpServletRequest request){
        int i=0;
        i=examChoiceQuestionService.deleteChoiceQuestionExamInfo(Integer.valueOf(request.getParameter("examChoiceQuestionId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据输入的examId查询考试的选择题总分
     * 输入examId
     * 输出int
     */
    @RequestMapping(value="/queryChoiceQuestionTotalScore",method = RequestMethod.POST)
    public Object queryChoiceQuestionTotalScore(HttpServletRequest request){
        return examChoiceQuestionService.queryChoiceQuestionTotalScore(Integer.valueOf(request.getParameter("examId")));
    }
}
