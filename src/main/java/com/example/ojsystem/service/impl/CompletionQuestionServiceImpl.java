package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.CompletionQuestionAnswerMapper;
import com.example.ojsystem.dao.CompletionQuestionLabelMapper;
import com.example.ojsystem.dao.CompletionQuestionMapper;
import com.example.ojsystem.dao.QuestionLabelMapper;
import com.example.ojsystem.entity.CompletionQuestion;
import com.example.ojsystem.entity.QuestionLabel;
import com.example.ojsystem.service.CompletionQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompletionQuestionServiceImpl implements CompletionQuestionService{
    @Autowired
    CompletionQuestionMapper completionQuestionMapper;
    @Autowired
    CompletionQuestionAnswerMapper completionQuestionAnswerMapper;
    @Autowired
    CompletionQuestionLabelMapper completionQuestionLabelMapper;
    /**
     * 根据输入的填空题信息添加到填空题题库中
     * 输入completionQuestion
     * 输出int
     *
     * @param completionQuestion
     */
    public int addCompletionQuestionInfo(CompletionQuestion completionQuestion) {
        int i=completionQuestionMapper.addCompletionQuestionInfo(completionQuestion);
        if(i!=0){
            for(int o=0;o<completionQuestion.getCompletionQuestionAnswers().size();o++){
                i=completionQuestionAnswerMapper.addCompletionQuestionAnswerInfo(completionQuestion.getCompletionQuestionAnswers().get(o),completionQuestion.getCompletionQuestionId());
            }
        }
        if(i!=0){
            for(int o=0;o<completionQuestion.getQuestionLabels().size();o++){
                i=completionQuestionLabelMapper.addCompletionQuestionLabelInfo(completionQuestion.getCompletionQuestionId(),completionQuestion.getQuestionLabels().get(o).getQuestionLabelId());
            }
        }

        return i;
    }

    /**
     * 根据输入的填空题信息修改对应的填空题信息
     * 输入completionQuestion
     * 输出int
     *
     * @param completionQuestion
     */
    public int modifyCompletionQuestionInfo(CompletionQuestion completionQuestion) {
        int i=completionQuestionMapper.modifyCompletionQuestionInfo(completionQuestion);
        //先删除答案
        if(i!=0){
            i=completionQuestionAnswerMapper.deleteCompletionQuestionAnswerInfoByCompletionQuestionId(completionQuestion.getCompletionQuestionId());
        }
        //后添加答案
        if(i!=0){
            for(int o=0;o<completionQuestion.getCompletionQuestionAnswers().size();o++){
                i=completionQuestionAnswerMapper.addCompletionQuestionAnswerInfo(completionQuestion.getCompletionQuestionAnswers().get(o),completionQuestion.getCompletionQuestionId());
            }
        }
        //先删除标签
        if(i!=0){
            completionQuestionLabelMapper.deleteCompletionQuestionLabelInfoByCompletionQuestionId(completionQuestion.getCompletionQuestionId());
        }
        //后添加标签
        if(i!=0){
            for(int o=0;o<completionQuestion.getQuestionLabels().size();o++){
                completionQuestionLabelMapper.addCompletionQuestionLabelInfo(completionQuestion.getCompletionQuestionId(),completionQuestion.getQuestionLabels().get(o).getQuestionLabelId());
            }
        }
        return i;
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
