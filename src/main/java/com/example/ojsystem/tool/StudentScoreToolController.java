package com.example.ojsystem.tool;

import com.example.ojsystem.entity.ExamChoiceQuestionHistory;
import com.example.ojsystem.entity.ExamProgrammingHistory;
import com.example.ojsystem.entity.StudentScoreTool;
import com.example.ojsystem.service.ExamChoiceQuestionHistoryService;
import com.example.ojsystem.service.ExamProgrammingHistoryService;
import com.example.ojsystem.service.StudentService;
import com.sun.deploy.net.HttpRequest;
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
    StudentService studentService;
    @Autowired
    ExamChoiceQuestionHistoryService examChoiceQuestionHistoryService;
    @Autowired
    ExamProgrammingHistoryService examProgrammingHistoryService;
    @RequestMapping(value = "/examScore", method = RequestMethod.POST)
    public Object getStudentExamRank(HttpServletRequest request){
        List<StudentScoreTool> studentScoreTools=new ArrayList<StudentScoreTool>();
        List<StudentScoreTool> studentScoreTool1=new ArrayList<StudentScoreTool>();
        List<StudentScoreTool> studentScoreTool2=new ArrayList<StudentScoreTool>();
        studentScoreTools=studentService.queryExamStudnetInfo(Integer.valueOf(request.getParameter("examId")));
        studentScoreTool1=examChoiceQuestionHistoryService.queryStudentExamChoiceScore(Integer.valueOf(request.getParameter("examId")));
        studentScoreTool2=examProgrammingHistoryService.queryStudentExamProgrammingScore(Integer.valueOf(request.getParameter("examId")));
        for(int i=0;i<studentScoreTools.size();i++){
            for(int o=0;o<studentScoreTool1.size();o++){
                if(studentScoreTools.get(i).getStudentId()==studentScoreTool1.get(o).getStudentId()){
                    studentScoreTools.get(i).setChoiceScore(studentScoreTool1.get(o).getChoiceScore());
                }
            }
            for(int o=0;o<studentScoreTool2.size();o++){

                if(studentScoreTools.get(i).getStudentId()==studentScoreTool2.get(o).getStudentId()){
                    studentScoreTools.get(i).setProgrammingScore(studentScoreTool2.get(o).getProgrammingScore());
                }
            }

            studentScoreTools.get(i).setTotalScore(studentScoreTools.get(i).getChoiceScore()+studentScoreTools.get(i).getProgrammingScore());


        }

        Collections.sort(studentScoreTools,new Comparator<Object>(){
            public int compare(Object o1, Object o2) {
                return ((StudentScoreTool) o2).getTotalScore() - ((StudentScoreTool) o1).getTotalScore();
            }
        });

        return studentScoreTools;
    }
}
