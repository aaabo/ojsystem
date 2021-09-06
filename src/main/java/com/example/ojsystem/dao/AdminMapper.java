package com.example.ojsystem.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    /**
     * 根据输入的账号来查询管理员密码信息
     * 输入adminAccount
     * 输出查询到的管理员密码
     */
    public String adminLogin(@Param("adminAccount") String adminAccount);
}
