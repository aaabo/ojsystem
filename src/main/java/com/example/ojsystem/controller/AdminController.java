package com.example.ojsystem.controller;

import com.example.ojsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    /**
     * 根据输入的账号来查询管理员密码信息
     * 输入adminAccount
     * 输出查询到的管理员密码
     */
    @RequestMapping(value="/adminLogin",method = RequestMethod.POST)
    public String adminLogin(HttpServletRequest request){
        return adminService.adminLogin(request.getParameter("adminAccount"));
    }
}
