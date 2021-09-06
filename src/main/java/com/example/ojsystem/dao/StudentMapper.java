package com.example.ojsystem.dao;

import com.example.ojsystem.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    /**
     * 根据学生账号密码查询学生信息
     * 输入student
     * 输出Student
     */
    public Student isStudentExist(@Param("student") Student student);


    /**
     * 根据学生账号查询学生信息判断是否注册过
     * 输入student
     * 输出注册过为true 没注册过返回false
     */
    public Student isStudentInfoExist(@Param("student") Student student);

    /**
     * 根据学生信息注册向数据库添加学生信息
     * 输入student
     * 输出int
     */
    public int addStudentInfo(@Param("student")Student student);

    /**
     * 根据学生id查询学生信息
     * 输入studentId
     * 输出Student
     */
    public Student queryStudentInfoById(@Param("studentId") int studentId);



    /**
     * 根据学生id修改学生信息
     * 输入student
     * 输出int
     */
    public int modifyStudentInfo(@Param("student") Student student);

    /**
     * 根据学生id查询学生密码
     * 输入studentId
     * 输出studnetPassword
     */
    public int queryStudentPasswordInfo(@Param("studentId") int studentId);


    /**
     * 根据学生id修改学生密码
     * 输入student
     * 输出int
     */
    public int modifyPassword(@Param("student")Student student);

    /**
     * 查询学生排行榜
     * 输入无
     * 输出List<Student>
     */
    public List<Student> queryStudnetRankListInfo();

    /**
     * 修改学生提交信息
     * 输入solved 添加解决问题次数
     * 输出int
     */
    public int updateStudnetSubmitInfo(@Param("solved") int solved,@Param("studentId") int studentId);

    /**
     * 查询自己的学生信息
     * 输入studentId
     * 输出Student
     */
    public Student queryStudentInfo(@Param("studentId") int studentId);
}
