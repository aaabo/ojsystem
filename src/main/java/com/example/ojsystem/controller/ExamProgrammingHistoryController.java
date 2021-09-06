package com.example.ojsystem.controller;


import com.example.ojsystem.entity.ExamProgramming;
import com.example.ojsystem.entity.ExamProgrammingHistory;
import com.example.ojsystem.entity.Student;
import com.example.ojsystem.service.ExamProgrammingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/examProgrammingHistory")
public class ExamProgrammingHistoryController {

    @Autowired
    ExamProgrammingHistoryService examProgrammingHistoryService;
    /**
     * 根据学生id和考试编程信息添加考试编程题记录
     * 输入examProgrammingHistory
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/addExamProgrammingHistory",method = RequestMethod.GET)
    public Boolean addExamProgrammingHistory(HttpServletRequest request){
        int i=0;
        int studentId=Integer.valueOf(request.getParameter("studentId"));
        int examProgrammingId=Integer.valueOf(request.getParameter("examProgrammingId"));
        String examProgrammingCode=request.getParameter("examProgrammingCode");
        ExamProgrammingHistory examProgrammingHistory=new ExamProgrammingHistory();
        Student student=new Student();
        student.setStudentId(studentId);
        ExamProgramming examProgramming=new ExamProgramming();
        examProgramming.setExamProgrammingId(examProgrammingId);
        examProgrammingHistory.setStudent(student);
        examProgrammingHistory.setExamProgramming(examProgramming);
        examProgrammingHistory.setExamProgrammingCode(examProgrammingCode);
        i=examProgrammingHistoryService.addExamProgrammingHistory(examProgrammingHistory);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
