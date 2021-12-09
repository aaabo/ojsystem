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
    public User checkUserExist(User user) {
        return userMapper.selectUserExist(user);
    }

    /**
     * 根据学生账号查询学生信息判断是否注册过
     * 输入user
     * 输出注册过为true 没注册过返回false
     *
     * @param user
     */
    public User checkUserInfoExist(User user) {
        return userMapper.selectUserInfoExist(user);
    }

    /**
     * 根据学生信息注册向数据库添加学生信息
     * 输入user
     * 输出int
     *
     * @param user
     */
    public int saveUserInfo(User user) {
        return userMapper.insertUserInfo(user);
    }

    /**
     * 根据教师信息注册向数据库添加教师信息
     * 输入teacherUser
     * 输出int
     *
     * @param user
     */
    public int saveTeacherUserInfo(User user) {
        return userMapper.insertTeacherUserInfo(user);
    }

    /**
     * 根据输入的教师信息修改数据库的教师信息
     * 输入teacherUser
     * 输出int
     *
     * @param user
     */
    public int alterTeacherUserInfo(User user) {
        return userMapper.updateTeacherUserInfo(user);
    }

    /**
     * 根据用户id删除用户
     * 输入userId
     * 输出int
     *
     * @param userId
     */
    public int cancelUserInfoByUserId(int userId) {
        return userMapper.deleteUserInfoByUserId(userId);
    }

    /**
     * 根据用户id查询学生信息
     * 输入userId
     * 输出User
     *
     * @param userId
     */
    public User checkUserInfoById(int userId) {
        return userMapper.selectUserInfoById(userId);
    }



    /**
     * 根据用户id修改学生信息
     * 输入user
     * 输出int
     *
     * @param user
     */
    public int alterUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }

    /**
     * 根据用户id查询用户密码
     * 输入userId
     * 输出userPassword
     *
     * @param userId
     */
    public int checkUserPasswordInfo(int userId) {
        return userMapper.selectUserPasswordInfo(userId);
    }

    /**
     * 根据用户id修改用户密码
     * 输入user
     * 输出int
     *
     * @param user
     */
    public int alterPassword(User user) {
        return userMapper.updatePassword(user);
    }

    /**
     * 查询用户排行榜
     * 输入无
     * 输出List<User>
     */
    public List<User> checkUserRankListInfo() {
        return userMapper.selectUserRankListInfo();
    }

    /**
     * 修改用户提交信息
     * 输入solved 是否要添加解决问题次数  userId
     * 输出int
     *
     * @param solved
     */
    public int alterUserSubmitInfo(int solved,int userId) {
        return userMapper.updateUserSubmitInfo(solved,userId);
    }

    /**
     * 查询全部教师用户
     * 输入无
     * 输出List<User>
     */
    public List<User> checkTeacherUserInfo() {
        return userMapper.selectTeacherUserInfo();
    }

    /**
     * 根据userAccount查询用户编号
     * 输入userAccount
     * 输出UserId
     */
    public int queryUserIdByUserAccount(String userAccount) {
        return userMapper.selectUserIdByUserAccount(userAccount);
    }



}
