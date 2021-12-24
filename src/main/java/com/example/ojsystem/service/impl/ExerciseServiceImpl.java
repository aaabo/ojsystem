package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExerciseLabelMapper;
import com.example.ojsystem.dao.ExerciseMapper;
import com.example.ojsystem.entity.Exercise;
import com.example.ojsystem.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    @Autowired
    ExerciseMapper exerciseMapper;
    @Autowired
    ExerciseLabelMapper exerciseLabelMapper;
    /**
     * 根据添加习题信息到数据库
     * 输入习题信息
     * 输出int
     *
     * @param exercise
     */
    public int saveExerciseInfo(Exercise exercise) {
        int exerciseId=0;
        exerciseId=exerciseMapper.insertExerciseInfo(exercise);
        int i=0;
        i=exerciseLabelMapper.insertExerciseLabelInfo(exercise.getExerciseId(),exercise.getQuestionLabel().getQuestionLabelId());
        if(i!=0){
            return exerciseId;
        }else{
            return 0;
        }
    }

    /**
     * 查询全部习题信息
     * 输入无
     * 输出List<Exercise>
     */
    public List<Exercise> checkExerciseInfo() {

        List<Exercise> exercises=new ArrayList<Exercise>();
        exercises=exerciseMapper.selectExerciseInfo();
        for(int i=0;i<exercises.size();i++){
            Exercise exercise=exercises.get(i);
            Integer o=exerciseMapper.selectExerciseIsExamByExerciseId(exercise.getExerciseId());
            if(o!=null){
                exercise.setIsExam(true);
            }else{
                exercise.setIsExam(false);
            }
        }
        return exercises;
    }

    /**
     * 根据习题id查询习题信息是否存在
     * 输入exerciseId
     * 输出int
     *
     * @param exerciseId
     */
    public Boolean checkExerciseInfoIsExit(int exerciseId) {
        Integer i= exerciseMapper.selectExerciseInfoIsExit(exerciseId);
        if(i!=null){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 修改选中的习题信息
     * 输入exercise
     * 输出int
     *
     * @param exercise
     */
    public int alterExerciseInfo(Exercise exercise) {
        int i=0;
        //先删除原来的
        i=exerciseLabelMapper.deleteExerciseLabelInfoByExerciseId(exercise.getExerciseId());
        //再添加新的
        if(i!=0){
            i=exerciseLabelMapper.insertExerciseLabelInfo(exercise.getExerciseId(),exercise.getQuestionLabel().getQuestionLabelId());
        }
        if(i!=0){
            i=exerciseMapper.updateExerciseInfo(exercise);
        }


        return i;
    }

    /**
     * 删除选中的习题信息
     * 输入exerciseId
     * 输出int
     *
     * @param exerciseId
     */
    public int cancelExerciseInfo(int exerciseId) {
        return exerciseMapper.deleteExerciseInfo(exerciseId);
    }

    /**
     * 查询选择的习题详情
     * 输入exerciseId
     * 输出Exercise
     *
     * @param exerciseId
     */
    public Exercise checkExerciseDetailsInfoByExerciseId(int exerciseId) {
        return exerciseMapper.selectExerciseDetailsInfoByExerciseId(exerciseId);
    }

    /**
     * 根据输入exerciseId判断是否在考试或测试中
     * 输入exerciseId
     * 输出true 或者false
     *
     * @param exerciseId
     */
    public Boolean checkExerciseIsExamByExerciseId(int exerciseId) {
        Integer i=exerciseMapper.selectExerciseIsExamByExerciseId(exerciseId);
        if(i!=null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 根据习题标签查询对应的习题信息
     * 输入labelIds
     * 输出List<Exercise>
     *
     * @param labels
     */
//    public List<Exercise> queryExerciseInfoByFirstPoint(List<Label> labels) {
//        List<Exercise> exercises=new ArrayList<Exercise>();
//        List<Exercise> exercises2=new ArrayList<Exercise>();
//        for(int i=0;i<labels.size();i++){
//            labels.get(i).setLabelId(labelMapper.queryLabelIdBySecondPoint(labels.get(i).getSecondPoint()));
//        }
//        exercises=exerciseMapper.queryExerciseInfoByLabelIds(labels,labels.size());
//        for(int i=0;i<exercises.size();i++){
//            exercises2.add(exerciseMapper.queryExerciseDetailsInfoByExerciseId(exercises.get(i).getExerciseId()));
//        }
//        return exercises2;
//    }
}
