package com.example.ojsystem.dao;

import com.example.ojsystem.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {
    /**
     * 根据教师信息添加教师
     * 输入teacher
     * 输出int
     */
    public int addTeacher(@Param("teacher") Teacher teacher);

    /**
     * 查询全部教师信息
     * 输入无
     * 输出 List<Teacher>
     */
    public List<Teacher> queryTeacherInfo();


    /**
     * 根据教师id查询教师信息
     * 输入teacherId
     * 输出 Teacher
     */
    public Teacher queryTeacherInfoById(@Param("teacherId") int teacherId);

    /**
     * 修改教师信息
     * 输入teacher
     * 输出 int
     */
    public int modifyTeacherInfo(@Param("teacher") Teacher teacher);


    /**
     * 删除教师信息
     * 输入teacherId
     * 输出 int
     */
    public int deleteTeacher(@Param("teacherId") int teacherId);


    /**
     * 根据教师id和密码修改密码
     * 输入teacherId和teacherPassword
     * 输出 int
     */
    public int modifyTeacherPassword(@Param("teacherId") int teacherId,@Param("teacherPassword")String teacherPassword);


    /**
     * 根据教师id查询密码信息
     * 输入teacherId
     * 输出密码信息
     */
    public String queryTeacherPasswordInfo(@Param("teacherId") int teacherId);


    /**
     * 根据输入的账号来查询密码信息
     * 输入teacherAccount
     * 输出查询到的教师密码
     */
    public Teacher teacherLogin(@Param("teacherAccount") String teacherAccount);
}
