package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExerciseLabelMapper;
import com.example.ojsystem.entity.ExerciseLabel;
import com.example.ojsystem.service.ExerciseLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseLabelServiceImpl implements ExerciseLabelService{
    @Autowired
    ExerciseLabelMapper exerciseLabelMapper;

    /**
     * 获取习题标签信息并添加
     * 输入exerciseLabel
     * 成功输出true 失败输出false
     *
     * @param exerciseLabel
     */
    public int addExerciseLabelInfo(ExerciseLabel exerciseLabel) {
        return exerciseLabelMapper.addExerciseLabelInfo(exerciseLabel);
    }

    /**
     * 获取全部习题标签信息
     * 输入无
     * 成功输出List<ExerciseLabel>
     */
    public List<ExerciseLabel> queryExerciseLabelInfo() {
        return exerciseLabelMapper.queryExerciseLabelInfo();
    }

    /**
     * 修改对应的习题标签信息
     * 输入exerciseLabel
     * 成功输出true 失败输出false
     *
     * @param exerciseLabel
     */
    public int updateExerciseLabelInfo(ExerciseLabel exerciseLabel) {
        return exerciseLabelMapper.updateExerciseLabelInfo(exerciseLabel);
    }

    /**
     * 删除对应的习题标签信息
     * 输入exerciseLabelId
     * 成功输出true 失败输出false
     *
     * @param exerciseLabelId
     */
    public int deleteExerciseLabelInfo(int exerciseLabelId) {
        return exerciseLabelMapper.deleteExerciseLabelInfo(exerciseLabelId);
    }
}
