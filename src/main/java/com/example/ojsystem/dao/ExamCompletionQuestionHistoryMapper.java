package com.example.ojsystem.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamCompletionQuestionHistoryMapper {
    /**
     * 根据用户提交的填空题信息添加填空题记录
     * 输入userId,examQuestionId
     * 输出int
     */
    public int addExamCompletionQuestionHistoryInfo(@Param("userId") int userId,@Param("examQuestionId") int examQuestionId);

}
