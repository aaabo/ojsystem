package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExamProgrammingQuestionHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamProgrammingQuestionHistoryMapper {
    /**
     * 根据学生id和考试编程信息添加考试编程题记录
     * 输入examProgrammingHistory
     * 输出int
     */
    public int addExamProgrammingQuestionHistory(@Param("examProgrammingQuestionHistory") ExamProgrammingQuestionHistory examProgrammingQuestionHistory);


}
