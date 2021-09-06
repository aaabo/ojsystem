package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamHistory;

import java.util.List;

public interface ExamHistoryService {

    /**
     * 根据考试Id查询考试排行榜
     * 输入examId
     * 输出List<ExamHistory>
     */
    public List<ExamHistory> queryExamRankById(int examId);
}
