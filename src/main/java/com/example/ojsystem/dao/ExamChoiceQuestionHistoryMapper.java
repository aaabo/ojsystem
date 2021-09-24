package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExamChoiceQuestionHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamChoiceQuestionHistoryMapper {

    /**
     * 根据用户id 选择题id 用户选项添加用户选择题记录
     * 输入ExamChoiceQuestionHistory
     * 输出int
     */
    public int addExamChoiceQuestionHistory(@Param("examChoiceQuestionHistory") ExamChoiceQuestionHistory examChoiceQuestionHistory);


}
