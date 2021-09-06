package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExamChoiceQuestion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamChoiceQuestionMapper {
    /**
     * 根据考试id和选择题信息添加选择题信息
     * 输入examChoiceQuestion
     * 输出int
     */
    public int addChoiceQuestionExamInfo(@Param("examChoiceQuestion") ExamChoiceQuestion examChoiceQuestion);

    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<ExamChoiceQuestion>
     */
    public List<ExamChoiceQuestion> queryChoiceQuestionInfoById(@Param("examId") int examId);

    /**
     * 根据新输入的选择题信息修改选择题
     * 输入examChoiceQuestion
     * 输出int
     */
    public int modifyChoiceQuestionExamInfo(@Param("examChoiceQuestion") ExamChoiceQuestion examChoiceQuestion);

    /**
     * 根据输入的examChoiceId删除选择题信息
     * 输入examChoiceQuestionId
     * 输出int
     */
    public int deleteChoiceQuestionExamInfo(@Param("examChoiceQuestionId") int examChoiceQuestionId);
}
