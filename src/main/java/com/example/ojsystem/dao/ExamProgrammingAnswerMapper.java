package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExamProgrammingAnswer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamProgrammingAnswerMapper {
    /**
     * 根据上传的考试编程题答案来添加信息
     * 输入examProgrammingAnswer
     * 输出int
     */
    public int addExamProgrammingAnswer(@Param("examProgrammingAnswer") ExamProgrammingAnswer examProgrammingAnswer);

    /**
     * 根据上传的考试编程题答案信息来修改考试编程题答案信息
     * 输入examProgrammingAnswer
     * 输出int
     */
    public int modifyExamProgrammingAnswer(@Param("examProgrammingAnswer") ExamProgrammingAnswer examProgrammingAnswer);


    /**
     * 根据编程题id查询编程题答案
     * 输入ProgrammingId
     * 输出list
     */
    public List<ExamProgrammingAnswer> queryProgrammingAnswerInfoById(@Param("programmingId") int programmingId);


    /**
     * 根据上传的考试编程题答案id来删除考试编程题信息
     * 输入examProgrammingAnswerId
     * 输出int
     */
    public int deleteExamProgrammingAnswer(@Param("examProgrammingAnswerId") int examProgrammingAnswerId);
}
