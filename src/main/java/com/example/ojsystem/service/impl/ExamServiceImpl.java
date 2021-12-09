package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamMapper;
import com.example.ojsystem.entity.Exam;
import com.example.ojsystem.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService{
    @Autowired
    ExamMapper examMapper;


    /**
     * 根据考试信息添加考试
     * 输入exam
     * 输出int
     *
     * @param exam
     */
    public int saveExamInfo(Exam exam) {
        return examMapper.insertExamInfo(exam);
    }

    /**
     *查询用户能参加的考试信息
     * 输入userId
     * 输出List<Exam>
     */
    public List<Exam> checkExamInfoByUserId(int userId) {
        return examMapper.selectExamInfoByUserId(userId);
    }

    /**
     * 查询全部的考试信息
     * 输入无
     * 输出List<Exam>
     */
    public List<Exam> checkExamInfo() {
        return examMapper.selectExamInfo();
    }

    /**
     * 用户查询自己创建的的考试信息
     * 输入userId
     * 输出List<Exam>
     *
     * @param userId
     */
    public List<Exam> checkUserQueryExamInfo(int userId) {
        return examMapper.selectUserQueryExamInfo(userId);
    }

    /**
     * 修改考试信息
     * 输入exam
     * 输出int
     *
     * @param exam
     */
    public int alterExamInfo(Exam exam) {
        return examMapper.updateExamInfo(exam);
    }

    /**
     * 删除考试信息
     * 输入examId
     * 输出int
     *
     * @param examId
     */
    public int cancelExamInfo(int examId) {
        return examMapper.deleteExamInfo(examId);
    }

    /**
     * 修改考试状态
     * 输入exam
     * 输出int
     *
     * @param exam
     */
    public int alterExamStatus(Exam exam) {
        return examMapper.updateExamStatus(exam);
    }

    /**
     * 根据考试id查询考试信息
     * 输入examId
     * 输出Exam
     *
     * @param examId
     */
    public Exam checkExamInfoByExamId(int examId) {
        return examMapper.selectExamInfoByExamId(examId);
    }

    /**
     * 查询为结束的考试信息
     * 输入null
     * 输出Exam
     */
    public List<Exam> checkNotFinishedExamInfo() {
        return examMapper.selectNotFinishedExamInfo();
    }

    /**
     * 通过考试名称,考试状态，创建人来查询考试信息
     * 输入exam
     * 输出 List<Exam>
     *
     * @param exam
     */
    public List<Exam> checkSearchExamInfo(Exam exam) {
        return examMapper.selectSearchExamInfo(exam);
    }

}
