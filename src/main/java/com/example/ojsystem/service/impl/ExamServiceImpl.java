package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ExamMapper;
import com.example.ojsystem.dao.ExamUserGroupHistoryMapper;
import com.example.ojsystem.dao.UserGroupMapper;
import com.example.ojsystem.entity.Exam;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.ExamService;
import com.example.ojsystem.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService{
    @Autowired
    ExamMapper examMapper;
    @Autowired
    ExamUserGroupHistoryMapper examUserGroupHistoryMapper;
    @Autowired
    UserGroupMapper userGroupMapper;
    /**
     * 根据考试信息添加考试
     * 输入exam
     * 输出int
     *
     * @param exam
     */
    public int saveExamInfo(Exam exam) {
        int o=examMapper.insertExamInfo(exam);
        //添加一个考试用户信息记录
        List<User> users=userGroupMapper.selectUserGroupInfoByExamId(exam.getExamId());
        for(int i=0;i<users.size();i++){
            examUserGroupHistoryMapper.insertExamUserGroupHistoryInfo(exam.getExamId(),users.get(i).getUserId());
        }
        return o;
    }

    /**
     *查询用户能参加的考试信息
     * 输入userId
     * 输出List<Exam>
     */
    public List<Exam> checkExamInfoByUserId(int userId) {
        return examMapper.selectExamInfoByUserId(userId);
    }

    /**
     * 查询全部的考试信息
     * 输入无
     * 输出List<Exam>
     */
    public List<Exam> checkExamInfo() {
        return examMapper.selectExamInfo();
    }

    /**
     * 用户查询自己创建的的考试信息
     * 输入userId
     * 输出List<Exam>
     *
     * @param userId
     */
    public List<Exam> checkUserQueryExamInfo(int userId) {
        return examMapper.selectUserQueryExamInfo(userId);
    }

    /**
     * 修改考试信息
     * 输入exam
     * 输出int
     *
     * @param exam
     */
    public int alterExamInfo(Exam exam) {
        int o=examMapper.updateExamInfo(exam);
        //删除考试用户信息
        examUserGroupHistoryMapper.deleteExamUserGroupHistoryInfoByExamId(exam.getExamId());
        //添加一个考试用户信息记录
        List<User> users=userGroupMapper.selectUserGroupInfoByExamId(exam.getExamId());
        for(int i=0;i<users.size();i++){
            examUserGroupHistoryMapper.insertExamUserGroupHistoryInfo(exam.getExamId(),users.get(i).getUserId());
        }
        return o;
    }

    /**
     * 删除考试信息
     * 输入examId
     * 输出int
     *
     * @param examId
     */
    public int cancelExamInfo(int examId) {
        return examMapper.deleteExamInfo(examId);
    }

    /**
     * 修改考试状态
     * 输入exam
     * 输出int
     *
     * @param exam
     */
    public int alterExamStatus(Exam exam) {
        return examMapper.updateExamStatus(exam);
    }

    /**
     * 根据考试id查询考试信息
     * 输入examId
     * 输出Exam
     *
     * @param examId
     */
    public Exam checkExamInfoByExamId(int examId) {
        return examMapper.selectExamInfoByExamId(examId);
    }

    /**
     * 查询为结束的考试信息
     * 输入null
     * 输出Exam
     */
    public List<Exam> checkNotFinishedExamInfo() {
        return examMapper.selectNotFinishedExamInfo();
    }

    /**
     * 通过考试名称,考试状态，创建人来查询考试信息
     * 输入exam
     * 输出 List<Exam>
     *
     * @param exam
     */
    public List<Exam> checkSearchExamInfo(Exam exam) {
        return examMapper.selectSearchExamInfo(exam);
    }

}
