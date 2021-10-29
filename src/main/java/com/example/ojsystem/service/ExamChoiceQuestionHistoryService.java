package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamChoiceQuestionHistory;

import java.util.List;

public interface ExamChoiceQuestionHistoryService {
    /**
     * 根据用户id 考试题目id 用户选项添加用户选择题记录
     * 输入userId,examQuestionId,examChoiceQuestionUserSelection
     * 输出int
     */
    public int addExamChoiceQuestionHistory(int userId,int examQuestionId,String examChoiceQuestionUserSelection);


}
