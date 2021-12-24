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
        int o=0;
        o=choiceQuestionMapper.insertChoiceQuestionInfo(choiceQuestion);
        for(int i=0;i<choiceQuestion.getQuestionLabels().size();i++){
            if(o!=0){
                choiceQuestionLabelMapper.insertChoiceQuestionLabelInfo(choiceQuestion.getChoiceQuestionId(),choiceQuestion.getQuestionLabels().get(i).getQuestionLabelId());
            }
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
        int o=0;
        //先删除
        o=choiceQuestionLabelMapper.deleteChoiceQuestionLabelInfoByChoiceQuestionId(choiceQuestion.getChoiceQuestionId());
        //后添加
        for(int i=0;i<choiceQuestion.getQuestionLabels().size();i++){
            if(o!=0){
                o=choiceQuestionLabelMapper.insertChoiceQuestionLabelInfo(choiceQuestion.getChoiceQuestionId(),choiceQuestion.getQuestionLabels().get(i).getQuestionLabelId());
            }
        }
        if(o!=0){
            o=choiceQuestionMapper.updateChoiceQuestionInfo(choiceQuestion);
        }

        return o;
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
        Integer i=choiceQuestionMapper.selectChoiceQuestionIsExamByChoiceQuestionId(choiceQuestionId);
        ChoiceQuestion choiceQuestion=choiceQuestionMapper.selectChoiceQuestionInfoByChoiceQuestionId(choiceQuestionId);
        if(i!=null){
            choiceQuestion.setIsExam(true);
        }else{
            choiceQuestion.setIsExam(false);
        }

        return choiceQuestion;
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

    /**
     * 根据输入choiceQuestionId判断是否在考试或测试中
     * 输入choiceQuestionId
     * 输出true 或者false
     *
     * @param choiceQuestionId
     */
    public Boolean checkChoiceQuestionIsExamByChoiceQuestionId(int choiceQuestionId) {
        Integer i=choiceQuestionMapper.selectChoiceQuestionIsExamByChoiceQuestionId(choiceQuestionId);
        if(i!=null){
            return true;
        }else{
            return false;
        }
    }
}
