package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamMapper;
import com.example.ojsystem.entity.Exam;
import com.example.ojsystem.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
     *查询学生能参加的考试信息
     * 输入无
     * 输出List<Exam>
     */
    public List<Exam> queryExamInfoByStudentId(int studentId) {
        return examMapper.queryExamInfoByStudentId(studentId);
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
     * 教师查询自己的考试信息
     * 输入teacher
     * 输出List<Exam>
     *
     * @param teacherId
     */
    public List<Exam> teacherQueryExamInfo(int teacherId) {
        return examMapper.teacherQueryExamInfo(teacherId);
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
     * 查询考试信息
     * 输入examId
     * 输出Exam
     *
     * @param examId
     */
    public Exam queryExamType(int examId) {
        return examMapper.queryExamType(examId);
    }
}
