package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamProgrammingAnswerMapper;
import com.example.ojsystem.entity.ExamProgrammingAnswer;
import com.example.ojsystem.service.ExamProgrammingAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
