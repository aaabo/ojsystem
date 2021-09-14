package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamProgrammingAnswer;

import java.util.List;

public interface ExamProgrammingAnswerService {
    /**
     * 根据上传的考试编程题答案来添加信息
     * 输入examProgrammingAnswer
     * 输出int
     */
    public int addExamProgrammingAnswer(ExamProgrammingAnswer examProgrammingAnswer);

    /**
     * 根据上传的考试编程题答案信息来修改考试编程题答案信息
     * 输入examProgrammingAnswer
     * 输出int
     */
    public int modifyExamProgrammingAnswer(ExamProgrammingAnswer examProgrammingAnswer);



    /**
     * 根据编程题id查询编程题答案
     * 输入ProgrammingId
     * 输出list
     */
    public List<ExamProgrammingAnswer> queryProgrammingAnswerInfoById(int programmingId);

    /**
     * 根据上传的考试编程题答案id来删除考试编程题信息
     * 输入examProgrammingAnswerId
     * 输出int
     */
    public int deleteExamProgrammingAnswer(int examProgrammingAnswerId);
}
