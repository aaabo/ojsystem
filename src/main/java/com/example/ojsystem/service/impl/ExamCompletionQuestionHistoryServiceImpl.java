package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamCompletionQuestionHistoryMapper;
import com.example.ojsystem.service.ExamCompletionQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamCompletionQuestionHistoryServiceImpl implements ExamCompletionQuestionHistoryService{
    @Autowired
    ExamCompletionQuestionHistoryMapper examCompletionQuestionHistoryMapper;

    /**
     * 根据用户提交的填空题信息添加填空题记录
     * 输入userId,examQuestionId
     * 输出int
     *
     * @param userId
     * @param examQuestionId
     */
    public int addExamCompletionQuestionHistoryInfo(int userId, int examQuestionId) {
        return 0;
    }
}
