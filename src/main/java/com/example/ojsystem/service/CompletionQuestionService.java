package com.example.ojsystem.service;

import com.example.ojsystem.entity.ChoiceQuestion;
import com.example.ojsystem.entity.CompletionQuestion;

import java.util.List;

public interface CompletionQuestionService {
    /**
     * 根据输入的填空题信息添加到填空题题库中
     * 输入completionQuestion
     * 输出int
     */
    public int saveCompletionQuestionInfo(CompletionQuestion completionQuestion);

    /**
     * 根据输入的填空题信息修改对应的填空题信息
     * 输入completionQuestion
     * 输出int
     */
    public int alterCompletionQuestionInfo(CompletionQuestion completionQuestion);

    /**
     * 根据输入的填空题编号删除对应的填空题信息
     * 输入completionQuestionId
     * 输出int
     */
    public int cancelCompletionQuestionInfoByCompletionQuestionId(int completionQuestionId);

    /**
     * 根据用户来查询填空题信息
     * 输入userId
     * 输出int
     */
    public List<CompletionQuestion> checkCompletionQuestionInfoByUserId(int userId);

    /**
     * 根据输入的查询信息
     * 输入completionQuestion
     * 输出List<ChoiceQuestion>
     */
    public List<CompletionQuestion> checkCompletionQuestionBySearchInfo(CompletionQuestion completionQuestion,int currentUserId);

    /**
     * 根据填空题编号查询对应的填空题信息
     * 输入completionQuestion
     * 输出List<ChoiceQuestion>
     */
    public CompletionQuestion checkCompletionQuestionIdByCompletionQuestionId(int completionQuestionId);

    /**
     * 根据输入的考试编号查询考试填空题信息
     * 输入examId
     * 输出List<CompletionQuestion>
     */
    public List<CompletionQuestion> checkCompletionQuestionInfoByExamId(int examId);

    /**
     * 根据输入completionQuestionId判断是否在考试或测试中
     * 输入completionQuestionId
     * 输出true 或者false
     */
    public Boolean checkCompletionQuestionIsExamByCompletionQuestionId(int completionQuestionId);
}
