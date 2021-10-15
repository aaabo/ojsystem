package com.example.ojsystem.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseLabelMapper {
    /**
     * 获取习题列表信息并添加
     * 输入exerciseId和labelId
     * 成功输入true 失败输出false
     */
    public int addExerciseLabelInfo(@Param("exerciseId") int exerciseId,@Param("labelId") int labelId);

    /**
     * 删除对应的习题列表信息
     * 输入exerciseId
     * 成功输入true 失败输出false
     */
    public int deleteExerciseLabelInfoByExerciseId(@Param("exerciseId") int exerciseId);
}
