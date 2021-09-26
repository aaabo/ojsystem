package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Exercise;
import com.example.ojsystem.entity.ExerciseHistory;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.ExerciseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
        int userId=(Integer)request.getSession().getAttribute("userId");
        int exerciseId=Integer.valueOf(request.getParameter("exerciseId"));
        String exerciseSubmitTime=request.getParameter("exerciseSubmitTime");
        String exerciseSubmitLanguage=request.getParameter("exerciseSubmitLanguage");
        String exerciseCode=request.getParameter("exerciseCode");
        ExerciseHistory exerciseHistory=new ExerciseHistory();
        exerciseHistory.setExerciseCode(exerciseCode);
        exerciseHistory.setExerciseSubmitTime(exerciseSubmitTime);
        exerciseHistory.setExerciseSubmitLanguage(exerciseSubmitLanguage);
        User user=new User();
        user.setUserId(userId);
        Exercise exercise=new Exercise();
        exercise.setExerciseId(exerciseId);
        exerciseHistory.setUser(user);
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
     * 根据习题id或者用户id来查询习题记录 新增通过语言和结果查询
     * 输入exerciseId和userId
     * 输出List<ExerciseHistory>
     */
    @RequestMapping(value="/queryExerciseRealTimeStatusInfo",method = RequestMethod.POST)
    public Object queryExerciseRealTimeStatusInfo(HttpServletRequest request){
        int exerciseId=Integer.valueOf(request.getParameter("exerciseId"));
        String userName=request.getParameter("userName");
        String exerciseResult=request.getParameter("exerciseResult");
        String exerciseSubmitLanguage=request.getParameter("exerciseSubmitLanguage");
        ExerciseHistory exerciseHistory=new ExerciseHistory();
        exerciseHistory.setExerciseSubmitLanguage(exerciseSubmitLanguage);
        exerciseHistory.setExerciseResult(exerciseResult);
        Exercise exercise=new Exercise();
        exercise.setExerciseId(exerciseId);
        User user=new User();
        System.out.println(userName);
        if(userName!=null){
            user.setUserName("%"+userName+"%");
        }else{
            user.setUserName(userName);
        }
        exerciseHistory.setExercise(exercise);
        exerciseHistory.setUser(user);
        exerciseHistory.setExerciseResult(exerciseResult);
        exerciseHistory.setExerciseSubmitLanguage(exerciseSubmitLanguage);
        System.out.println(exerciseHistory.getUser().getUserName());
        System.out.println(exerciseHistory.getExerciseResult());
        System.out.println(exerciseHistory.getExerciseSubmitLanguage());
        System.out.println(exerciseHistory.getExercise().getExerciseId());
        System.out.println(exerciseHistoryService.queryExerciseRealTimeStatusInfo(exerciseHistory));
        return exerciseHistoryService.queryExerciseRealTimeStatusInfo(exerciseHistory);

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


    ////////////1111111111111111111111111111111111111111111111111111111
    /**
     * 根据习题id和用户id判断习题是否已经提交成功过
     * 输入studentId和exerciseId
     * 输出查询到的数量
     */
    @RequestMapping(value="/queryUserExerciseIsSuccess",method = RequestMethod.POST)
    public int queryUserExerciseIsSuccess(HttpServletRequest request){
        return exerciseHistoryService.queryUserExerciseIsSuccess(Integer.valueOf(request.getParameter("userId")),Integer.valueOf(request.getParameter("exerciseId")));
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
    @RequestMapping(value="/queryExerciseIdByUserId",method = RequestMethod.POST)
    public Object queryExerciseIdByUserId(HttpServletRequest request){
        return exerciseHistoryService.queryExerciseIdByUserId(Integer.valueOf(request.getParameter("userId")));
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
