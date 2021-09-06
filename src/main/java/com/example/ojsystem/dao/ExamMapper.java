package com.example.ojsystem.dao;

import com.example.ojsystem.entity.Exam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamMapper {

    /**
     * 根据考试信息添加考试
     * 输入exam
     * 输出int
     */
    public int addExamInfo(@Param("exam") Exam exam);

    /**
     * 学生查询全部已发布考试信息
     * 输入无
     * 输出List<Exam>
     */
    public List<Exam> queryExamInfo(@Param("studentId") int studentId);



    /**
     * 教师查询自己的考试信息
     * 输入teacher
     * 输出List<Exam>
     */
    public List<Exam> teacherQueryExamInfo(@Param("teacherId") int teacherId);
    /**
     * 修改考试信息
     * 输入exam
     * 输出int
     */
    public int modifyExamInfo(@Param("exam") Exam exam);

    /**
     * 删除考试信息
     * 输入examId
     * 输出int
     */
    public int deleteExamInfo(@Param("examId") int examId);
}
