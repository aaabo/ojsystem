package com.example.ojsystem.controller;

import com.example.ojsystem.clustering.Kmeans;
import com.example.ojsystem.clustering.Point;
import com.example.ojsystem.dao.ExamHistoryMapper;
import com.example.ojsystem.entity.ExamHistory;
import com.example.ojsystem.entity.ExamUserJoinTool;
import com.example.ojsystem.service.ExamHistoryService;
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
@RequestMapping("/examHistory")
public class ExamHistoryController {
    @Autowired
    ExamHistoryService examHistoryService;
    /**
     * 根据考试Id查询考试排行榜
     * 输入examId
     * 输出List<ExamHistory>
     */
    @RequestMapping(value="/queryExamRankById",method = RequestMethod.POST)
    public Object queryExamRankById(HttpServletRequest request){
        return  examHistoryService.checkExamRankById(Integer.valueOf(request.getParameter("examId")));
    }


    /**
     * 根据用户Id查询参加的考试信息
     * 输入userId
     * 输出List<ExamHistory>
     */
    @RequestMapping(value="/queryExamHistoryInfoByUserId",method = RequestMethod.POST)
    public Object queryExamHistoryInfoByUserId(HttpServletRequest request){


        return  examHistoryService.checkExamHistoryInfoByUserId(Integer.valueOf(request.getParameter("userId")));
    }

    /**
     * 根据用户Id查询是否参加过对应的考试
     * 输入userId,examId
     * 输出List<ExamHistory>
     */
    @RequestMapping(value="/queryUserIfJoinExam",method = RequestMethod.POST)
    public Object queryUserIfJoinExam(HttpServletRequest request){
        String examId=request.getParameter("examId");
        int userId=(Integer) request.getSession().getAttribute("userId");

        return examHistoryService.checkUserIfJoinExam(userId,Integer.valueOf(examId));
    }
    /**
     * 查询考试用户参加情况   gai
     * 输入examId
     * 输出ExamUserJoinTool
     */
    @RequestMapping(value="/queryExamUserJoinInfo",method = RequestMethod.POST)
    public Object queryExamUserJoinInfo(HttpServletRequest request){
        return examHistoryService.checkExamUserJoinInfo(Integer.valueOf(request.getParameter("examId")));
    }

    /**
     通过考试id，用户id计算个人考试结果
     输入examid，userid
     */
    @RequestMapping(value = "/getExamResult", method = RequestMethod.POST)
    public Boolean addExamResult(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        int userId=Integer.valueOf(request.getParameter("userId"));
        int choice=0,completion=0,program=0;
        choice=  examHistoryService.checkExamChoiceQuestionResultScore(examId,userId);
        completion=  examHistoryService.checkExamCompletionQuestionResultScore(examId,userId);
        program=  examHistoryService.checkExamProgrammingQuestionResultScore(examId,userId);
        int i=2;
        i=examHistoryService.saveExamHistory(userId,examId,choice,completion,program);
        if(i!=2)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/getScoresOfExamQuestions",method = RequestMethod.POST)
    public Object queryScoresOfExamQuestions(HttpServletRequest request){
        int examId=Integer.valueOf(request.getParameter("examId"));
        int userId=Integer.valueOf(request.getParameter("userId"));
        int choice=0,completion=0,program=0;
        choice=  examHistoryService.checkExamChoiceQuestionResultScore(examId,userId);
        completion=  examHistoryService.checkExamCompletionQuestionResultScore(examId,userId);
        program=  examHistoryService.checkExamProgrammingQuestionResultScore(examId,userId);
        ExamHistory examHistory=new ExamHistory();
        examHistory.setExamChoiceQuestionTotals(choice);
        examHistory.setExamCompletionQuestionTotals(completion);
        examHistory.setExamProgrammingTotals(program);
        return examHistory;
    }

    /**
     * 查询考试结果信息
     * 输入examId
     * 输出List<ExamHistory>
     */
    @RequestMapping(value="/queryExamHistoryInfo",method = RequestMethod.POST)
    public Object queryExamHistoryInfo(HttpServletRequest request){
        List<Point> points=new ArrayList<Point>();
        List<ExamHistory> examHistories=examHistoryService.checkExamHistoryInfo(Integer.valueOf(request.getParameter("examId")));
        for(ExamHistory examHistory:examHistories){
            Point point=new Point();
            point.setBasicScore(new Float(examHistory.getExamChoiceQuestionTotals()+examHistory.getExamCompletionQuestionTotals()));
            point.setProgrammingScore(new Float(examHistory.getExamProgrammingTotals()));
            point.setUser(examHistory.getUser());
            points.add(point);
        }

        return Kmeans.run(points,4);
    }
}
