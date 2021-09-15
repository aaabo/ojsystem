package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.StudentMapper;
import com.example.ojsystem.entity.Student;
import com.example.ojsystem.entity.StudentScoreTool;
import com.example.ojsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentMapper studentMapper;
    /**
     * 查询所有用户信息
     * 输入student
     * 输出存在学生true 不存在返回false
     *
     * @param student
     */
    public Student isStudentExist(Student student) {
        return studentMapper.isStudentExist(student);
    }

    /**
     * 根据学生账号查询学生信息判断是否注册过
     * 输入student
     * 输出注册过为true 没注册过返回false
     *
     * @param student
     */
    public Student isStudentInfoExist(Student student) {
        return studentMapper.isStudentInfoExist(student);
    }

    /**
     * 根据学生信息注册向数据库添加学生信息
     * 输入student
     * 输出int
     *
     * @param student
     */
    public int addStudentInfo(Student student) {
        return studentMapper.addStudentInfo(student);
    }

    /**
     * 根据学生id查询学生信息
     * 输入studentId
     * 输出Student
     *
     * @param studentId
     */
    public Student queryStudentInfoById(int studentId) {
        return studentMapper.queryStudentInfoById(studentId);
    }

    /**
     * 查询自己的学生信息
     * 输入studentId
     * 输出Student
     *
     * @param studentId
     */
    public Student queryStudentInfo(int studentId) {
        return studentMapper.queryStudentInfo(studentId);
    }

    /**
     * 根据学生id修改学生信息
     * 输入student
     * 输出int
     *
     * @param student
     */
    public int modifyStudentInfo(Student student) {
        return studentMapper.modifyStudentInfo(student);
    }

    /**
     * 根据学生id查询学生密码
     * 输入studentId
     * 输出studnetPassword
     *
     * @param studentId
     */
    public int queryStudentPasswordInfo(int studentId) {
        return studentMapper.queryStudentPasswordInfo(studentId);
    }

    /**
     * 根据学生id修改学生密码
     * 输入student
     * 输出int
     *
     * @param student
     */
    public int modifyPassword(Student student) {
        return studentMapper.modifyPassword(student);
    }

    /**
     * 查询学生排行榜
     * 输入无
     * 输出List<Student>
     */
    public List<Student> queryStudentRankListInfo() {
        return studentMapper.queryStudentRankListInfo();
    }

    /**
     * 修改学生提交信息
     * 输入solved 是否要添加解决问题次数 studnetId
     * 输出int
     *
     * @param solved
     */
    public int updateStudentSubmitInfo(int solved,int studentId) {
        return studentMapper.updateStudentSubmitInfo(solved,studentId);
    }


    /**
     * 通过考试id查询参加考试的学生信息
     * 输入examId
     * 输出 List<StudentScoreTool>
     *
     * @param examId
     */
    public List<StudentScoreTool> queryExamStudnetInfo(int examId) {
        return studentMapper.queryExamStudnetInfo(examId);
    }
}
