package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.UserMapper;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    /**
     * 根据学生账号密码查询学生信息是否存在 用户登录
     * 输入user
     * 输出User
     *
     * @param user
     */
    public User isUserExist(User user) {
        return userMapper.isUserExist(user);
    }

    /**
     * 根据学生账号查询学生信息判断是否注册过
     * 输入user
     * 输出注册过为true 没注册过返回false
     *
     * @param user
     */
    public User isUserInfoExist(User user) {
        return userMapper.isUserInfoExist(user);
    }

    /**
     * 根据学生信息注册向数据库添加学生信息
     * 输入user
     * 输出int
     *
     * @param user
     */
    public int addUserInfo(User user) {
        return userMapper.addUserInfo(user);
    }

    /**
     * 根据用户id查询学生信息
     * 输入userId
     * 输出User
     *
     * @param userId
     */
    public User queryUserInfoById(int userId) {
        return userMapper.queryUserInfoById(userId);
    }



    /**
     * 根据用户id修改学生信息
     * 输入user
     * 输出int
     *
     * @param user
     */
    public int modifyUserInfo(User user) {
        return userMapper.modifyUserInfo(user);
    }

    /**
     * 根据用户id查询用户密码
     * 输入userId
     * 输出userPassword
     *
     * @param userId
     */
    public int queryUserPasswordInfo(int userId) {
        return userMapper.queryUserPasswordInfo(userId);
    }

    /**
     * 根据学生id修改学生密码
     * 输入user
     * 输出int
     *
     * @param user
     */
    public int modifyPassword(User user) {
        return userMapper.modifyPassword(user);
    }

    /**
     * 查询用户排行榜
     * 输入无
     * 输出List<User>
     */
    public List<User> queryUserRankListInfo() {
        return userMapper.queryUserRankListInfo();
    }

    /**
     * 修改用户提交信息
     * 输入solved 是否要添加解决问题次数  userId
     * 输出int
     *
     * @param solved
     */
    public int updateUserSubmitInfo(int solved,int userId) {
        return userMapper.updateUserSubmitInfo(solved,userId);
    }



}
