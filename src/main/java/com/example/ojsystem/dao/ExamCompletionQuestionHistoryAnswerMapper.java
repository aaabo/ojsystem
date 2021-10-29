package com.example.ojsystem.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamCompletionQuestionHistoryAnswerMapper {
    /**
     * 根据用户提交的填空题回答添加填空题答案记录
     * 输入examQuestionHistoryId,examCompletionQuestionUserAnswer,examCompletionQuestionUserAnswerNumber
     * 输出int
     */
    public int addExamCompletionQuestionAnswerHistoryInfo(@Param("examQuestionHistoryId") int examQuestionHistoryId, @Param("examCompletionQuestionUserAnswer") String examCompletionQuestionUserAnswer, @Param("examCompletionQuestionUserAnswerNumber")int examCompletionQuestionUserAnswerNumber);
}
