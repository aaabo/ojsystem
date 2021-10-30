package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ChoiceQuestion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChoiceQuestionMapper {
    /**
     * 根据输入的选择题信息添加到选择题题库中
     * 输入choiceQuestion
     * 输出int
     */
    public int addChoiceQuestionInfo(@Param("choiceQuestion") ChoiceQuestion choiceQuestion);

    /**
     * 根据输入的选择题信息修改对应的选择题
     * 输入choiceQuestion
     * 输出int
     */
    public int modifyChoiceQuestionInfo(@Param("choiceQuestion") ChoiceQuestion choiceQuestion);

    /**
     * 查询自己私有创建的选择题目和共有的选择题目
     * 输入userId
     * 输出int
     */
    public List<ChoiceQuestion> queryChoiceQuestionInfo(@Param("userId") int userId);

    /**
     * 根据选择题id删除对应的选择题
     * 输入choiceQuestionId
     * 输出int
     */
    public int deleteChoiceQuestionInfoByChoiceQuestionId(@Param("choiceQuestionId") int choiceQuestionId);

    /**
     * 根据输入的查询信息
     * 输入choiceQuestion
     * 输出List<ChoiceQuestion>
     */
    public List<ChoiceQuestion> queryChoiceQuestionIdBySearchInfo(@Param("choiceQuestion") ChoiceQuestion choiceQuestion,@Param("currentUserId") int currentUserId);

    /**
     * 根据输入的选择题编号查询选择题信息
     * 输入choiceQuestionId
     * 输出ChoiceQuestion
     */
    public ChoiceQuestion queryChoiceQuestionInfoByChoiceQuestionId(int choiceQuestionId);

    /**
     * 根据输入的考试编号查询考试选择题信息
     * 输入examId
     * 输出List<ChoiceQuestion>
     */
    public List<ChoiceQuestion> queryChoiceQuestionInfoByExamId(@Param("examId") int examId);
}
