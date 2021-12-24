package com.example.ojsystem.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamUserGroupHistoryMapper {

    /**
     * 根据考试结束时的组别信息添加考试组别信息的记录
     * 输入examId,userId
     * 输出int
     */
    public int insertExamUserGroupHistoryInfo(@Param("examId") int examId,@Param("userId") int userId);

    /**
     * 修改考试组别时
     * 输入examId,userId
     * 输出int
     */
    public int deleteExamUserGroupHistoryInfoByExamId(@Param("examId") int examId);

}
