package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Teacher;
import com.example.ojsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    /**
     * 根据教师信息添加教师
     * 输入teacher
     * 输出新加的teacherId
     */
    @RequestMapping(value="/addTeacher",method = RequestMethod.POST)
    public int addTeacher(HttpServletRequest request){
        int i=0;
        String teacherAccount=request.getParameter("teacherAccount");
        String teacherPassword=request.getParameter("teacherPassword");
        String teacherName=request.getParameter("teacherName");
        Teacher teacher=new Teacher();
        teacher.setTeacherAccount(teacherAccount);
        teacher.setTeacherPassword(teacherPassword);
        teacher.setTeacherName(teacherName);
        i=teacherService.addTeacher(teacher);
        if(i!=0){
            return teacher.getTeacherId();
        }
        else{
            return 0;
        }
    }

    /**
     * 查询全部教师信息
     * 输入无
     * 输出 List<Teacher>
     */
    @RequestMapping(value="/queryTeacherInfo",method = RequestMethod.POST)
    public  Object  queryTeacherInfo(HttpServletRequest request){

        return teacherService.queryTeacherInfo();
    }


    /**
     * 根据教师id查询教师信息
     * 输入teacherId
     * 输出 Teacher
     * 修改教师信息
     */
    @RequestMapping(value="/queryTeacherInfoById",method = RequestMethod.POST)
    public  Object  queryTeacherInfoById(HttpServletRequest request){

        return teacherService.queryTeacherInfoById((Integer) request.getSession().getAttribute("teacherId"));
    }

    /**
     * 修改教师信息
     * 输入teacher
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/modifyTeacherInfo",method = RequestMethod.POST)
    public Boolean modifyTeacherInfo(HttpServletRequest request){
        int i=0;
        int teacherId=Integer.valueOf((Integer) request.getSession().getAttribute("teacherId"));
        String teacherName=request.getParameter("teacherName");
        Teacher teacher=new Teacher();
        teacher.setTeacherId(teacherId);
        teacher.setTeacherName(teacherName);
        i=teacherService.modifyTeacherInfo(teacher);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 输入teacher
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/deleteTeacher",method = RequestMethod.POST)
    public Boolean deleteTeacher(HttpServletRequest request){
        int i=0;
        int teacherId=Integer.valueOf(request.getParameter("teacherId"));
        i=teacherService.deleteTeacher(teacherId);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据教师id和密码修改密码
     * 输入teacherId和teacherPassword
     * 输出成功输出true失败输出false
     */
    @RequestMapping(value="/modifyTeacherPassword",method = RequestMethod.POST)
    public Boolean modifyTeacherPassword(HttpServletRequest request){
        int i=0;
        String teacherPassword=request.getParameter("teacherPassword");
        i=teacherService.modifyTeacherPassword((Integer) request.getSession().getAttribute("teacherId"),teacherPassword);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据教师id查询密码信息
     * 输入teacherId
     * 输出密码信息
     */
    @RequestMapping(value="/queryTeacherPasswordInfo",method = RequestMethod.POST)
    public String queryTeacherPasswordInfo(HttpServletRequest request){
        return teacherService.queryTeacherPasswordInfo((Integer) request.getSession().getAttribute("teacherId"));
    }


    /**
     * 根据输入的账号来查询密码信息
     * 输入teacherAccount
     * 输出查询到的教师密码
     */
    @RequestMapping(value="/teacherLogin",method = RequestMethod.POST)
    public Object teacherLogin(HttpServletRequest request){
        Teacher teacher= teacherService.teacherLogin(request.getParameter("teacherAccount"));
        HttpSession session=request.getSession();
        session.setAttribute("teacherId",teacher.getTeacherId());

        return teacher;
    }
}
