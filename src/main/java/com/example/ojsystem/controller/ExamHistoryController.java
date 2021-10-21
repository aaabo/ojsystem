package com.example.ojsystem.controller;

import com.example.ojsystem.dao.ExamHistoryMapper;
import com.example.ojsystem.entity.ExamHistory;
import com.example.ojsystem.service.ExamHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping(value="/queryExamRankById",method = RequestMethod.GET)
    public Object queryExamRankById(HttpServletRequest request){
        return  examHistoryService.queryExamRankById(Integer.valueOf(request.getParameter("examId")));
    }


    /**
     * 根据用户Id查询参加的考试信息
     * 输入userId
     * 输出List<ExamHistory>
     */
    @RequestMapping(value="/queryExamHistoryInfoByUserId",method = RequestMethod.GET)
    public Object queryExamHistoryInfoByUserId(HttpServletRequest request){
        return  examHistoryService.queryExamHistoryInfoByUserId(Integer.valueOf(request.getParameter("userId")));
    }

}
