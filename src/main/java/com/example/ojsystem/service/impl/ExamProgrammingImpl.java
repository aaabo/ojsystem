package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamProgrammingMapper;
import com.example.ojsystem.entity.ExamProgramming;
import com.example.ojsystem.service.ExamProgrammingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamProgrammingImpl implements ExamProgrammingService{
    @Autowired
    ExamProgrammingMapper examProgrammingMapper;
    /**
     * 根据考试编程题信息添加考试编程题
     * 输入ExamProgramming
     * 输出int
     *
     * @param examProgramming
     */
    public int addProgramExamInfo(ExamProgramming examProgramming) {
        return examProgrammingMapper.addProgramExamInfo(examProgramming);
    }

    /**
     *根据考试编程题信息修改考试编程题
     * 输入ExamProgramming
     * 输出int
     *
     * @param examProgramming
     */
    public int modifyProgramExamInfo(ExamProgramming examProgramming) {
        return examProgrammingMapper.modifyProgramExamInfo(examProgramming);
    }

    /**
     * 根据考试id查询全部考试编程题
     * 输入examId
     * 输出int
     *
     * @param examId
     */
    public List<ExamProgramming> queryProgrammingInfoById(int examId) {
        return examProgrammingMapper.queryProgrammingInfoById(examId);
    }

    /**
     * 根据考试编程题id删除考试编程题
     * 输入examProgrammingId
     * 输出int
     *
     * @param examProgrammingId
     */
    public int deleteProgramExamInfo(int examProgrammingId) {
        return examProgrammingMapper.deleteProgramExamInfo(examProgrammingId);
    }

    /**
     * 根据考试id查询考试编程题总分
     * 输入examId
     * 输出int
     *
     * @param examId
     */
    public int queryProgramExamTotalScoreInfo(int examId) {
        return examProgrammingMapper.queryProgramExamTotalScoreInfo(examId);
    }
}
