package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.CompletionQuestionAnswerMapper;
import com.example.ojsystem.entity.CompletionQuestion;
import com.example.ojsystem.entity.CompletionQuestionAnswer;
import com.example.ojsystem.service.CompletionQuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompletionQuestionAnswerServiceImpl implements CompletionQuestionAnswerService{
    @Autowired
    CompletionQuestionAnswerMapper completionQuestionAnswerMapper;

    /**
     * 根据输入的填空题答案信息添加填空题答案
     * 输入completionQuestionAnswer,completionQuestionId
     * 输出int
     *
     * @param completionQuestionAnswer
     * @param completionQuestionId
     */
    public int saveCompletionQuestionAnswerInfo(CompletionQuestionAnswer completionQuestionAnswer, int completionQuestionId) {
        return completionQuestionAnswerMapper.insertCompletionQuestionAnswerInfo(completionQuestionAnswer,completionQuestionId);
    }

    /**
     * 根据填空题编号删除对应的填空题答案信息
     * 输入completionQuestionId
     * 输出int
     *
     * @param completionQuestionId
     */
    public int cancelCompletionQuestionAnswerInfoByCompletionQuestionId(int completionQuestionId) {
        return completionQuestionAnswerMapper.deleteCompletionQuestionAnswerInfoByCompletionQuestionId(completionQuestionId);
    }
}
