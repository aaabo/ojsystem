package com.example.ojsystem.service;

import com.example.ojsystem.entity.Exam;

import java.util.List;

public interface ExamService {

    /**
     * 根据考试信息添加考试
     * 输入exam
     * 输出int
     */
    public int addExamInfo(Exam exam);

    /**
     * 查询用户能参加的考试信息
     * 输入无
     * 输出List<Exam>
     */
    public List<Exam> queryExamInfoByUserId(int userId);

    /**
     * 查询全部的考试信息
     * 输入无
     * 输出List<Exam>
     */
    public List<Exam> queryExamInfo();

    /**
     * 用户查询自己创建的的考试信息
     * 输入userId
     * 输出List<Exam>
     */
    public List<Exam> userQueryExamInfo(int userId);

    /**
     * 修改考试信息
     * 输入exam
     * 输出int
     */
    public int modifyExamInfo(Exam exam);

    /**
     * 删除考试信息
     * 输入examId
     * 输出int
     */
    public int deleteExamInfo(int examId);

    /**
     * 修改考试状态
     * 输入exam
     * 输出int
     */
    public int updateExamStatus(Exam exam);

    /**
     * 根据考试id查询考试信息
     * 输入examId
     * 输出Exam
     */
    public Exam queryExamInfoByExamId(int examId);


    /**
     * 查询为结束的考试信息
     * 输入null
     * 输出Exam
     */
    public List<Exam> queryNotFinishedExamInfo();



    /**
     * 通过考试名称,考试状态，创建人来查询考试信息
     * 输入exam
     * 输出 List<Exam>
     */
    public List<Exam> searchExamInfo(Exam exam);

}
