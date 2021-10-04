package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamProgrammingQuestionHistoryMapper;
import com.example.ojsystem.entity.ExamProgrammingQuestionHistory;
import com.example.ojsystem.service.ExamProgrammingQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamProgrammingQuestionHistoryServiceImpl implements ExamProgrammingQuestionHistoryService {
    @Autowired
    ExamProgrammingQuestionHistoryMapper examProgrammingQuestionHistoryMapper;

    /**
     * 根据学生id和考试编程信息添加考试编程题记录
     * 输入examProgrammingHistory
     * 输出int
     *
     * @param examProgrammingQuestionHistory
     */
    public int addExamProgrammingQuestionHistory(ExamProgrammingQuestionHistory examProgrammingQuestionHistory) {
        return examProgrammingQuestionHistoryMapper.addExamProgrammingQuestionHistory(examProgrammingQuestionHistory);
    }


}
