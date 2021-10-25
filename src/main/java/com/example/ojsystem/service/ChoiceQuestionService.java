package com.example.ojsystem.service;


import com.example.ojsystem.entity.ChoiceQuestion;

import java.util.List;

public interface ChoiceQuestionService {
    /**
     * 根据输入的选择题信息添加到选择题题库中
     * 输入choiceQuestion
     * 输出int
     */
    public int addChoiceQuestionInfo(ChoiceQuestion choiceQuestion);

    /**
     * 根据输入的选择题信息修改对应的选择题
     * 输入choiceQuestion
     * 输出int
     */
    public int modifyChoiceQuestionInfo(ChoiceQuestion choiceQuestion);

    /**
     * 查询自己私有创建的选择题目和共有的选择题目
     * 输入userId
     * 输出List<ChoiceQuestion>
     */
    public List<ChoiceQuestion> queryChoiceQuestionInfo(int userId);

    /**
     * 根据选择题id删除对应的选择题
     * 输入choiceQuestionId
     * 输出int
     */
    public int deleteChoiceQuestionInfoByChoiceQuestionId(int choiceQuestionId);

    /**
     * 根据输入的查询信息
     * 输入choiceQuestion
     * 输出List<ChoiceQuestion>
     */
    public List<ChoiceQuestion> queryChoiceQuestionIdBySearchInfo(ChoiceQuestion choiceQuestion,int currentUserId);

    /**
     * 根据输入的选择题编号查询选择题信息
     * 输入choiceQuestionId
     * 输出ChoiceQuestion
     */
    public ChoiceQuestion queryChoiceQuestionInfoByChoiceQuestionId(int choiceQuestionId);
}
