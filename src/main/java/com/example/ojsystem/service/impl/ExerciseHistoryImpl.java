package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExerciseAnswerMapper;
import com.example.ojsystem.dao.ExerciseHistoryMapper;
import com.example.ojsystem.entity.ExerciseHistory;
import com.example.ojsystem.judger.JudgerC;
import com.example.ojsystem.service.ExerciseHistoryService;
import com.example.ojsystem.entity.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseHistoryImpl implements ExerciseHistoryService{
    @Autowired
    ExerciseHistoryMapper exerciseHistoryMapper;
    @Autowired
    ExerciseAnswerMapper exerciseAnswerMapper;
    /**
     * 根据提交的代码 添加习题记录
     * 输入exerciseHistory
     * 输出int
     *
     * @param exerciseHistory
     */
    public int saveCodeInfo(ExerciseHistory exerciseHistory) {
        String result= JudgerC.start(exerciseHistory.getExerciseCode(),exerciseAnswerMapper.selectExerciseAnswerInfoByExerciseId(exerciseHistory.getExercise().getExerciseId()));
        exerciseHistory.setExerciseResult(result);
        return exerciseHistoryMapper.insertCodeInfo(exerciseHistory);
    }

    /**
     * 根据习题id或者用户id来查询习题记录 新增通过语言和结果查询
     * 输入exerciseHistory
     * 输出List<ExerciseHistory>
     *
     * @param exerciseHistory
     */
    public List<ExerciseHistory> checkExerciseRealTimeStatusInfo(ExerciseHistory exerciseHistory) {

        return exerciseHistoryMapper.selectExerciseRealTimeStatusInfo(exerciseHistory);
    }

    /**
     * 根据习题id来查询习题的排行
     * 输入exerciseId
     * 输出List<ExerciseHistory>
     *
     * @param exerciseId
     */
    public List<ExerciseHistory> checkExerciseStatisticsInfo(int exerciseId) {
        return exerciseHistoryMapper.selectExerciseStatisticsInfo(exerciseId);
    }

    /**
     * 根据习题id和用户id判断习题是否已经提交成功
     * 输入userId和exerciseId
     * 输出查询到的数量
     *
     * @param userId
     * @param exerciseId
     */
    public int checkUserExerciseIsSuccess(int userId, int exerciseId) {
        return exerciseHistoryMapper.selectUserExerciseIsSuccess(userId,exerciseId);
    }

    /**
     * 根据习题记录id查询提交代码
     * 输入exerciseHistoryId
     * 输出查到的代码信息
     *
     * @param exerciseHistoryId
     */
    public String checkCodeInfoByExerciseHistoryId(int exerciseHistoryId) {
        return exerciseHistoryMapper.selectCodeInfoByExerciseHistoryId(exerciseHistoryId);
    }

    /**
     * 根据用户id查询提交过但未通过的习题
     * 输入userId
     * 输出查到的习题id
     *
     * @param userId
     */
    public List<Integer>  checkExerciseIdByUserId(int userId) {
        return exerciseHistoryMapper.selectExerciseIdByUserId(userId);
    }

    /**
     * 根据习题id查询结果信息
     * 输入exerciseId
     * 输出查到的习题结果信息
     *
     * @param exerciseId
     */
    public List<ResultTool> checkExerciseResultInfo(int exerciseId) {
        return exerciseHistoryMapper.selectExerciseResultInfo(exerciseId);
    }
}
