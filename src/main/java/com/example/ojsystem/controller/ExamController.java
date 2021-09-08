package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Classes;
import com.example.ojsystem.entity.Exam;
import com.example.ojsystem.entity.Teacher;
import com.example.ojsystem.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    ExamService examService;

    /**
     * 根据考试信息添加考试
     * 输入exam
     * 输出新的examId
     */
    @RequestMapping(value="/addExamInfo",method = RequestMethod.POST)
    public int addClasses(HttpServletRequest request){
        int i=0;

        String examStartTime=request.getParameter("examStartTime");
        String examEndTime=request.getParameter("examEndTime");
        String examName=request.getParameter("examName");
        int teacherId=Integer.valueOf((Integer) request.getSession().getAttribute("teacherId"));
        int classesId=Integer.valueOf(request.getParameter("classesId"));
        String examType=request.getParameter("examType");
        String examLanguage=request.getParameter("examLanguage");
        Exam exam=new Exam();
        exam.setExamStartTime(examStartTime);
        exam.setExamEndTime(examEndTime);
        Teacher teacher=new Teacher();
        teacher.setTeacherId(teacherId);
        exam.setTeacher(teacher);
        Classes classes=new Classes();
        classes.setClassesId(classesId);
        exam.setClasses(classes);
        exam.setExamType(examType);
        exam.setExamName(examName);
        exam.setExamLanguage(examLanguage);
        i=examService.addExamInfo(exam);
        if(i!=0){
            return exam.getExamId();
        }
        else{
            return 0;
        }
    }

    /**
     * 教师查询自己的考试信息
     * 输入teacher
     * 输出List<Exam>
     */
    @RequestMapping(value="/teacherQueryExamInfo",method = RequestMethod.POST)
    public Object teacherQueryExamInfo(HttpServletRequest request){
        return  examService.teacherQueryExamInfo((Integer) request.getSession().getAttribute("teacherId"));
    }


    /**
     * 查询全部的考试信息
     * 输入无
     * 输出List<Exam>
     */
    @RequestMapping(value="/queryExamInfo",method = RequestMethod.POST)
    public Object queryExamInfo(HttpServletRequest request){
        return  examService.queryExamInfo();
    }

    /**
     * 查询学生能参加的考试信息
     * 输入无
     * 输出List<Exam>
     */
    @RequestMapping(value="/queryExamInfoByStudentId",method = RequestMethod.POST)
    public Object queryExamInfoByStudentId(HttpServletRequest request){
        return  examService.queryExamInfoByStudentId((Integer)request.getSession().getAttribute("studentId"));
    }


    /**
     * 修改考试信息
     * 输入exam
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/modifyExamInfo",method = RequestMethod.POST)
    public Boolean modifyExamInfo(HttpServletRequest request){
        int i=0;
        int examId=Integer.valueOf(request.getParameter("examId"));
        String examStartTime=request.getParameter("examStartTime");
        String examEndTime=request.getParameter("examEndTime");
        String examName=request.getParameter("examName");
        int classesId=Integer.valueOf(request.getParameter("classesId"));
        String examLanguage=request.getParameter("examLanguage");
        Exam exam=new Exam();
        exam.setExamStartTime(examStartTime);
        exam.setExamEndTime(examEndTime);
        Classes classes=new Classes();
        classes.setClassesId(classesId);
        exam.setClasses(classes);
        exam.setExamId(examId);
        exam.setExamLanguage(examLanguage);
        exam.setExamName(examName);
        i=examService.modifyExamInfo(exam);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 删除考试信息
     * 输入examId
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/deleteExamInfo",method = RequestMethod.POST)
    public Boolean deleteExamInfo(HttpServletRequest request){
        int i=0;
        i=examService.deleteExamInfo(Integer.valueOf(request.getParameter("examId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 修改考试状态
     * 输入exam
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/updateExamType",method = RequestMethod.POST)
    public Boolean updateExamType(HttpServletRequest request){
        int i=0;
        int examId=Integer.valueOf(request.getParameter("examId"));
        String examType=request.getParameter("examType");
        Exam exam=new Exam();
        exam.setExamId(examId);
        exam.setExamType(examType);
        i=examService.updateExamType(exam);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 查询考试信息
     * 输入examId
     * 输出Exam
     */
    @RequestMapping(value="/queryExamType",method = RequestMethod.POST)
    public Object queryExamType(HttpServletRequest request){
        return examService.queryExamType(Integer.valueOf(request.getParameter("examId")));
    }




}
