package com.example.ojsystem.service;

import com.example.ojsystem.entity.Exercise;

import java.util.List;

public interface ExerciseService {
    /**
     * 根据添加习题信息到数据库
     * 输入习题信息
     * 输出int
     */
    public int addExercise(Exercise exercise);

    /**
     * 查询全部习题信息
     * 输入无
     * 输出List<Exercise>
     */
    public List<Exercise> queryExerciseInfo();


    /**
     * 修改选中的习题信息
     * 输入exercise
     * 输出int
     */
    public int modifyExerciseInfo(Exercise exercise);

    /**
     * 删除选中的习题信息
     * 输入exerciseId
     * 输出int
     */
    public int deleteExercise(int exerciseId);

    /**
     * 查询选择的习题详情
     * 输入exerciseId
     * 输出Exercise
     *
     */
    public Exercise queryExerciseDetailsInfoByExerciseId(int exerciseId);


}
