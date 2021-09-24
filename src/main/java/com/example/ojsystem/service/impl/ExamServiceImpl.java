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
    public int addExamInfo(Exam exam) {
        return examMapper.addExamInfo(exam);
    }

    /**
     *查询用户能参加的考试信息
     * 输入userId
     * 输出List<Exam>
     */
    public List<Exam> queryExamInfoByUserId(int userId) {
        return examMapper.queryExamInfoByUserId(userId);
    }

    /**
     * 查询全部的考试信息
     * 输入无
     * 输出List<Exam>
     */
    public List<Exam> queryExamInfo() {
        return examMapper.queryExamInfo();
    }

    /**
     * 用户查询自己创建的的考试信息
     * 输入userId
     * 输出List<Exam>
     *
     * @param userId
     */
    public List<Exam> userQueryExamInfo(int userId) {
        return examMapper.userQueryExamInfo(userId);
    }

    /**
     * 修改考试信息
     * 输入exam
     * 输出int
     *
     * @param exam
     */
    public int modifyExamInfo(Exam exam) {
        return examMapper.modifyExamInfo(exam);
    }

    /**
     * 删除考试信息
     * 输入examId
     * 输出int
     *
     * @param examId
     */
    public int deleteExamInfo(int examId) {
        return examMapper.deleteExamInfo(examId);
    }

    /**
     * 修改考试状态
     * 输入exam
     * 输出int
     *
     * @param exam
     */
    public int updateExamType(Exam exam) {
        return examMapper.updateExamType(exam);
    }

    /**
     * 根据考试id查询考试信息
     * 输入examId
     * 输出Exam
     *
     * @param examId
     */
    public Exam queryExamInfoByExamId(int examId) {
        return examMapper.queryExamInfoByExamId(examId);
    }

    /**
     * 查询为结束的考试信息
     * 输入null
     * 输出Exam
     */
    public List<Exam> queryNotFinishedExamInfo() {
        return examMapper.queryNotFinishedExamInfo();
    }

    /**
     * 通过考试名称,考试状态，创建人来查询考试信息
     * 输入exam
     * 输出 List<Exam>
     *
     * @param exam
     */
    public List<Exam> searchExamInfo(Exam exam) {
        return examMapper.searchExamInfo(exam);
    }

}
