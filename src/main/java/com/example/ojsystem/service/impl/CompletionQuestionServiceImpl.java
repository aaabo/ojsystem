package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.CompletionQuestionMapper;
import com.example.ojsystem.entity.CompletionQuestion;
import com.example.ojsystem.service.CompletionQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompletionQuestionServiceImpl implements CompletionQuestionService{
    @Autowired
    CompletionQuestionMapper completionQuestionMapper;
    /**
     * 根据输入的填空题信息添加到填空题题库中
     * 输入completionQuestion
     * 输出int
     *
     * @param completionQuestion
     */
    public int addCompletionQuestionInfo(CompletionQuestion completionQuestion) {
        return completionQuestionMapper.addCompletionQuestionInfo(completionQuestion);
    }

    /**
     * 根据输入的填空题信息修改对应的填空题信息
     * 输入completionQuestion
     * 输出int
     *
     * @param completionQuestion
     */
    public int modifyCompletionQuestionInfo(CompletionQuestion completionQuestion) {
        return completionQuestionMapper.modifyCompletionQuestionInfo(completionQuestion);
    }

    /**
     * 根据输入的填空题编号删除对应的填空题信息
     * 输入completionQuestionId
     * 输出int
     *
     * @param completionQuestionId
     */
    public int deleteCompletionQuestionInfoByCompletionQuestionId(int completionQuestionId) {
        return completionQuestionMapper.deleteCompletionQuestionInfoByCompletionQuestionId(completionQuestionId);
    }

    /**
     * 根据用户来查询填空题信息
     * 输入userId
     * 输出int
     *
     * @param userId
     */
    public List<CompletionQuestion> queryCompletionQuestionInfoByUserId(int userId) {
        return completionQuestionMapper.queryCompletionQuestionInfoByUserId(userId);
    }
}
