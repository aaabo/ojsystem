package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExerciseLabelMapper;
import com.example.ojsystem.dao.ExerciseMapper;
import com.example.ojsystem.dao.LabelMapper;
import com.example.ojsystem.entity.Exercise;
import com.example.ojsystem.entity.Label;
import com.example.ojsystem.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    @Autowired
    ExerciseMapper exerciseMapper;
    @Autowired
    ExerciseLabelMapper exerciseLabelMapper;
    @Autowired
    LabelMapper labelMapper;
    /**
     * 根据添加习题信息到数据库
     * 输入习题信息
     * 输出int
     *
     * @param exercise
     */
    public int addExercise(Exercise exercise) {
        int i=0;
        i=exerciseMapper.addExercise(exercise);
        for(int o=0;o<exercise.getLabels().size();o++){
            exerciseLabelMapper.addExerciseLabelInfo(exercise.getExerciseId(),exercise.getLabels().get(o).getLabelId());
        }
        return i;
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
        //先删除原来的
        exerciseLabelMapper.deleteExerciseLabelInfoByExerciseId(exercise.getExerciseId());
        //再添加新的
        for(int o=0;o<exercise.getLabels().size();o++){
            exerciseLabelMapper.addExerciseLabelInfo(exercise.getExerciseId(),exercise.getLabels().get(o).getLabelId());
        }
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

    /**
     * 根据习题标签查询对应的习题信息
     * 输入labelIds
     * 输出List<Exercise>
     *
     * @param labels
     */
    public List<Exercise> queryExerciseInfoByFirstPoint(List<Label> labels) {
        for(int i=0;i<labels.size();i++){
            labels.get(i).setLabelId(labelMapper.queryLabelIdBySecondPoint(labels.get(i).getSecondPoint()));
        }
        return exerciseMapper.queryExerciseInfoByLabelIds(labels,labels.size());
    }
}
