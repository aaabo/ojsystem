package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamProgrammingQuestionHistoryMapper;
import com.example.ojsystem.dao.ExamQuestionMapper;
import com.example.ojsystem.entity.ExamProgrammingQuestionHistory;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.judger.JudgerC;
import com.example.ojsystem.service.ExamProgrammingQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamProgrammingQuestionHistoryServiceImpl implements ExamProgrammingQuestionHistoryService {
    @Autowired
    ExamProgrammingQuestionHistoryMapper examProgrammingQuestionHistoryMapper;
    @Autowired
    ExamQuestionMapper examQuestionMapper;
    /**
     * 根据学生id和考试编程信息添加考试编程题记录
     * 输入examProgrammingHistory
     * 输出int
     *
     * @param examProgrammingQuestionHistory
     */
    public int addExamProgrammingQuestionHistoryInfo(ExamProgrammingQuestionHistory examProgrammingQuestionHistory,int userId,int examQuestionId) {
        Integer i=0;
        int examProgrammingQuestionId=0;
        //查询是否存在
        examProgrammingQuestionId=examProgrammingQuestionHistoryMapper.queryExamProgrammingQuestionHistoryByExamQuestionIdAndUserId(examQuestionId,userId);
        //判断
        String result= JudgerC.start(examProgrammingQuestionHistory.getExamProgrammingQuestionCode(),examQuestionMapper.queryExerciseAnswerInfoByExamQuestionId(examQuestionId));
        examProgrammingQuestionHistory.setExamProgrammingQuestionResult(result);
        //不存在
        if(examProgrammingQuestionId==0){
            User user=new User();
            user.setUserId(userId);
            examProgrammingQuestionHistory.setUser(user);
            i=examProgrammingQuestionHistoryMapper.addExamProgrammingQuestionHistory(examProgrammingQuestionHistory);
        }else{
            //存在就更新
            examProgrammingQuestionHistory.setExamProgrammingQuestionHistoryId(examProgrammingQuestionId);
            i=examProgrammingQuestionHistoryMapper.modifyExamProgrammingQuestionHistoryByExamProgrammingQuestionId(examProgrammingQuestionHistory);
        }
        return i;
    }


}
