package com.example.ojsystem.dao;

import com.example.ojsystem.entity.ExamProgrammingHistory;
import com.example.ojsystem.entity.StudentScoreTool;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamProgrammingHistoryMapper {
    /**
     * 根据学生id和考试编程信息添加考试编程题记录
     * 输入examProgrammingHistory
     * 输出int
     */
    public int addExamProgrammingHistory(@Param("examProgrammingHistory") ExamProgrammingHistory examProgrammingHistory);

    /**
     * 根据考试id查询所有学生的编程题分数
     * 输入examId
     * 输出List<StudentScoreTool>
     */
    public List<StudentScoreTool> queryStudentExamProgrammingScore(@Param("examId") int examId);
}
