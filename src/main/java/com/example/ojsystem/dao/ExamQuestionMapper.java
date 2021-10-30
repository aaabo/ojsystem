package com.example.ojsystem.dao;

import com.example.ojsystem.entity.*;
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

    /**
     * 根据考试编号查询编程题的各题平均分
     * 输入examId
     * 输出List<ExamProgrammingResultScoreTool>
     */
    public List<ExamProgrammingResultScoreTool> queryExamProgrammingResultScoreByExamId(@Param("examId") int examId);

    /**
     * 根据考试编号查询考试结果的各个分数段
     * 输入examId
     * 输出UserExamScoreEachSegmentNumber
     */
    public UserExamScoreEachSegmentNumber queryUserExamScoreEachSegmentNumberByExamId(@Param("examId") int examId);

    /**
     * 根据考试题目编号查询编程题答案
     * 输入examQuestionId
     * 输出List<ExerciseAnswer>
     */
    public List<ExerciseAnswer> queryExerciseAnswerInfoByExamQuestionId(@Param("examQuestionId") int examQuestionId);
}
