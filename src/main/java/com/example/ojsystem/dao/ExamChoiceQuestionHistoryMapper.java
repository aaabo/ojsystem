package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExamChoiceQuestionHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamChoiceQuestionHistoryMapper {

    /**
     * 根据学生id 选择题id 学生选项添加学生选择题记录
     * 输入ExamChoiceQuestionHistory
     * 输出int
     */
    public int addExamChoiceQuestionHistory(@Param("examChoiceQuestionHistory") ExamChoiceQuestionHistory examChoiceQuestionHistory);
}
