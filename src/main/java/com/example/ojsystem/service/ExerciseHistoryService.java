package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExerciseHistory;
import com.example.ojsystem.entity.ResultTool;

import java.util.List;

public interface ExerciseHistoryService {
    /**
     * 根据提交的代码 添加习题记录
     * 输入exerciseHistory
     * 输出int
     */
    public int saveCodeInfo(ExerciseHistory exerciseHistory);

    /**
     * 根据习题id或者用户id来查询习题记录 新增通过语言和结果查询
     * 输入exerciseHistory
     * 输出List<ExerciseHistory>
     */
    public List<ExerciseHistory> checkExerciseRealTimeStatusInfo(ExerciseHistory exerciseHistory);

    /**
     * 根据习题id来查询习题的排行
     * 输入exerciseId
     * 输出List<ExerciseHistory>
     */
    public List<ExerciseHistory> checkExerciseStatisticsInfo(int exerciseId);

    /**
     * 根据习题id和用户id判断习题是否已经提交成功
     * 输入userId和exerciseId
     * 输出查询到的数量
     */
    public int checkUserExerciseIsSuccess(int studentId,int exerciseId);

    /**
     * 根据习题记录id查询提交代码
     * 输入exerciseHistoryId
     * 输出查到的代码信息
     */
    public String checkCodeInfoByExerciseHistoryId(int exerciseHistoryId);


    /**
     * 根据用户id查询提交过但未通过的习题
     * 输入userId
     * 输出查到的习题id
     */
    public List<Integer>  checkExerciseIdByUserId(int userId);

    /**
     * 根据习题id查询习题结果信息
     * 输入exerciseId
     * 输出查到的习题结果信息
     */
    public List<ResultTool> checkExerciseResultInfo(int exerciseId);

}
