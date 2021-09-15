package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Classes;
import com.example.ojsystem.entity.Student;
import com.example.ojsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    /**
     * 查询所有用户信息
     * 输入student
     * 输出查询的student信息，若没有则返回null
     */
    @RequestMapping(value="/isStudentExist",method = RequestMethod.POST)
    public Object isStudentExist(HttpServletRequest request){
        Student student=new Student();
        student.setStudentAccount(request.getParameter("studentAccount"));
        student.setStudentPassword(request.getParameter("studentPassword"));
        Student studentLogin=studentService.isStudentExist(student);
        HttpSession session=request.getSession();
        if(studentLogin==null){
            return false;
        }
        else {
            session.setAttribute("studentId",studentLogin.getStudentId());
            return studentLogin;
        }
    }


    /**
     * 根据学生账号查询学生信息判断是否注册过
     * 输入student
     * 输出注册过为true 没注册过返回false
     */
    @RequestMapping(value="/isStudentInfoExist",method = RequestMethod.POST)
    public boolean isStudentInfoExist(HttpServletRequest request){
        Student student=new Student();
        student.setStudentAccount(request.getParameter("studentAccount"));
        Student studentLogin=studentService.isStudentInfoExist(student);
        if(studentLogin==null){
            return false;
        }
        else {
            return true;
        }
    }


    /**
     * 根据学生信息注册向数据库添加学生信息
     * 输入student
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/addStudentInfo",method = RequestMethod.POST)
    public Boolean addStudentInfo(HttpServletRequest request){
        int i=0;
        Student student=new Student();
        Classes classes=new Classes();
        classes.setClassesId(1);
        student.setClasses(classes);
        student.setStudentAccount("666666");
        student.setStudentPassword("777777");
        student.setStudentName("zhangsan");
        i=studentService.addStudentInfo(student);
        System.out.println(i);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据学生id查询学生信息
     * 输入studentId
     * 输出Student
     */

    @RequestMapping(value="/queryStudentInfoById",method = RequestMethod.POST)
    public Object queryStudentInfoById(HttpServletRequest request){
        return studentService.queryStudentInfoById(Integer.valueOf(request.getParameter("studentId")));
    }

    /**
     * 查询自己的学生信息
     * 输入studentId
     * 输出Student
     */
    @RequestMapping(value="/queryStudentInfo",method = RequestMethod.POST)
    public Object queryStudentInfo(HttpServletRequest request){
        Object studentId=request.getSession().getAttribute("studentId");
        if(studentId==null){
            return 0;
        }
        else{
            return studentService.queryStudentInfoById((Integer)studentId);
        }

    }

    /**
     * 根据学生id修改学生信息
     * 输入student
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/modifyStudentInfo",method = RequestMethod.POST)
    public Boolean modifyStudentInfo(HttpServletRequest request){
        int i=0;
        int classesId=Integer.valueOf(request.getParameter("classesId"));
        String studentName=request.getParameter("studentName");
        String studentProfile=request.getParameter("studentProfile");
        int studentId=Integer.valueOf(request.getParameter("studentId"));
        Student student=new Student();
        student.setStudentName(studentName);
        student.setStudentId(studentId);
        student.setStudentProfile(studentProfile);
        Classes classes=new Classes();
        classes.setClassesId(classesId);
        student.setClasses(classes);
        i=studentService.modifyStudentInfo(student);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据学生id查询学生密码
     * 输入studentId
     * 输出studnetPassword
     */
    @RequestMapping(value="/queryStudentPasswordInfo",method = RequestMethod.POST)
    public Object queryStudentPasswordInfo(HttpServletRequest request){

        return studentService.queryStudentPasswordInfo((Integer)request.getSession().getAttribute("studentId"));
    }



    /**
     * 根据学生id修改学生密码
     * 输入student
     * 输出int
     */
    @RequestMapping(value="/modifyPassword",method = RequestMethod.POST)
    public Boolean modifyPassword(HttpServletRequest request){
        int i=0;
        String studentPassword=request.getParameter("studentPassword");
        Student student=new Student();
        student.setStudentPassword(studentPassword);
        student.setStudentId((Integer)request.getSession().getAttribute("studentId"));
        i=studentService.modifyPassword(student);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 查询学生排行榜
     * 输入无
     * 输出List<Student>
     */
    @RequestMapping(value="/queryStudentRankListInfo",method = RequestMethod.POST)
    public Object queryStudentRankListInfo(){
        return studentService.queryStudentRankListInfo();

    }

    /**
     * 修改学生提交信息
     * 输入solved 是否要添加解决问题次数  studnetId
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/updateStudentSubmitInfo",method = RequestMethod.POST)
    public Boolean updateStudentSubmitInfo(HttpServletRequest request){
        int i=0;
        i=studentService.updateStudentSubmitInfo(Integer.valueOf(request.getParameter("studnetSolved")),Integer.valueOf(request.getParameter("studentId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
