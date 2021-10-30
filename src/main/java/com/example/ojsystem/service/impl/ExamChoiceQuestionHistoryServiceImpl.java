package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamChoiceQuestionHistoryMapper;
import com.example.ojsystem.entity.ExamChoiceQuestionHistory;
import com.example.ojsystem.entity.ExamQuestionHistory;
import com.example.ojsystem.service.ExamChoiceQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamChoiceQuestionHistoryServiceImpl implements ExamChoiceQuestionHistoryService{
    @Autowired
    ExamChoiceQuestionHistoryMapper examChoiceQuestionHistoryMapper;

    /**
     * 根据用户提交的选择题信息添加选择题记录
     * 输入examQuestionHistories,userId
     * 输出int
     *
     * @param userId
     * @param examQuestionHistories
     */
    public int addExamChoiceQuestionHistoryInfo(List<ExamQuestionHistory> examQuestionHistories, int userId) {
        int result=0;
        for(int i=0;i<examQuestionHistories.size();i++){
            ExamChoiceQuestionHistory examChoiceQuestionHistory=examQuestionHistories.get(i).getExamChoiceQuestionHistory();
            result=examChoiceQuestionHistoryMapper.addExamChoiceQuestionHistory(userId,examQuestionHistories.get(i).getExamQuestionId(),examChoiceQuestionHistory.getExamChoiceQuestionUserSelection(),examChoiceQuestionHistory.getExamChoiceQuestionResultScore());
        }
        return result;
    }


}
