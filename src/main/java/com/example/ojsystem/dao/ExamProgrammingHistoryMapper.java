package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExamProgrammingHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamProgrammingHistoryMapper {
    /**
     * 根据学生id和考试编程信息添加考试编程题记录
     * 输入examProgrammingHistory
     * 输出int
     */
    public int addExamProgrammingHistory(@Param("examProgrammingHistory") ExamProgrammingHistory examProgrammingHistory);
}
