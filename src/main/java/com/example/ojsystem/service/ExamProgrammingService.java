package com.example.ojsystem.service;

import com.example.ojsystem.entity.ExamProgramming;

import java.util.List;

public interface ExamProgrammingService {
    /**
     * 根据考试编程题信息添加考试编程题
     * 输入ExamProgramming
     * 输出int
     */
    public int addProgramExamInfo(ExamProgramming examProgramming);

    /**
     * 根据考试编程题信息修改考试编程题
     * 输入ExamProgramming
     * 输出int
     */
    public int modifyProgramExamInfo(ExamProgramming examProgramming);

    /**
     * 根据考试id查询全部考试编程题
     * 输入examId
     * 输出int
     */
    public List<ExamProgramming> queryProgrammingInfoById(int examId);

    /**
     * 根据考试编程题id删除考试编程题
     * 输入examProgrammingId
     * 输出int
     */
    public int deleteProgramExamInfo(int examProgrammingId);

    /**
     * 根据考试id查询考试编程题总分
     * 输入examId
     * 输出int
     */
    public int queryProgramExamTotalScoreInfo(int examId);

}
