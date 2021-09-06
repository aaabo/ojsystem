package com.example.ojsystem.service;

import com.example.ojsystem.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     * 根据学生账号密码查询学生信息
     * 输入student
     * 输出Student
     */
    public Student isStudentExist(Student student);

    /**
     * 根据学生账号查询学生信息判断是否注册过
     * 输入student
     * 输出注册过为true 没注册过返回false
     */
    public Student isStudentInfoExist(Student student);

    /**
     * 根据学生信息注册向数据库添加学生信息
     * 输入student
     * 输出int
     */
    public int addStudentInfo(Student student);

    /**
     * 根据学生id查询学生信息
     * 输入studentId
     * 输出Student
     */
    public Student queryStudentInfoById(int studentId);

    /**
     * 查询自己的学生信息
     * 输入studentId
     * 输出Student
     */
    public Student queryStudentInfo(int studentId);


    /**
     * 根据学生id修改学生信息
     * 输入student
     * 输出int
     */
    public int modifyStudentInfo(Student student);


    /**
     * 根据学生id查询学生密码
     * 输入studentId
     * 输出studnetPassword
     */
    public int queryStudentPasswordInfo(int studentId);


    /**
     * 根据学生id修改学生密码
     * 输入student
     * 输出int
     */
    public int modifyPassword(Student student);

    /**
     * 查询学生排行榜
     * 输入无
     * 输出List<Student>
     */
    public List<Student> queryStudnetRankListInfo();

    /**
     * 修改学生提交信息
     * 输入solved 是否要添加解决问题次数  studnetId
     * 输出int
     */
    public int updateStudnetSubmitInfo(int solved,int studentId);


}
