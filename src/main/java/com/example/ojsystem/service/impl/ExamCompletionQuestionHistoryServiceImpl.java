package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.CompletionQuestionAnswerMapper;
import com.example.ojsystem.dao.ExamCompletionQuestionHistoryAnswerMapper;
import com.example.ojsystem.dao.ExamCompletionQuestionHistoryMapper;
import com.example.ojsystem.entity.CompletionQuestionAnswer;
import com.example.ojsystem.entity.ExamCompletionQuestionAnswerHistory;
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
    public int addExamCompletionQuestionHistoryInfo(List<ExamQuestionHistory> examQuestionHistories,int userId) {
        int result=0;
        for(int i=0;i<examQuestionHistories.size();i++){
        ExamQuestionHistory examQuestionHistory=new ExamQuestionHistory();
        examQuestionHistory.setScore(new Float(2));
        examQuestionHistory.setExamQuestionId(1);
        result=examCompletionQuestionHistoryMapper.addExamCompletionQuestionHistoryInfo(userId,examQuestionHistory);
        //再一个循环
//        examCompletionQuestionHistoryAnswerMapper.addExamCompletionQuestionAnswerHistoryInfo(examQuestionHistory.getId(),)
       }

        return result;
    }


}
