package com.example.ojsystem.tool;

import com.example.ojsystem.service.ExamChoiceQuestionHistoryService;
import com.example.ojsystem.service.ExamProgrammingQuestionHistoryService;
import com.example.ojsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentScoreToolController {
    @Autowired
    UserService studentService;
    @Autowired
    ExamChoiceQuestionHistoryService examChoiceQuestionHistoryService;
    @Autowired
    ExamProgrammingQuestionHistoryService examProgrammingHistoryService;
    @RequestMapping(value = "/examScore", method = RequestMethod.POST)
    public Object getStudentExamRank(HttpServletRequest request){


        return 0;
    }
}
