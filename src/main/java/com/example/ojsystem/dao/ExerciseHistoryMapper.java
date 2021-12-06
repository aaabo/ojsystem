package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExerciseHistory;
import com.example.ojsystem.entity.ResultTool;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseHistoryMapper {
    /**
     * 根据提交的代码 添加习题记录
     * 输入exerciseHistory
     * 输出int
     */
    public int insertCodeInfo(@Param("exerciseHistory") ExerciseHistory exerciseHistory);

    /**
     * 根据习题id或者用户id来查询习题记录 新增通过语言和结果查询
     * 输入exerciseHistory
     * 输出List<ExerciseHistory>
     */
    public List<ExerciseHistory> selectExerciseRealTimeStatusInfo(@Param("exerciseHistory") ExerciseHistory exerciseHistory);

    /**
     * 根据习题id来查询习题的排行
     * 输入exerciseId
     * 输出List<ExerciseHistory>
     */
    public List<ExerciseHistory> selectExerciseStatisticsInfo(@Param("exerciseId") int exerciseId);

    /**
     * 根据习题id和用户id判断习题是否已经提交成功
     * 输入userId和exerciseId
     * 输出查询到的数量
     */
    public int selectUserExerciseIsSuccess(@Param("userId") int userId,@Param("exerciseId") int exerciseId);

    /**
     * 根据习题记录id查询提交代码
     * 输入exerciseHistoryId
     * 输出查到的代码信息
     */
    public String selectCodeInfoByExerciseHistoryId(@Param("exerciseHistoryId") int exerciseHistoryId);

    /**
     * 根据学生id查询提交过但未通过的习题
     * 输入studentId
     * 输出查到的习题id
     */
    public List<Integer>   selectExerciseIdByUserId(@Param("userId") int userId);

    /**
     * 根据习题id查询习题结果信息
     * 输入exerciseId
     * 输出查到的习题结果信息
     */
    public List<ResultTool> selectExerciseResultInfo(@Param("exerciseId") int exerciseId);
}
