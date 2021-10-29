package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamChoiceQuestionHistoryMapper;
import com.example.ojsystem.entity.ExamChoiceQuestionHistory;
import com.example.ojsystem.service.ExamChoiceQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamChoiceQuestionHistoryImpl implements ExamChoiceQuestionHistoryService{
    @Autowired
    ExamChoiceQuestionHistoryMapper examChoiceQuestionHistoryMapper;

    /**
     * 根据用户id 考试题目id 用户选项添加用户选择题记录
     * 输入userId,examQuestionId,examChoiceQuestionUserSelection
     * 输出int
     *
     * @param userId
     * @param examQuestionId
     * @param examChoiceQuestionUserSelection
     */
    public int addExamChoiceQuestionHistory(int userId,int examQuestionId,String examChoiceQuestionUserSelection) {
        return examChoiceQuestionHistoryMapper.addExamChoiceQuestionHistory(userId,examQuestionId,examChoiceQuestionUserSelection);
    }


}
