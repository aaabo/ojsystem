package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.TeacherMapper;
import com.example.ojsystem.entity.Teacher;
import com.example.ojsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    TeacherMapper teacherMapper;

    /**
     * 根据教师信息添加教师
     * 输入teacher
     * 输出int
     *
     * @param teacher
     */
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    /**
     * 查询全部教师信息
     * 输入无
     * 输出 List<Teacher>
     */
    public List<Teacher> queryTeacherInfo() {
        return teacherMapper.queryTeacherInfo();
    }

    /**
     * 根据教师id查询教师信息
     * 输入teacherId
     * 输出 Teacher
     *
     * @param teacherId
     */
    public Teacher queryTeacherInfoById(int teacherId) {
        return teacherMapper.queryTeacherInfoById(teacherId);
    }

    /**
     * 修改教师信息
     * 输入teacher
     * 输出 int
     *
     * @param teacher
     */
    public int modifyTeacherInfo(Teacher teacher) {
        return teacherMapper.modifyTeacherInfo(teacher);
    }

    /**
     * 删除教师信息
     * 输入teacherId
     * 输出 int
     *
     * @param teacherId
     */
    public int deleteTeacher(int teacherId) {
        return teacherMapper.deleteTeacher(teacherId);
    }

    /**
     * 根据教师id和密码修改密码
     * 输入teacherId和teacherPassword
     * 输出 int
     *
     * @param teacherId
     * @param teacherPassword
     */
    public int modifyTeacherPassword(int teacherId, String teacherPassword) {
        return teacherMapper.modifyTeacherPassword(teacherId,teacherPassword);
    }

    /**
     * 根据教师id查询密码信息
     * 输入teacherId
     * 输出密码信息
     *
     * @param teacherId
     */
    public String queryTeacherPasswordInfo(int teacherId) {
        return teacherMapper.queryTeacherPasswordInfo(teacherId);
    }

    /**
     * 根据输入的账号来查询密码信息
     * 输入teacherAccount
     * 输出查询到的教师密码
     */
    public Teacher teacherLogin(String teacherAccount) {
        return teacherMapper.teacherLogin(teacherAccount);
    }
}
