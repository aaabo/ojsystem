package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ChoiceQuestionLabelMapper;
import com.example.ojsystem.dao.ChoiceQuestionMapper;
import com.example.ojsystem.entity.ChoiceQuestion;
import com.example.ojsystem.service.ChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService{
    @Autowired
    ChoiceQuestionMapper choiceQuestionMapper;
    @Autowired
    ChoiceQuestionLabelMapper choiceQuestionLabelMapper;

    /**
     * 根据输入的选择题信息添加到选择题题库中 并添加选择题标签信息
     * 输入choiceQuestion
     * 输出int
     *
     * @param choiceQuestion
     */
    public int addChoiceQuestionInfo(ChoiceQuestion choiceQuestion) {
        int o=choiceQuestionMapper.addChoiceQuestionInfo(choiceQuestion);
        for(int i=0;i<choiceQuestion.getQuestionLabels().size();i++){
            choiceQuestionLabelMapper.addChoiceQuestionLabelInfo(choiceQuestion.getChoiceQuestionId(),choiceQuestion.getQuestionLabels().get(i).getQuestionLabelId());
        }
        return o;
    }

    /**
     * 根据输入的选择题信息修改对应的选择题
     * 输入choiceQuestion
     * 输出int
     *
     * @param choiceQuestion
     */
    public int modifyChoiceQuestionInfo(ChoiceQuestion choiceQuestion) {
        return choiceQuestionMapper.modifyChoiceQuestionInfo(choiceQuestion);
    }

    /**
     * 查询自己私有创建的选择题目和共有的选择题目
     * 输入choiceQuestionId
     * 输出int
     *
     * @param
     */
    public List<ChoiceQuestion> queryChoiceQuestionInfo(int userId) {
        return choiceQuestionMapper.queryChoiceQuestionInfo(userId);
    }
}
