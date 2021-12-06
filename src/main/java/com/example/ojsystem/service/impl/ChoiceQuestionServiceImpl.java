package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ChoiceQuestionLabelMapper;
import com.example.ojsystem.dao.ChoiceQuestionMapper;
import com.example.ojsystem.entity.ChoiceQuestion;
import com.example.ojsystem.entity.QuestionLabel;
import com.example.ojsystem.service.ChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public int saveChoiceQuestionInfo(ChoiceQuestion choiceQuestion) {
        int o=choiceQuestionMapper.insertChoiceQuestionInfo(choiceQuestion);
        for(int i=0;i<choiceQuestion.getQuestionLabels().size();i++){
            choiceQuestionLabelMapper.insertChoiceQuestionLabelInfo(choiceQuestion.getChoiceQuestionId(),choiceQuestion.getQuestionLabels().get(i).getQuestionLabelId());
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
    public int alterChoiceQuestionInfo(ChoiceQuestion choiceQuestion) {
        //先删除
        choiceQuestionLabelMapper.deleteChoiceQuestionLabelInfoByChoiceQuestionId(choiceQuestion.getChoiceQuestionId());
        //后添加
        for(int i=0;i<choiceQuestion.getQuestionLabels().size();i++){
            choiceQuestionLabelMapper.insertChoiceQuestionLabelInfo(choiceQuestion.getChoiceQuestionId(),choiceQuestion.getQuestionLabels().get(i).getQuestionLabelId());
        }
        return choiceQuestionMapper.updateChoiceQuestionInfo(choiceQuestion);
    }

    /**
     * 查询自己私有创建的选择题目和共有的选择题目
     * 输入userId
     * 输出int
     *
     * @param
     */
    public List<ChoiceQuestion> checkChoiceQuestionInfo(int userId) {
        return choiceQuestionMapper.selectChoiceQuestionInfo(userId);
    }

    /**
     * 根据选择题id删除对应的选择题
     * 输入choiceQuestionId
     * 输出int
     *
     * @param choiceQuestionId
     */
    public int cancelChoiceQuestionInfoByChoiceQuestionId(int choiceQuestionId) {
        return choiceQuestionMapper.deleteChoiceQuestionInfoByChoiceQuestionId(choiceQuestionId);
    }

    /**
     * 根据输入的查询信息
     * 输入choiceQuestion
     * 输出List<ChoiceQuestion>
     *
     * @param choiceQuestion,currentUserId
     */
    public List<ChoiceQuestion> checkChoiceQuestionIdBySearchInfo(ChoiceQuestion choiceQuestion,int currentUserId) {
        return choiceQuestionMapper.selectChoiceQuestionIdBySearchInfo(choiceQuestion,currentUserId);
    }

    /**
     * 根据输入的选择题编号查询选择题信息
     * 输入choiceQuestionId
     * 输出ChoiceQuestion
     *
     * @param choiceQuestionId
     */
    public ChoiceQuestion checkChoiceQuestionInfoByChoiceQuestionId(int choiceQuestionId) {
        return choiceQuestionMapper.selectChoiceQuestionInfoByChoiceQuestionId(choiceQuestionId);
    }

    /**
     * 根据输入的考试编号查询考试选择题信息
     * 输入examId
     * 输出List<ChoiceQuestion>
     *
     * @param examId
     */
    public List<ChoiceQuestion> checkChoiceQuestionInfoByExamId(int examId) {
        return choiceQuestionMapper.selectChoiceQuestionInfoByExamId(examId);
    }
}
