package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Exercise;
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
    public int addExercise(HttpServletRequest request){
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
        exercise.setExerciseTitle(exerciseTitle);
        exercise.setExerciseCorrectTimes(exerciseCorrectTimes);
        exercise.setExerciseSubmitTimes(exerciseSubmitTimes);
        exercise.setExerciseDescription(exerciseDescription);
        exercise.setExerciseInput(exerciseInput);
        exercise.setExerciseOutPut(exerciseOutPut);
        exercise.setExerciseSampleInput(exerciseSampleInput);
        exercise.setExerciseSampleOutput(exerciseSampleOutput);
        i=exerciseService.addExercise(exercise);
        if(i!=0){
            return exercise.getExerciseId();
        }
        else{
            return 0;
        }
    }


    /**
     * 查询全部习题信息
     * 输入无
     * 输出List<Exercise>
     */
    @RequestMapping(value="/queryExerciseInfo",method = RequestMethod.POST)
    public  Object  queryExerciseInfo(HttpServletRequest request){
        List<Exercise> exercises=new ArrayList<Exercise>();
        exercises=exerciseService.queryExerciseInfo();
        return exercises;
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
        exercise.setExerciseId(exerciseId);
        exercise.setExerciseTitle(exerciseTitle);
        exercise.setExerciseDescription(exerciseDescription);
        exercise.setExerciseInput(exerciseInput);
        exercise.setExerciseOutPut(exerciseOutPut);
        exercise.setExerciseSampleInput(exerciseSampleInput);
        exercise.setExerciseSampleOutput(exerciseSampleOutput);
        i=exerciseService.modifyExerciseInfo(exercise);
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
    public Boolean deleteProblem(HttpServletRequest request){
        int i=0;
        int  exerciseId=Integer.valueOf(request.getParameter("exerciseId"));
        i=exerciseService.deleteExercise(exerciseId);
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
        return exerciseService.queryExerciseDetailsInfoByExerciseId(Integer.valueOf(request.getParameter("exerciseId")));
    }
}
