package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.AdminMapper;
import com.example.ojsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper adminMapper;
    /**
     * 根据输入的账号来查询管理员密码信息
     * 输入adminAccount
     * 输出查询到的管理员密码
     *
     * @param adminAccount
     */
    public String adminLogin(String adminAccount) {
        return adminMapper.adminLogin(adminAccount);
    }
}
