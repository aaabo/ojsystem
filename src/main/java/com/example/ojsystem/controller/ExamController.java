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
        int teacherId=Integer.valueOf((Integer) request.getSession().getAttribute("teacherId"));
        int classesId=Integer.valueOf(request.getParameter("classesId"));
        Boolean examIsPublish=Boolean.valueOf(request.getParameter("examIsPublish"));
        int examChoiceTotals=Integer.valueOf(request.getParameter("examChoiceTotals"));
        int examProgrammingTotals=Integer.valueOf(request.getParameter("examProgrammingTotals"));
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
        exam.setExamIsPublish(examIsPublish);
        exam.setExamChoiceTotals(examChoiceTotals);
        exam.setExamProgrammingTotals(examProgrammingTotals);
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
        return  examService.teacherQueryExamInfo(1002);
    }


    /**
     * 学生查询全部已发布考试信息
     * 输入无
     * 输出List<Exam>
     */
    @RequestMapping(value="/queryExamInfo",method = RequestMethod.POST)
    public Object queryExamInfo(HttpServletRequest request){
        return  examService.queryExamInfo(1);
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
        int classesId=Integer.valueOf(request.getParameter("classesId"));
        int examChoiceTotals=Integer.valueOf(request.getParameter("examChoiceTotals"));
        int examProgrammingTotals=Integer.valueOf(request.getParameter("examProgrammingTotals"));
        String examLanguage=request.getParameter("examLanguage");
        Exam exam=new Exam();
        exam.setExamStartTime(examStartTime);
        exam.setExamEndTime(examEndTime);
        Classes classes=new Classes();
        classes.setClassesId(classesId);
        exam.setClasses(classes);
        exam.setExamId(examId);
        exam.setExamChoiceTotals(examChoiceTotals);
        exam.setExamProgrammingTotals(examProgrammingTotals);
        exam.setExamLanguage(examLanguage);
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




}
