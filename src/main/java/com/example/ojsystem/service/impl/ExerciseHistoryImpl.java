package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExerciseHistoryMapper;
import com.example.ojsystem.entity.ExerciseHistory;
import com.example.ojsystem.service.ExerciseHistoryService;
import com.example.ojsystem.entity.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseHistoryImpl implements ExerciseHistoryService{
    @Autowired
    ExerciseHistoryMapper exerciseHistoryMapper;
    /**
     * 根据提交的代码 添加习题记录
     * 输入exerciseHistory
     * 输出int
     *
     * @param exerciseHistory
     */
    public int addCodeInfo(ExerciseHistory exerciseHistory) {
        return exerciseHistoryMapper.addCodeInfo(exerciseHistory);
    }

    /**
     * 根据习题id或者学生id来查询习题记录 新增通过语言和结果查询
     * 输入exerciseHistory
     * 输出List<ExerciseHistory>
     *
     * @param exerciseHistory
     */
    public List<ExerciseHistory> queryExerciseRealTimeStatusInfo(ExerciseHistory exerciseHistory) {

        return exerciseHistoryMapper.queryExerciseRealTimeStatusInfo(exerciseHistory);
    }

    /**
     * 根据习题id来查询习题的排行
     * 输入exerciseId
     * 输出List<ExerciseHistory>
     *
     * @param exerciseId
     */
    public List<ExerciseHistory> queryExerciseStatisticsInfo(int exerciseId) {
        return exerciseHistoryMapper.queryExerciseStatisticsInfo(exerciseId);
    }

    /**
     * 根据习题id和学生id判断习题是否已经提交成功
     * 输入studentId和exerciseId
     * 输出查询到的数量
     *
     * @param studentId
     * @param exerciseId
     */
    public int queryStudentExerciseIsSuccess(int studentId, int exerciseId) {
        return exerciseHistoryMapper.queryStudentExerciseIsSuccess(studentId,exerciseId);
    }

    /**
     * 根据习题记录id查询提交代码
     * 输入exerciseHistoryId
     * 输出查到的代码信息
     *
     * @param exerciseHistoryId
     */
    public String queryCodeInfoByExerciseHistoryId(int exerciseHistoryId) {
        return exerciseHistoryMapper.queryCodeInfoByExerciseHistoryId(exerciseHistoryId);
    }

    /**
     * 根据学生id查询提交过但未通过的习题
     * 输入studentId
     * 输出查到的习题id
     *
     * @param studentId
     */
    public List<Integer>  queryExerciseIdByStudentId(int studentId) {
        return exerciseHistoryMapper.queryExerciseIdByStudentId(studentId);
    }

    /**
     * 根据习题id查询结果信息
     * 输入exerciseId
     * 输出查到的习题结果信息
     *
     * @param exerciseId
     */
    public List<ResultTool> queryExerciseResultInfo(int exerciseId) {
        return exerciseHistoryMapper.queryExerciseResultInfo(exerciseId);
    }
}
