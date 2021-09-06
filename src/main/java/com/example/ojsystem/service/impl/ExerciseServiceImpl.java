package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExerciseMapper;
import com.example.ojsystem.entity.Exercise;
import com.example.ojsystem.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    @Autowired
    ExerciseMapper exerciseMapper;
    /**
     * 根据添加习题信息到数据库
     * 输入习题信息
     * 输出int
     *
     * @param exercise
     */
    public int addExercise(Exercise exercise) {
        return exerciseMapper.addExercise(exercise);
    }

    /**
     * 查询全部习题信息
     * 输入无
     * 输出List<Exercise>
     */
    public List<Exercise> queryExerciseInfo() {
        return exerciseMapper.queryExerciseInfo();
    }

    /**
     * 修改选中的习题信息
     * 输入exercise
     * 输出int
     *
     * @param exercise
     */
    public int modifyExerciseInfo(Exercise exercise) {
        return exerciseMapper.modifyExerciseInfo(exercise);
    }

    /**
     * 删除选中的习题信息
     * 输入exerciseId
     * 输出int
     *
     * @param exerciseId
     */
    public int deleteExercise(int exerciseId) {
        return exerciseMapper.deleteExercise(exerciseId);
    }

    /**
     * 查询选择的习题详情
     * 输入exerciseId
     * 输出Exercise
     *
     * @param exerciseId
     */
    public Exercise queryExerciseDetailsInfoByExerciseId(int exerciseId) {
        return exerciseMapper.queryExerciseDetailsInfoByExerciseId(exerciseId);
    }
}
