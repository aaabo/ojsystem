package com.example.ojsystem.service;

import com.example.ojsystem.entity.Exam;

import java.util.List;

public interface ExamService {

    /**
     * 根据考试信息添加考试
     * 输入exam
     * 输出int
     */
    public int saveExamInfo(Exam exam);

    /**
     * 查询用户能参加的考试信息
     * 输入无
     * 输出List<Exam>
     */
    public List<Exam> checkExamInfoByUserId(int userId);

    /**
     * 查询全部的考试信息
     * 输入无
     * 输出List<Exam>
     */
    public List<Exam> checkExamInfo();

    /**
     * 用户查询自己创建的的考试信息
     * 输入userId
     * 输出List<Exam>
     */
    public List<Exam> checkUserQueryExamInfo(int userId);

    /**
     * 修改考试信息
     * 输入exam
     * 输出int
     */
    public int alertExamInfo(Exam exam);

    /**
     * 删除考试信息
     * 输入examId
     * 输出int
     */
    public int cancelExamInfo(int examId);

    /**
     * 修改考试状态
     * 输入exam
     * 输出int
     */
    public int alertExamStatus(Exam exam);

    /**
     * 根据考试id查询考试信息
     * 输入examId
     * 输出Exam
     */
    public Exam checkExamInfoByExamId(int examId);


    /**
     * 查询为结束的考试信息
     * 输入null
     * 输出Exam
     */
    public List<Exam> checkNotFinishedExamInfo();



    /**
     * 通过考试名称,考试状态，创建人来查询考试信息
     * 输入exam
     * 输出 List<Exam>
     */
    public List<Exam> checkSearchExamInfo(Exam exam);



}
