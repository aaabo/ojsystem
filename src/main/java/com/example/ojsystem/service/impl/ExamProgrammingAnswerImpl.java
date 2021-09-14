package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamProgrammingAnswerMapper;
import com.example.ojsystem.entity.ExamProgrammingAnswer;
import com.example.ojsystem.service.ExamProgrammingAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamProgrammingAnswerImpl implements ExamProgrammingAnswerService{

    @Autowired
    ExamProgrammingAnswerMapper examProgrammingAnswerMapper;
    /**
     * 根据上传的考试编程题答案来添加信息
     * 输入examProgrammingAnswer
     * 输出int
     *
     * @param examProgrammingAnswer
     */
    public int addExamProgrammingAnswer(ExamProgrammingAnswer examProgrammingAnswer) {
        return examProgrammingAnswerMapper.addExamProgrammingAnswer(examProgrammingAnswer);
    }

    /**
     * 根据上传的考试编程题答案信息来修改考试编程题答案信息
     * 输入examProgrammingAnswer
     * 输出int
     *
     * @param examProgrammingAnswer
     */
    public int modifyExamProgrammingAnswer(ExamProgrammingAnswer examProgrammingAnswer) {
        return examProgrammingAnswerMapper.modifyExamProgrammingAnswer(examProgrammingAnswer);
    }


    /**
     * 根据编程题id查询编程题答案
     * 输入ProgrammingId
     * 输出list
     *
     * @param programmingId
     */
    public List<ExamProgrammingAnswer> queryProgrammingAnswerInfoById(int programmingId){
        return examProgrammingAnswerMapper.queryProgrammingAnswerInfoById(programmingId);
    }

    /**
     * 根据上传的考试编程题答案id来删除考试编程题信息
     * 输入examProgrammingAnswerId
     * 输出int
     *
     * @param examProgrammingAnswerId
     */
    public int deleteExamProgrammingAnswer(int examProgrammingAnswerId) {
        return examProgrammingAnswerMapper.deleteExamProgrammingAnswer(examProgrammingAnswerId);
    }
}
