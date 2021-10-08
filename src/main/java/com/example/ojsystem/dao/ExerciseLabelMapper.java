package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExerciseLabel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseLabelMapper {
    /**
     * 获取习题标签信息并添加
     * 输入exerciseLabel
     * 成功输出true 失败输出false
     */
    public int addExerciseLabelInfo(@Param("exerciseLabel") ExerciseLabel exerciseLabel);

    /**
     * 获取全部习题标签信息
     * 输入无
     * 成功输出List<ExerciseLabel>
     */
    public List<ExerciseLabel> queryExerciseLabelInfo();

    /**
     * 修改对应的习题标签信息
     * 输入exerciseLabel
     * 成功输出true 失败输出false
     */
    public int modifyExerciseLabelInfo(@Param("exerciseLabel") ExerciseLabel exerciseLabel);

    /**
     * 删除对应的习题标签信息
     * 输入exerciseLabelId
     * 成功输出true 失败输出false
     */
    public int deleteExerciseLabelInfo(@Param("exerciseLabelId") int exerciseLabelId);
}
