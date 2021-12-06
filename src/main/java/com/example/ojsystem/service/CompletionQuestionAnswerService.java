package com.example.ojsystem.service;

import com.example.ojsystem.entity.CompletionQuestion;
import com.example.ojsystem.entity.CompletionQuestionAnswer;

import java.util.List;

public interface CompletionQuestionAnswerService {
    /**
     * 根据输入的填空题答案信息添加填空题答案
     * 输入completionQuestionAnswer,completionQuestionId
     * 输出int
     */
    public int saveCompletionQuestionAnswerInfo(CompletionQuestionAnswer completionQuestionAnswer, int completionQuestionId);

    /**
     * 根据填空题编号删除对应的填空题答案信息
     * 输入completionQuestionId
     * 输出int
     */
    public int cancelCompletionQuestionAnswerInfoByCompletionQuestionId(int completionQuestionId);
}
