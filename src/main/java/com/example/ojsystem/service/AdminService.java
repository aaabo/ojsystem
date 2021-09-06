package com.example.ojsystem.service;

public interface AdminService {
    /**
     * 根据输入的账号来查询管理员密码信息
     * 输入adminAccount
     * 输出查询到的管理员密码
     */
    public String adminLogin(String adminAccount);
}
