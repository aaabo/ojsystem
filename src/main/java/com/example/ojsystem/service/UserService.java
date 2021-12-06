package com.example.ojsystem.service;


import com.example.ojsystem.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /**
     * 根据用户账号密码查询学生信息是否存在 用户登录
     * 输入user
     * 输出User
     */
    public User checkUserExist(User user);

    /**
     * 根据用户账号查询学生信息判断是否注册过
     * 输入user
     * 输出注册过为true 没注册过返回false
     */
    public User checkUserInfoExist(User user);

    /**
     * 根据用户信息注册向数据库添加学生信息
     * 输入user
     * 输出int
     */
    public int saveUserInfo(User user);

    /**
     * 根据教师信息注册向数据库添加教师信息
     * 输入teacherUser
     * 输出int
     */
    public int saveTeacherUserInfo(User user);


    /**
     * 根据输入的教师信息修改数据库的教师信息
     * 输入teacherUser
     * 输出int
     */
    public int alterTeacherUserInfo(User user);

    /**
     * 根据用户id删除用户
     * 输入userId
     * 输出int
     */
    public int cancelUserInfoByUserId(int userId);

    /**
     * 根据用户id查询学生信息
     * 输入userId
     * 输出User
     */
    public User checkUserInfoById(int userId);



    /**
     * 根据用户id修改用户信息
     * 输入user
     * 输出int
     */
    public int alterUserInfo(User user);


    /**
     * 根据用户id查询用户密码
     * 输入userId
     * 输出userPassword
     */
    public int checkUserPasswordInfo(int userId);


    /**
     * 根据用户id修改用户密码
     * 输入user
     * 输出int
     */
    public int alterPassword(User user);

    /**
     * 查询用户排行榜
     * 输入无
     * 输出List<User>
     */
    public List<User> checkUserRankListInfo();

    /**
     * 修改用户提交信息
     * 输入solved 是否要添加解决问题次数  userId
     * 输出int
     */
    public int alterUserSubmitInfo(int solved,int userId);

    /**
     * 查询全部教师用户
     * 输入无
     * 输出List<User>
     */
    public List<User> checkTeacherUserInfo();

    /**
     * 根据userAccount查询用户编号
     * 输入userAccount
     * 输出UserId
     */
    public int queryUserIdByUserAccount(String userAccount);



}
