package com.example.ojsystem.service;

import com.example.ojsystem.entity.Exercise;

import java.util.List;

public interface ExerciseService {
    /**
     * 根据添加习题信息到数据库
     * 输入习题信息
     * 输出int
     */
    public int saveExerciseInfo(Exercise exercise);

    /**
     * 查询全部不在考试中习题信息
     * 输入无
     * 输出List<Exercise>
     */
    public List<Exercise> checkExerciseInfo();

    /**
     * 查询全部的习题信息并判断对应用户的做题情况
     * 输入无
     * 输出List<Exercise>
     */
    /**
     * 查询全部不在考试中习题信息
     * 输入无
     * 输出List<Exercise>
     */
    public List<Exercise> queryExerciseInfoAndPersonSubmitStatus(Integer userId);

    /**
     * 根据习题id查询习题信息是否存在
     * 输入exerciseId
     * 输出int
     */
    public Boolean checkExerciseInfoIsExit(int exerciseId);


    /**
     * 修改选中的习题信息
     * 输入exercise
     * 输出int
     */
    public int alterExerciseInfo(Exercise exercise);

    /**
     * 删除选中的习题信息
     * 输入exerciseId
     * 输出int
     */
    public int cancelExerciseInfo(int exerciseId);

    /**
     * 查询选择的习题详情
     * 输入exerciseId
     * 输出Exercise
     *
     */
    public Exercise checkExerciseDetailsInfoByExerciseId(int exerciseId);

    /**
     * 根据习题标签查询对应的习题信息
     * 输入labelIds
     * 输出List<Exercise>
     *
     */
//    public List<Exercise> queryExerciseInfoByFirstPoint(List<Label> labels);

    /**
     * 根据输入exerciseId判断是否在考试或测试中
     * 输入exerciseId
     * 输出true 或者false
     */
    public Boolean checkExerciseIsExamByExerciseId(int exerciseId);

}
