package com.example.ojsystem.service;

import com.example.ojsystem.entity.CompletionQuestion;

import java.util.List;

public interface CompletionQuestionService {
    /**
     * 根据输入的填空题信息添加到填空题题库中
     * 输入completionQuestion
     * 输出int
     */
    public int addCompletionQuestionInfo(CompletionQuestion completionQuestion);

    /**
     * 根据输入的填空题信息修改对应的填空题信息
     * 输入completionQuestion
     * 输出int
     */
    public int modifyCompletionQuestionInfo(CompletionQuestion completionQuestion);

    /**
     * 根据输入的填空题编号删除对应的填空题信息
     * 输入completionQuestionId
     * 输出int
     */
    public int deleteCompletionQuestionInfoByCompletionQuestionId(int completionQuestionId);

    /**
     * 根据用户来查询填空题信息
     * 输入userId
     * 输出int
     */
    public List<CompletionQuestion> queryCompletionQuestionInfoByUserId(int userId);

    /**
     * 根据输入的查询信息
     * 输入completionQuestion
     * 输出List<ChoiceQuestion>
     */
    public List<CompletionQuestion> queryCompletionQuestionIdBySearchInfo(CompletionQuestion completionQuestion,int currentUserId);

    /**
     * 根据填空题编号查询对应的填空题信息
     * 输入completionQuestion
     * 输出List<ChoiceQuestion>
     */
    public CompletionQuestion queryCompletionQuestionIdByCompletionQuestionId(int completionQuestionId);
}
