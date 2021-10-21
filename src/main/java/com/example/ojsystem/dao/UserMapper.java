package com.example.ojsystem.dao;


import com.example.ojsystem.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * 根据学生账号密码查询学生信息是否存在 用户登录
     * 输入user
     * 输出User
     */
    public User isUserExist(@Param("user") User user);


    /**
     * 根据学生账号查询学生信息判断是否注册过
     * 输入user
     * 输出注册过为true 没注册过返回false
     */
    public User isUserInfoExist(@Param("user")  User user);

    /**
     * 根据学生信息注册向数据库添加学生信息
     * 输入user
     * 输出int
     */
    public int addUserInfo(@Param("user")User user);

    /**
     * 根据学生id查询学生信息
     * 输入userId
     * 输出User
     */
    public User queryUserInfoById(@Param("userId") int userId);



    /**
     * 根据用户id修改用户信息
     * 输入user
     * 输出int
     */
    public int modifyUserInfo(@Param("user") User user);

    /**
     * 根据用户id查询用户密码
     * 输入userId
     * 输出userPassword
     */
    public int queryUserPasswordInfo(@Param("userId") int userId);


    /**
     * 根据用户id修改用户密码
     * 输入user
     * 输出int
     */
    public int modifyPassword(@Param("user") User user);

    /**
     * 查询用户排行榜
     * 输入无
     * 输出List<User>
     */
    public List<User> queryUserRankListInfo();

    /**
     * 修改用户提交信息
     * 输入solved 是否要添加解决问题次数  userId
     * 输出int
     */
    public int updateUserSubmitInfo(@Param("solved") int solved,@Param("userId") int userId);


    /**
     * 查询全部教师用户
     * 输入无
     * 输出List<User>
     */
    public List<User> queryTeacherUserInfo();

    /**
     * 根据userAccount查询用户编号
     * 输入userAccount
     * 输出UserId
     */
    public int queryUserIdByUserAccount(@Param("userAccount") String userAccount);

}
