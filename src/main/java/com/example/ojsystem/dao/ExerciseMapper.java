package com.example.ojsystem.dao;

import com.example.ojsystem.entity.Exercise;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseMapper {
    /**
     * 根据添加习题信息到数据库
     * 输入习题信息
     * 输出int
     */
    public int addExercise(@Param("exercise") Exercise exercise);

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
    public int modifyExerciseInfo(@Param("exercise") Exercise exercise);


    /**
     * 删除选中的习题信息
     * 输入exerciseId
     * 输出int
     */
    public int deleteExercise(@Param("exerciseId") int exerciseId);


    /**
     * 查询选择的习题详情
     * 输入exerciseId
     * 输出Exercise
     */
    public Exercise queryExerciseDetailsInfoByExerciseId(@Param("exerciseId") int exerciseId);

    /**
     * 根据习题标签查询对应的习题信息
     * 输入labelIds
     * 输出List<Exercise>
     *
     */
//    public List<Exercise> queryExerciseInfoByLabelIds(@Param("labels") List<Label> labels,@Param("number") int number);
}
