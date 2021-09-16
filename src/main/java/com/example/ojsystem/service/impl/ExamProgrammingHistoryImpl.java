package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamProgrammingHistoryMapper;
import com.example.ojsystem.dao.ExamProgrammingMapper;
import com.example.ojsystem.entity.ExamProgrammingHistory;
import com.example.ojsystem.entity.StudentScoreTool;
import com.example.ojsystem.service.ExamProgrammingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamProgrammingHistoryImpl implements ExamProgrammingHistoryService{
    @Autowired
    ExamProgrammingHistoryMapper examProgrammingHistoryMapper;

    /**
     * 根据学生id和考试编程信息添加考试编程题记录
     * 输入examProgrammingHistory
     * 输出int
     *
     * @param examProgrammingHistory
     */
    public int addExamProgrammingHistory(ExamProgrammingHistory examProgrammingHistory) {
        return examProgrammingHistoryMapper.addExamProgrammingHistory(examProgrammingHistory);
    }

    /**
     * 根据考试id查询所有学生的编程题分数
     * 输入examId
     * 输出List<StudentScoreTool>
     *
     * @param examId
     */
    public List<StudentScoreTool> queryStudentExamProgrammingScore(int examId) {

        return examProgrammingHistoryMapper.queryStudentExamProgrammingScore(examId);
    }
}
