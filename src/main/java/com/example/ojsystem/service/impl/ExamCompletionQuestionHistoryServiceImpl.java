package com.example.ojsystem.service.impl;


import com.example.ojsystem.dao.ExamCompletionQuestionHistoryAnswerMapper;
import com.example.ojsystem.dao.ExamCompletionQuestionHistoryMapper;
import com.example.ojsystem.entity.ExamCompletionQuestionHistory;
import com.example.ojsystem.entity.ExamQuestionHistory;
import com.example.ojsystem.service.ExamCompletionQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamCompletionQuestionHistoryServiceImpl implements ExamCompletionQuestionHistoryService{
    @Autowired
    ExamCompletionQuestionHistoryMapper examCompletionQuestionHistoryMapper;
    @Autowired
    ExamCompletionQuestionHistoryAnswerMapper examCompletionQuestionHistoryAnswerMapper;
    /**
     * 根据用户提交的填空题信息添加填空题记录
     * 输入examQuestionHistories,userId
     * 输出int
     *
     * @param examQuestionHistories
     * @param userId
     */
    public int saveExamCompletionQuestionHistoryInfo(List<ExamQuestionHistory> examQuestionHistories,int userId) {
        int result=0;
        for(int i=0;i<examQuestionHistories.size();i++){
            ExamCompletionQuestionHistory examCompletionQuestionHistory=examQuestionHistories.get(i).getExamCompletionQuestionHistory();
            result=examCompletionQuestionHistoryMapper.insertExamCompletionQuestionHistoryInfo(userId,examQuestionHistories.get(i).getExamQuestionId(),examCompletionQuestionHistory);
            for(int o=0;o<examCompletionQuestionHistory.getExamCompletionQuestionAnswerHistories().size();o++){
                result=examCompletionQuestionHistoryAnswerMapper.insertExamCompletionQuestionAnswerHistoryInfo(examCompletionQuestionHistory.getExamCompletionQuestionHistoryId(),examCompletionQuestionHistory.getExamCompletionQuestionAnswerHistories().get(o).getExamCompletionQuestionUserAnswer(),examCompletionQuestionHistory.getExamCompletionQuestionAnswerHistories().get(o).getExamCompletionQuestionUserAnswerNumber());
            }
       }
        return result;
    }


}
