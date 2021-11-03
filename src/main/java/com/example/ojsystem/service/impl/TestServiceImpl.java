package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.AdminMapper;
import com.example.ojsystem.dao.TestMapper;
import com.example.ojsystem.entity.Test;
import com.example.ojsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    TestMapper testMapper;

    /**
     * 根据输入的测试信息来添加测试
     * 输入test
     * 输出int
     *
     * @param test
     */
    public int addTestInfo(Test test) {
        return testMapper.addTestInfo(test);
    }
}
