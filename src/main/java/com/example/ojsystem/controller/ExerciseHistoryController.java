package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Exercise;
import com.example.ojsystem.entity.ExerciseHistory;
import com.example.ojsystem.entity.Student;
import com.example.ojsystem.service.ExerciseHistoryService;
import com.example.ojsystem.tool.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/exerciseHistory")
public class ExerciseHistoryController {
    @Autowired
    ExerciseHistoryService exerciseHistoryService;
    /**
     * 根据提交的代码 添加习题记录
     * 输入exerciseHistory
     * 输出int
     */
    @RequestMapping(value="/addCodeInfo",method = RequestMethod.POST)
    public Boolean addCodeInfo(HttpServletRequest request){
        int i=0;
        int studentId=(Integer)request.getSession().getAttribute("studentId");
        int exerciseId=Integer.valueOf(request.getParameter("exerciseId"));
        String exerciseSubmitTime=request.getParameter("exerciseSubmitTime");
        String exerciseSubmitLanguage=request.getParameter("exerciseSubmitLanguage");
        String exerciseCode=request.getParameter("exerciseCode");
        ExerciseHistory exerciseHistory=new ExerciseHistory();
        exerciseHistory.setExerciseCode(exerciseCode);
        exerciseHistory.setExerciseSubmitTime(exerciseSubmitTime);
        exerciseHistory.setExerciseSubmitLanguage(exerciseSubmitLanguage);
        Student student=new Student();
        student.setStudentId(studentId);
        Exercise exercise=new Exercise();
        exercise.setExerciseId(exerciseId);
        exerciseHistory.setStudent(student);
        exerciseHistory.setExercise(exercise);
        i=exerciseHistoryService.addCodeInfo(exerciseHistory);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据习题id或者学生id来查询习题记录
     * 输入exerciseId和studentId
     * 输出List<ExerciseHistory>
     */
    @RequestMapping(value="/queryExerciseRealtimeStatusInfo",method = RequestMethod.POST)
    public Object queryExerciseRealtimeStatusInfo(HttpServletRequest request){
        return exerciseHistoryService.queryExerciseRealtimeStatusInfo(Integer.valueOf(request.getParameter("exerciseId")),Integer.valueOf(request.getParameter("studentId")));

    }

    /**
     * 根据习题id来查询习题的排行
     * 输入exerciseId
     * 输出List<ExerciseHistory>
     */
    @RequestMapping(value="/queryExerciseStatisticsInfo",method = RequestMethod.POST)
    public Object queryExerciseStatisticsInfo(HttpServletRequest request){
        return exerciseHistoryService.queryExerciseStatisticsInfo(Integer.valueOf(request.getParameter("exerciseId")));
    }

    /**
     * 根据习题id和学生id判断习题是否已经提交成功过
     * 输入studentId和exerciseId
     * 输出查询到的数量
     */
    @RequestMapping(value="/queryStudnetExerciseIsSuccess",method = RequestMethod.POST)
    public int queryStudnetExerciseIsSuccess(HttpServletRequest request){
        return exerciseHistoryService.queryStudnetExerciseIsSuccess(Integer.valueOf(request.getParameter("studentId")),Integer.valueOf(request.getParameter("exerciseId")));
    }


    /**
     * 根据习题记录id查询提交代码
     * 输入exerciseHistoryId
     * 输出查到的代码信息
     */
    @RequestMapping(value="/queryCodeInfoByExerciseHistoryId",method = RequestMethod.POST)
    public String queryCodeInfoByExerciseHistoryId(HttpServletRequest request){
        return exerciseHistoryService.queryCodeInfoByExerciseHistoryId(Integer.valueOf(request.getParameter("exerciseHistoryId")));
    }


    /**
     * 根据学生id查询提交过但未通过的习题
     * 输入studentId
     * 输出查到的习题id
     */
    @RequestMapping(value="/queryExerciseIdByStudentId",method = RequestMethod.POST)
    public Object queryExerciseIdByStudentId(HttpServletRequest request){
        return exerciseHistoryService.queryExerciseIdByStudentId(Integer.valueOf(request.getParameter("studentId")));
    }


    /**
     * 根据习题id查询习题结果信息
     * 输入exerciseId
     * 输出查到的习题结果信息
     */
    @RequestMapping(value="/queryExerciseResultInfo",method = RequestMethod.POST)
    public Object queryExerciseResultInfo(HttpServletRequest request){
        return exerciseHistoryService.queryExerciseResultInfo(Integer.valueOf(request.getParameter("exerciseId")));
    }

}
