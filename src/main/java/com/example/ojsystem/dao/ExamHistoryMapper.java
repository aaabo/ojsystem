package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExamHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExamHistoryMapper {
    /**
     * 根据考试Id查询考试排行榜
     * 输入examId
     * 输出List<ExamHistory>
     */
    public List<ExamHistory> queryExamRankById(@Param("examId") int examId);
}
