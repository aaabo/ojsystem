package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamProgrammingQuestionHistoryMapper;
import com.example.ojsystem.dao.ExamQuestionMapper;
import com.example.ojsystem.entity.ExamProgrammingQuestionHistory;
import com.example.ojsystem.entity.ExamQuestion;
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
    public int addExamProgrammingQuestionHistoryInfo(int examProgrammingQuestionScore,ExamProgrammingQuestionHistory examProgrammingQuestionHistory,int userId,int examQuestionId) {
        int i = 0;
        Integer examProgrammingQuestionId;
        //查询是否存在
        examProgrammingQuestionId = examProgrammingQuestionHistoryMapper.selectExamProgrammingQuestionHistoryByExamQuestionIdAndUserId(examQuestionId, userId);
        //判断
        String result = JudgerC.start(examProgrammingQuestionHistory.getExamProgrammingQuestionCode(), examQuestionMapper.selectExerciseAnswerInfoByExamQuestionId(examQuestionId));
        String score[] = result.split(","), resultWord, sc;
        float resultScore = 0;
        if (score[0] == "accept")  //compile error +msg,accept 1,wrong answer % 例子,time-limit exceeded % 例子 耗时
        {
            resultScore = examProgrammingQuestionScore;
            resultWord=result;
        }else if(score[0].equalsIgnoreCase("compile error")){
            resultWord=result;
        }
        else if(result.length()!=score[0].length()){        //逗号之后有数据  答案错误/超时
            resultWord=result;
            sc=score[1];
            resultScore=Float.parseFloat(sc)*examProgrammingQuestionScore;
        }else resultWord=result;

        examProgrammingQuestionHistory.setExamProgrammingQuestionResult(resultWord);
        examProgrammingQuestionHistory.setExamProgrammingQuestionResultScore(resultScore);
        //不存在
        if(examProgrammingQuestionId==null){
            User user=new User();
            ExamQuestion examQuestion=new ExamQuestion();
            examQuestion.setExamQuestionId(examQuestionId);
            user.setUserId(userId);
            examProgrammingQuestionHistory.setUser(user);
            examProgrammingQuestionHistory.setExamQuestion(examQuestion);
            i=examProgrammingQuestionHistoryMapper.insertExamProgrammingQuestionHistory(examProgrammingQuestionHistory);
        }else{
            //存在就更新
            examProgrammingQuestionHistory.setExamProgrammingQuestionHistoryId(examProgrammingQuestionId);
            i=examProgrammingQuestionHistoryMapper.updateExamProgrammingQuestionHistoryByExamProgrammingQuestionId(examProgrammingQuestionHistory);
        }
        return i;
    }
    public String checkExamProgrammingQuestionResultHistoryByExamQuestionIdAndUserId(int examQuestionId, int userId){
        return examProgrammingQuestionHistoryMapper.selectExamProgrammingQuestionResultHistoryByExamQuestionIdAndUserId(examQuestionId,userId);
    }
}