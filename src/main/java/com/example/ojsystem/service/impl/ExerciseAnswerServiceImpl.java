package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExerciseAnswerMapper;
import com.example.ojsystem.entity.ExerciseAnswer;
import com.example.ojsystem.service.ExerciseAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseAnswerServiceImpl implements ExerciseAnswerService{

    @Autowired
    ExerciseAnswerMapper exerciseAnswerMapper;
    /**
     * 添加习题答案信息到数据库
     * 输入习题答案信息
     * 输出int
     *
     * @param exerciseAnswer
     */
    public int saveExerciseAnswerInfo(ExerciseAnswer exerciseAnswer) {
        return exerciseAnswerMapper.insertExerciseAnswerInfo(exerciseAnswer);
    }

    /**
     * 查询全部习题答案信息
     * 输入无
     * 输出List<ExerciseAnswer>
     */
    public List<ExerciseAnswer> checkExerciseAnswerInfoByExerciseId(int exerciseId) {
        return exerciseAnswerMapper.selectExerciseAnswerInfoByExerciseId(exerciseId);
    }

    /**
     * 修改习题答案信息
     * 输入习题答案信息
     * 输出int
     *
     * @param exerciseAnswer
     */
    public int alterExerciseAnswerInfo(ExerciseAnswer exerciseAnswer) {
        return exerciseAnswerMapper.updateExerciseAnswerInfo(exerciseAnswer);
    }

    /**
     * 删除习题答案信息
     * 输入习题答案信息id
     * 输出int
     *
     * @param exerciseAnswerId
     */
    public int cancelExerciseAnswer(int exerciseAnswerId) {
        return exerciseAnswerMapper.deleteExerciseAnswer(exerciseAnswerId);
    }
}
