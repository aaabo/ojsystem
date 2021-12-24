package com.example.ojsystem.dao;

import com.example.ojsystem.entity.CompletionQuestion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompletionQuestionMapper {
    /**
     * 根据输入的填空题信息添加到填空题题库中
     * 输入completionQuestion
     * 输出int
     */
    public int insertCompletionQuestionInfo(@Param("completionQuestion") CompletionQuestion completionQuestion);

    /**
     * 根据输入的填空题信息修改对应的填空题信息
     * 输入completionQuestion
     * 输出int
     */
    public int updateCompletionQuestionInfo(@Param("completionQuestion")CompletionQuestion completionQuestion);

    /**
     * 根据输入的填空题编号删除对应的填空题信息
     * 输入completionQuestionId
     * 输出int
     */
    public int deleteCompletionQuestionInfoByCompletionQuestionId(@Param("completionQuestionId") int completionQuestionId);

    /**
     * 根据用户来查询填空题信息
     * 输入userId
     * 输出int
     */
    public List<CompletionQuestion> selectCompletionQuestionInfoByUserId(@Param("userId") int userId);

    /**
     * 根据输入的查询信息
     * 输入completionQuestion
     * 输出List<ChoiceQuestion>
     */
    public List<CompletionQuestion> selectCompletionQuestionBySearchInfo(@Param("completionQuestion")CompletionQuestion completionQuestion,@Param("currentUserId")int currentUserId);

    /**
     * 根据填空题编号查询对应的填空题信息
     * 输入completionQuestion
     * 输出List<ChoiceQuestion>
     */
    public CompletionQuestion selectCompletionQuestionIdByCompletionQuestionId(@Param("completionQuestionId") int completionQuestionId);

    /**
     * 根据输入的考试编号查询考试填空题信息
     * 输入examId
     * 输出List<CompletionQuestion>
     */
    public List<CompletionQuestion> selectCompletionQuestionInfoByExamId(@Param("examId") int examId);

    /**
     * 根据输入completionQuestionId判断是否在考试或测试中
     * 输入completionQuestionId
     * 输出true 或者false
     */
    public Integer selectCompletionQuestionIsExamByCompletionQuestionId(@Param("completionQuestionId") int completionQuestionId);



}
