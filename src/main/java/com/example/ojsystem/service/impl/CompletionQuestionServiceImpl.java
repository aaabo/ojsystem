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
    public int saveCompletionQuestionInfo(CompletionQuestion completionQuestion) {
        int i=completionQuestionMapper.insertCompletionQuestionInfo(completionQuestion);
        if(i!=0){
            for(int o=0;o<completionQuestion.getCompletionQuestionAnswers().size();o++){
                i=completionQuestionAnswerMapper.insertCompletionQuestionAnswerInfo(completionQuestion.getCompletionQuestionAnswers().get(o),completionQuestion.getCompletionQuestionId());
            }
        }
        if(i!=0){
            for(int o=0;o<completionQuestion.getQuestionLabels().size();o++){
                i=completionQuestionLabelMapper.insertCompletionQuestionLabelInfo(completionQuestion.getCompletionQuestionId(),completionQuestion.getQuestionLabels().get(o).getQuestionLabelId());
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
    public int alterCompletionQuestionInfo(CompletionQuestion completionQuestion) {
        int i=completionQuestionMapper.updateCompletionQuestionInfo(completionQuestion);
        //先删除答案
        if(i!=0){
            i=completionQuestionAnswerMapper.deleteCompletionQuestionAnswerInfoByCompletionQuestionId(completionQuestion.getCompletionQuestionId());
        }
        //后添加答案
        if(i!=0){
            for(int o=0;o<completionQuestion.getCompletionQuestionAnswers().size();o++){
                i=completionQuestionAnswerMapper.insertCompletionQuestionAnswerInfo(completionQuestion.getCompletionQuestionAnswers().get(o),completionQuestion.getCompletionQuestionId());
            }
        }
        //先删除标签
        if(i!=0){
            completionQuestionLabelMapper.deleteCompletionQuestionLabelInfoByCompletionQuestionId(completionQuestion.getCompletionQuestionId());
        }
        //后添加标签
        if(i!=0){
            for(int o=0;o<completionQuestion.getQuestionLabels().size();o++){
                completionQuestionLabelMapper.insertCompletionQuestionLabelInfo(completionQuestion.getCompletionQuestionId(),completionQuestion.getQuestionLabels().get(o).getQuestionLabelId());
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
    public int cancelCompletionQuestionInfoByCompletionQuestionId(int completionQuestionId) {
        return completionQuestionMapper.deleteCompletionQuestionInfoByCompletionQuestionId(completionQuestionId);
    }

    /**
     * 根据用户来查询填空题信息
     * 输入userId
     * 输出int
     *
     * @param userId
     */
    public List<CompletionQuestion> checkCompletionQuestionInfoByUserId(int userId) {
        return completionQuestionMapper.selectCompletionQuestionInfoByUserId(userId);
    }

    /**
     * 根据输入的查询信息
     * 输入completionQuestion
     * 输出List<ChoiceQuestion>
     *
     * @param completionQuestion
     * @param currentUserId
     */
    public List<CompletionQuestion> checkCompletionQuestionBySearchInfo(CompletionQuestion completionQuestion, int currentUserId) {
        return completionQuestionMapper.selectCompletionQuestionBySearchInfo(completionQuestion,currentUserId);
    }

    /**
     * 根据填空题编号查询对应的填空题信息
     * 输入completionQuestion
     * 输出List<ChoiceQuestion>
     *
     * @param completionQuestionId
     */
    public CompletionQuestion checkCompletionQuestionIdByCompletionQuestionId(int completionQuestionId) {
        Integer i=completionQuestionMapper.selectCompletionQuestionIsExamByCompletionQuestionId(completionQuestionId);
        CompletionQuestion completionQuestion=completionQuestionMapper.selectCompletionQuestionIdByCompletionQuestionId(completionQuestionId);
        if(i!=null){
            completionQuestion.setIsExam(true);
        }else{
            completionQuestion.setIsExam(false);
        }
        return completionQuestion;

    }

    /**
     * 根据输入的考试编号查询考试填空题信息
     * 输入examId
     * 输出List<CompletionQuestion>
     *
     * @param examId
     */
    public List<CompletionQuestion> checkCompletionQuestionInfoByExamId(int examId) {
        return completionQuestionMapper.selectCompletionQuestionInfoByExamId(examId);
    }

    /**
     * 根据输入completionQuestionId判断是否在考试或测试中
     * 输入completionQuestionId
     * 输出true 或者false
     *
     * @param completionQuestionId
     */
    public Boolean checkCompletionQuestionIsExamByCompletionQuestionId(int completionQuestionId) {
        Integer i=completionQuestionMapper.selectCompletionQuestionIsExamByCompletionQuestionId(completionQuestionId);
        if(i!=null){
            return true;
        }else{
            return false;
        }

    }

}
