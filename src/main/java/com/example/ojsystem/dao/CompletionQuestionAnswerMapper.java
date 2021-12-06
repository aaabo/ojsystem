package com.example.ojsystem.dao;

import com.example.ojsystem.entity.CompletionQuestion;
import com.example.ojsystem.entity.CompletionQuestionAnswer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompletionQuestionAnswerMapper {
    /**
     * 根据输入的填空题答案信息添加填空题答案
     * 输入completionQuestionAnswer,completionQuestionId
     * 输出int
     */
    public int insertCompletionQuestionAnswerInfo(@Param("completionQuestionAnswer") CompletionQuestionAnswer completionQuestionAnswer,@Param("completionQuestionId") int completionQuestionId);


    /**
     * 根据填空题编号删除对应的填空题答案信息
     * 输入completionQuestionId
     * 输出int
     */
    public int deleteCompletionQuestionAnswerInfoByCompletionQuestionId(@Param("completionQuestionId") int completionQuestionId);

    /**
     * 根据填空题编号查询对应的答案信息
     * 输入completionQuestionId
     * 输出Answer
     */
    public String selectCompletionQuestionAnswerInfoByCompletionQuestionId(@Param("completionQuestionId") int completionQuestionId,@Param("completionQuestionAnswerNumber") int completionQuestionAnswerNumber);
}
