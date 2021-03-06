package com.example.ojsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.ojsystem.entity.Exercise;
import com.example.ojsystem.entity.QuestionLabel;
import com.example.ojsystem.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/exercise")
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;



    /**
     * 根据添加习题信息到数据库
     * 输入习题信息
     * 成功返回新增的习题id 失败返回0
     */
    @RequestMapping(value="/addExercise",method = RequestMethod.POST)
    public int addExerciseInfo(HttpServletRequest request){
        int i=0;
        Exercise exercise=new Exercise();
        String exerciseTitle=request.getParameter("exerciseTitle");
        int  exerciseCorrectTimes=Integer.valueOf(request.getParameter("exerciseCorrectTimes"));
        int  exerciseSubmitTimes=Integer.valueOf(request.getParameter("exerciseSubmitTimes"));
        String exerciseDescription=request.getParameter("exerciseDescription");
        String exerciseInput=request.getParameter("exerciseInput");
        String exerciseOutPut=request.getParameter("exerciseOutPut");
        String exerciseSampleInput=request.getParameter("exerciseSampleInput");
        String exerciseSampleOutput=request.getParameter("exerciseSampleOutput");
        int questionLabelId=Integer.valueOf(request.getParameter("questionLabelId"));
        QuestionLabel questionLabel=new QuestionLabel();
        questionLabel.setQuestionLabelId(questionLabelId);
        exercise.setExerciseTitle(exerciseTitle);
        exercise.setExerciseCorrectTimes(exerciseCorrectTimes);
        exercise.setExerciseSubmitTimes(exerciseSubmitTimes);
        exercise.setExerciseDescription(exerciseDescription);
        exercise.setExerciseInput(exerciseInput);
        exercise.setExerciseOutPut(exerciseOutPut);
        exercise.setExerciseSampleInput(exerciseSampleInput);
        exercise.setExerciseSampleOutput(exerciseSampleOutput);
        exercise.setQuestionLabel(questionLabel);
        i=exerciseService.saveExerciseInfo(exercise);
        if(i!=0){
            return exercise.getExerciseId();
        }
        else{
            return 0;
        }
    }


    /**
     * 查询全部不在考试中的习题信息
     * 输入无
     * 输出List<Exercise>
     */
    @RequestMapping(value="/queryExerciseInfo",method = RequestMethod.POST)
    public  Object  queryExerciseInfo(HttpServletRequest request){
        List<Exercise> exercises=new ArrayList<Exercise>();
        exercises=exerciseService.checkExerciseInfo();
        return exercises;
    }

    /**
     * 查询全部的习题信息并判断对应用户的做题情况
     * 输入无
     * 输出List<Exercise>
     */
    @RequestMapping(value="/queryExerciseInfoAndPersonSubmitStatus",method = RequestMethod.POST)
    public  Object  queryExerciseInfoAndPersonSubmitStatus(HttpServletRequest request){

        List<Exercise> exercises=new ArrayList<Exercise>();
        Integer userId=(Integer)request.getSession().getAttribute("userId");

        exercises=exerciseService.queryExerciseInfoAndPersonSubmitStatus(userId);
        return exercises;
    }


    /**
     * 根据习题id查询习题信息是否存在
     * 输入exerciseId
     * 输出int
     */
    @RequestMapping(value="/queryExerciseInfoIsExit",method = RequestMethod.POST)
    public  Object  queryExerciseInfoIsExit(HttpServletRequest request){
        return exerciseService.checkExerciseInfoIsExit(Integer.valueOf(request.getParameter("exerciseId")));

    }

    /**
     * 修改选中的习题信息
     * 输入exercise
     * 输出修改成功返回true 修改失败返回false
     */
    @RequestMapping(value="/modifyExerciseInfo",method = RequestMethod.POST)
    public Boolean modifyExerciseInfo(HttpServletRequest request){
        int i=0;
        Exercise exercise=new Exercise();
        int  exerciseId=Integer.valueOf(request.getParameter("exerciseId"));
        String exerciseTitle=request.getParameter("exerciseTitle");
        String exerciseDescription=request.getParameter("exerciseDescription");
        String exerciseInput=request.getParameter("exerciseInput");
        String exerciseOutPut=request.getParameter("exerciseOutPut");
        String exerciseSampleInput=request.getParameter("exerciseSampleInput");
        String exerciseSampleOutput=request.getParameter("exerciseSampleOutput");
        String questionLabelId=request.getParameter("questionLabelId");
        QuestionLabel questionLabel=new QuestionLabel();
        questionLabel.setQuestionLabelId(Integer.valueOf(questionLabelId));
        exercise.setExerciseId(exerciseId);
        exercise.setExerciseTitle(exerciseTitle);
        exercise.setExerciseDescription(exerciseDescription);
        exercise.setExerciseInput(exerciseInput);
        exercise.setExerciseOutPut(exerciseOutPut);
        exercise.setExerciseSampleInput(exerciseSampleInput);
        exercise.setExerciseSampleOutput(exerciseSampleOutput);
        exercise.setQuestionLabel(questionLabel);
        i=exerciseService.alterExerciseInfo(exercise);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }





    /**
     * 删除选中的习题信息
     * 输入exerciseId
     * 输出删除成功返回true 修改失败返回false
     */
    @RequestMapping(value="/deleteExercise",method = RequestMethod.POST)
    public Boolean removeExerciseInfo(HttpServletRequest request){
        int i=0;
        int  exerciseId=Integer.valueOf(request.getParameter("exerciseId"));
        i=exerciseService.cancelExerciseInfo(exerciseId);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 查询选择的习题详情
     * 输入exerciseId
     * 输出Exercise
     *
     */
    @RequestMapping(value="/queryExerciseDetailsInfoByExerciseId",method = RequestMethod.POST)
    public Object queryExerciseDetailsInfoByExerciseId(HttpServletRequest request){
        return exerciseService.checkExerciseDetailsInfoByExerciseId(Integer.valueOf(request.getParameter("exerciseId")));
    }


    /**
     * 根据习题标签查询对应的习题信息
     * 输入labelIds
     * 输出List<Exercise>
     *
     */
//    @RequestMapping(value="/queryExerciseInfoByFirstPoint",method = RequestMethod.POST)
//    public Object queryExerciseInfoByFirstPoint(HttpServletRequest request){
//        List labels =new ArrayList<Label>();
//        labels=JSON.parseArray(request.getParameter("labels"),Label.class);
//        return exerciseService.queryExerciseInfoByFirstPoint(labels);
//    }


    /**
     * 根据输入exerciseId判断是否在考试或测试中
     * 输入exerciseId
     * 输出true 或者false
     */
    @RequestMapping(value="/queryExerciseIsExamByExerciseId",method = RequestMethod.POST)
    public Object queryExerciseIsExamByExerciseId(HttpServletRequest request){
        return exerciseService.checkExerciseIsExamByExerciseId(Integer.valueOf(request.getParameter("exerciseId")));
    }
}
