package com.example.ojsystem.controller;

import com.example.ojsystem.entity.ExamProgramming;
import com.example.ojsystem.entity.ExamProgrammingAnswer;
import com.example.ojsystem.service.ExamProgrammingAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/examProgrammingAnswer")
public class ExamProgrammingAnswerController {
    @Autowired
    ExamProgrammingAnswerService examProgrammingAnswerService;

    /**
     * 根据上传的考试编程题答案来添加信息
     * 输入examProgrammingAnswer
     * 输出成功返回自增的id集合 失败返回0
     */
    @RequestMapping(value="/addExamProgrammingAnswer",method = RequestMethod.POST)
    public Object addExamProgrammingAnswer(HttpServletRequest request,@RequestBody List<ExamProgrammingAnswer> examProgrammingAnswers){
        int i=0;
        for(int o=0;o<examProgrammingAnswers.size();o++){
            i=examProgrammingAnswerService.addExamProgrammingAnswer(examProgrammingAnswers.get(o));
        }
        if(i!=0){
            return examProgrammingAnswers;
        }
        else{
            return 0;
        }
    }


    /**
     * 根据上传的考试编程题答案信息来修改考试编程题答案信息
     * 输入examProgrammingAnswer
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/modifyExamProgrammingAnswer",method = RequestMethod.POST)
    public Boolean modifyExamProgrammingAnswer(HttpServletRequest request){
        int i=0;
        int examProgrammingAnswerId=Integer.valueOf(request.getParameter("examProgrammingAnswerId"));
        String examProgrammingAnswerInput=request.getParameter("examProgrammingAnswerInput");
        String examProgrammingAnswerOutput=request.getParameter("examProgrammingAnswerOutput");
        ExamProgrammingAnswer examProgrammingAnswer=new ExamProgrammingAnswer();
        examProgrammingAnswer.setExamProgrammingAnswerId(examProgrammingAnswerId);
        examProgrammingAnswer.setExamProgrammingAnswerInput(examProgrammingAnswerInput);
        examProgrammingAnswer.setExamProgrammingAnswerOutput(examProgrammingAnswerOutput);
        i=examProgrammingAnswerService.modifyExamProgrammingAnswer(examProgrammingAnswer);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }



    /**
     * 根据上传的考试编程题答案id来删除考试编程题信息
     * 输入examProgrammingAnswerId
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/deleteExamProgrammingAnswer",method = RequestMethod.POST)
    public Boolean deleteExamProgrammingAnswer(HttpServletRequest request){
        int i=0;
        i=examProgrammingAnswerService.deleteExamProgrammingAnswer(Integer.valueOf(request.getParameter("examProgrammingAnswerId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
