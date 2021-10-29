package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExamChoiceQuestionHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamChoiceQuestionHistoryMapper {

    /**
     * 根据用户id 考试题目id 用户选项添加用户选择题记录
     * 输入userId,examQuestionId,examChoiceQuestionUserSelection
     * 输出int
     */
    public int addExamChoiceQuestionHistory(@Param("userId") int userId,@Param("examQuestionId")int examQuestionId,@Param("examChoiceQuestionUserSelection")String examChoiceQuestionUserSelection);


}
