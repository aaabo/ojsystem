package com.example.ojsystem.dao;

import com.example.ojsystem.entity.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {
    /**
     * 根据输入的测试信息来添加测试
     * 输入test
     * 输出int
     */
    public int addTestInfo(@Param("test") Test test);
}
