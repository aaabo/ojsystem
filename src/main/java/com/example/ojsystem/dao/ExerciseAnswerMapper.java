package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExerciseAnswer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseAnswerMapper {
    /**
     * 添加习题答案信息到数据库
     * 输入习题答案信息
     * 输出int
     */
    public int insertExerciseAnswerInfo(@Param("exerciseAnswer") ExerciseAnswer exerciseAnswer);

    /**
     * 查询全部习题答案信息
     * 输入无
     * 输出List<ExerciseAnswer>
     */
    public List<ExerciseAnswer> selectExerciseAnswerInfoByExerciseId(@Param("exerciseId")int exerciseId);

    /**
     * 修改习题答案信息
     * 输入习题答案信息
     * 输出int
     */
    public int updateExerciseAnswerInfo(@Param("exerciseAnswer")ExerciseAnswer exerciseAnswer);

    /**
     * 删除习题答案信息
     * 输入习题答案信息id
     * 输出int
     */
    public int deleteExerciseAnswer(@Param("exerciseAnswerId") int exerciseAnswerId);
}
