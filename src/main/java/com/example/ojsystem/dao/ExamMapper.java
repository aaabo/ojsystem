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
     *查询用户能参加的考试信息
     * 输入无
     * 输出List<Exam>
     */
    public List<Exam> queryExamInfoByUserId(@Param("userId") int userId);


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
    public List<Exam> userQueryExamInfo(@Param("userId") int userId);
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

    /**
     * 修改考试状态
     * 输入exam
     * 输出int
     */
    public int updateExamType(@Param("exam") Exam exam);

    /**
     * 根据考试id查询考试信息
     * 输入examId
     * 输出Exam
     */
    public Exam queryExamInfoByExamId(@Param("examId") int examId);

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
    public List<Exam> searchExamInfo(@Param("exam") Exam exam);
}
