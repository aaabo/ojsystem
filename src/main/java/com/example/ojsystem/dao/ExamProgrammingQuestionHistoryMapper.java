package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExamProgrammingQuestionHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamProgrammingQuestionHistoryMapper {
    /**
     * 提交的编程题信息添加考试编程题记录
     * 输入examProgrammingHistory
     * 输出int
     */
    public int insertExamProgrammingQuestionHistory(@Param("examProgrammingQuestionHistory") ExamProgrammingQuestionHistory examProgrammingQuestionHistory);

    /**
     * 查看用户是否提交过考试编程题记录
     * 输入examQuestionId,userId
     * 输出examProgrammingQuestionId
     */
    public int selectExamProgrammingQuestionHistoryByExamQuestionIdAndUserId(@Param("examQuestionId") int examQuestionId,@Param("userId") int userId);


    /**
     * 提交的编程题信息修改考试编程题记录
     * 输入examProgrammingHistory
     * 输出int
     */
    public int updateExamProgrammingQuestionHistoryByExamProgrammingQuestionId(@Param("examProgrammingQuestionHistory") ExamProgrammingQuestionHistory examProgrammingQuestionHistory);

}
