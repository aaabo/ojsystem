package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ChoiceQuestion;
import com.example.ojsystem.entity.CompletionQuestion;
import com.example.ojsystem.entity.ExamQuestion;
import com.example.ojsystem.entity.Exercise;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamQuestionMapper {
    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<ChoiceQuestion>
     */
    public List<ChoiceQuestion> queryExamQuestionChoiceByExamId(@Param("examId") int examId);

    /**
     * 根据考试id查询对应的选择题信息
     * 输入examId
     * 输出List<CompletionQuestion>
     */
    public List<CompletionQuestion> queryExamQuestionCompletionByExamId(@Param("examId") int examId);


    /**
     * 根据考试id查询对应的编程题信息
     * 输入examId
     * 输出List<Exercise>
     */
    public List<Exercise> queryExamQuestionProgrammingByExamId(@Param("examId")int examId);

    /**
     * 根据题目类型和题目编号添加考试题目
     * 输入examId,questionId
     * 输出int
     */
    public int addExamQuestion(@Param("examId") int examId,@Param("questionId")int questionId,@Param("examQuestionType")String examQuestionType);

    /**
     * 根据题目类型和题目编号题目类型删除对应的考试题目
     * 输入examId,questionId,examQuestionType
     * 输出int
     */
    public int deleteExamQuestion(@Param("examId") int examId,@Param("questionId")int questionId,@Param("examQuestionType")String examQuestionType);
}
