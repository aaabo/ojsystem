package com.example.ojsystem.controller;

import com.example.ojsystem.dao.ExamChoiceQuestionHistoryMapper;
import com.example.ojsystem.entity.ExamChoiceQuestion;
import com.example.ojsystem.entity.ExamChoiceQuestionHistory;
import com.example.ojsystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/examChoiceQuestionHistory")
public class ExamChoiceQuestionHistoryController {
    @Autowired
    ExamChoiceQuestionHistoryMapper examChoiceQuestionHistoryMapper;
    /**
     * 根据学生id 选择题id 学生选项添加学生选择题记录
     * 输入ExamChoiceQuestionHistory
     * 输出 成功返回true 失败返回false
     */
    @RequestMapping(value="/addExamChoiceQuestionHistory",method = RequestMethod.POST)
    public Boolean addExamChoiceQuestionHistory(HttpServletRequest request){
        int i=0;
        int studentId=Integer.valueOf(request.getParameter("studentId"));
        int examChoiceQuestionId=Integer.valueOf(request.getParameter("examChoiceQuestionId"));
        String examChoiceQuestionUserSelection=request.getParameter("examChoiceQuestionUserSelection");
        Student student=new Student();
        student.setStudentId(studentId);
        ExamChoiceQuestion examChoiceQuestion=new ExamChoiceQuestion();
        examChoiceQuestion.setExamChoiceQuestionId(examChoiceQuestionId);
        ExamChoiceQuestionHistory examChoiceQuestionHistory=new ExamChoiceQuestionHistory();
        examChoiceQuestionHistory.setExamChoiceQuestionUserSelection(examChoiceQuestionUserSelection);
        examChoiceQuestionHistory.setStudent(student);
        examChoiceQuestionHistory.setExamChoiceQuestion(examChoiceQuestion);
        i=examChoiceQuestionHistoryMapper.addExamChoiceQuestionHistory(examChoiceQuestionHistory);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
