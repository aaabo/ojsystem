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
     * 输入choiceQuestionId
     * 输出int
     */
    public List<ChoiceQuestion> queryChoiceQuestionInfo(int userId);
}
