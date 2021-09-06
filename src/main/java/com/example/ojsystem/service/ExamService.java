package com.example.ojsystem.service;

import com.example.ojsystem.entity.Exam;
import sun.font.EAttribute;

import java.util.List;

public interface ExamService {

    /**
     * 根据考试信息添加考试
     * 输入exam
     * 输出int
     */
    public int addExamInfo(Exam exam);

    /**
     * 查询全部已发布考试信息
     * 输入无
     * 输出List<Exam>
     */
    public List<Exam> queryExamInfo(int studentId);

    /**
     * 教师查询自己的考试信息
     * 输入teacher
     * 输出List<Exam>
     */
    public List<Exam> teacherQueryExamInfo(int teacherId);

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
}
