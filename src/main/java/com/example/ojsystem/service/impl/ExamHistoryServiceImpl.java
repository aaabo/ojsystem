package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamHistoryMapper;
import com.example.ojsystem.entity.ExamHistory;
import com.example.ojsystem.service.ExamHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamHistoryServiceImpl implements ExamHistoryService{

    @Autowired
    ExamHistoryMapper examHistoryMapper;
    /**
     * 根据考试Id查询考试排行榜
     * 输入examId
     * 输出List<ExamHistory>
     *
     * @param examId
     */
    public List<ExamHistory> queryExamRankById(int examId) {
        return examHistoryMapper.queryExamRankById(examId);
    }

    /**
     * 根据用户Id查询参加的考试信息
     * 输入userId
     * 输出List<ExamHistory>
     *
     * @param userId
     */
    public List<ExamHistory> queryExamHistoryInfoByUserId(int userId) {
        return examHistoryMapper.queryExamHistoryInfoByUserId(userId);
    }
}
