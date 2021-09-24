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
     * 根据用户id 选择题id 用户选项添加用户选择题记录
     * 输入ExamChoiceQuestionHistory
     * 输出int
     *
     * @param examChoiceQuestionHistory
     */
    public int addExamChoiceQuestionHistory(ExamChoiceQuestionHistory examChoiceQuestionHistory) {
        return examChoiceQuestionHistoryMapper.addExamChoiceQuestionHistory(examChoiceQuestionHistory);
    }


}
