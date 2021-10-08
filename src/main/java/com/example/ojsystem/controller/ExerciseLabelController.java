package com.example.ojsystem.controller;

import com.example.ojsystem.entity.ExerciseLabel;
import com.example.ojsystem.entity.Group;
import com.example.ojsystem.service.ExerciseLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/exerciseLabel")
public class ExerciseLabelController {
    @Autowired
    ExerciseLabelService exerciseLabelService;
    /**
     * 获取习题标签信息并添加
     * 输入exerciseLabel
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/addExerciseLabelInfo",method = RequestMethod.POST)
    public Object addExerciseLabelInfo(HttpServletRequest request){
        int i=0;
        ExerciseLabel exerciseLabel=new ExerciseLabel();
        exerciseLabel.setFirstPoint(request.getParameter("firstPoint"));
        exerciseLabel.setSecondPoint(request.getParameter("secondPoint"));
        i=exerciseLabelService.addExerciseLabelInfo(exerciseLabel);
        if(i>0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 获取全部习题标签信息
     * 输入无
     * 成功输出List<ExerciseLabel>
     */
    @RequestMapping(value="/queryExerciseLabelInfo",method = RequestMethod.POST)
    public Object queryExerciseLabelInfo(HttpServletRequest request){

        return exerciseLabelService.queryExerciseLabelInfo();

    }

    /**
     * 修改对应的习题标签信息
     * 输入exerciseLabel
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/modifyExerciseLabelInfo",method = RequestMethod.POST)
    public Object updateExerciseLabelInfo(HttpServletRequest request){

        int i=0;
        ExerciseLabel exerciseLabel=new ExerciseLabel();
        exerciseLabel.setExerciseLabelId(Integer.valueOf(request.getParameter("exerciseLabelId")));
        exerciseLabel.setFirstPoint(request.getParameter("firstPoint"));
        exerciseLabel.setSecondPoint(request.getParameter("secondPoint"));
        i=exerciseLabelService.modifyExerciseLabelInfo(exerciseLabel);
        if(i>0){
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * 删除对应的习题标签信息
     * 输入exerciseLabelId
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/deleteExerciseLabelInfo",method = RequestMethod.POST)
    public Object deleteExerciseLabelInfo(HttpServletRequest request){
        int i=0;
        i=exerciseLabelService.deleteExerciseLabelInfo(Integer.valueOf(request.getParameter("exerciseLabelId")));
        if(i>0){
            return true;
        }
        else{
            return false;
        }
    }
}
