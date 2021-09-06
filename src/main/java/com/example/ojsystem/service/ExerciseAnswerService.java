package com.example.ojsystem.service;

import com.example.ojsystem.entity.Exercise;
import com.example.ojsystem.entity.ExerciseAnswer;

import java.util.List;

public interface ExerciseAnswerService {
    /**
     * 添加习题答案信息到数据库
     * 输入习题答案信息
     * 输出int
     */
    public int addExerciseAnswer(ExerciseAnswer exerciseAnswer);


    /**
     * 查询全部习题答案信息
     * 输入无
     * 输出List<ExerciseAnswer>
     */
    public List<ExerciseAnswer> queryExerciseAnswerInfoByExerciseId(int exerciseId);


    /**
     * 修改习题答案信息
     * 输入习题答案信息
     * 输出int
     */
    public int modifyExerciseAnswerInfo(ExerciseAnswer exerciseAnswer);

    /**
     * 删除习题答案信息
     * 输入习题答案信息id
     * 输出int
     */
    public int deleteExerciseAnswer(int exerciseAnswerId);

}
