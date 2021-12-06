package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Exercise;
import com.example.ojsystem.entity.ExerciseAnswer;
import com.example.ojsystem.service.ExerciseAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/exerciseAnswer")
public class ExerciseAnswerController {
    @Autowired
    ExerciseAnswerService exerciseAnswerService;


    /**
     * 根据添加习题信息到数据库
     * 输入答案信息
     * 成功返回新增的答案的id 失败返回0
     */
    @RequestMapping(value="/addExerciseAnswer",method = RequestMethod.POST)
    public Object addExerciseAnswerInfo(HttpServletRequest request){
        int i=0;
        ExerciseAnswer exerciseAnswer = new ExerciseAnswer();
        int  exerciseId=Integer.valueOf(request.getParameter("exerciseId"));
        String exerciseAnswerInput=request.getParameter("exerciseAnswerInput");
        String exerciseAnswerOutput=request.getParameter("exerciseAnswerOutput");
        Exercise exercise = new Exercise();
        exercise.setExerciseId(exerciseId);
        exerciseAnswer.setExercise(exercise);
        exerciseAnswer.setExerciseAnswerInput(exerciseAnswerInput);
        exerciseAnswer.setExerciseAnswerOutput(exerciseAnswerOutput);
        i = exerciseAnswerService.saveExerciseAnswerInfo(exerciseAnswer);
        if(i!=0){
            return exerciseAnswer.getExerciseAnswerId();
        }
        else{
            return 0;
        }
    }


    /**
     * 查询全部习题答案信息
     * 输入无
     * 输出List<ExerciseAnswer>
     */
    @RequestMapping(value="/queryExerciseAnswerInfoByExerciseId",method = RequestMethod.POST)
    public Object queryExerciseAnswerInfoByExerciseId(HttpServletRequest request){
        int exerciseId=Integer.valueOf(request.getParameter("exerciseId"));
        return exerciseAnswerService.checkExerciseAnswerInfoByExerciseId(exerciseId);
    }



    /**
     * 修改习题答案信息
     * 输入习题答案信息
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/modifyExerciseAnswerInfo",method = RequestMethod.POST)
    public Boolean modifyExerciseAnswerInfo(HttpServletRequest request){
        int i=0;
        int exerciseAnswerId=Integer.valueOf(request.getParameter("exerciseAnswerId"));
        String exerciseAnswerInput=request.getParameter("exerciseAnswerInput");
        String exerciseAnswerOutput=request.getParameter("exerciseAnswerOutput");
        ExerciseAnswer exerciseAnswer=new ExerciseAnswer();
        exerciseAnswer.setExerciseAnswerOutput(exerciseAnswerOutput);
        exerciseAnswer.setExerciseAnswerInput(exerciseAnswerInput);
        exerciseAnswer.setExerciseAnswerId(exerciseAnswerId);
        i=exerciseAnswerService.alterExerciseAnswerInfo(exerciseAnswer);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }



    /**
     * 删除习题答案信息
     * 输入习题答案信息id
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/deleteExerciseAnswer",method = RequestMethod.POST)
    public Boolean removeExerciseAnswer(HttpServletRequest request){
        int i=0;

        i=exerciseAnswerService.cancelExerciseAnswer(Integer.valueOf(request.getParameter("exerciseAnswerId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
