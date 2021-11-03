package com.example.ojsystem.service;

import com.example.ojsystem.entity.Test;

public interface TestService {
    /**
     * 根据输入的测试信息来添加测试
     * 输入test
     * 输出int
     */
    public int addTestInfo(Test test);
}
