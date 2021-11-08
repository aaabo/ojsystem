package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.UserGroupMapper;
import com.example.ojsystem.dao.UserMapper;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupServiceImpl implements UserGroupService{
    @Autowired
    UserGroupMapper userGroupMapper;
    @Autowired
    UserMapper userMapper;
    /**
     * 获取组别的用户信息并添加
     * 输入groupId userAccount
     * 成功输入true 失败输出false
     *
     * @param groupId
     * @param userAccount
     */
    public int addUserGroupInfo(int groupId, String userAccount) {
        int userId=userMapper.queryUserIdByUserAccount(userAccount);
        return userGroupMapper.addUserGroupInfo(groupId,userId);
    }

    /**
     * 查看组别内的用户信息
     * 输入groupId
     * 成功输入true 失败输出false
     *
     * @param groupId
     */
    public List<User> queryUserGroupInfoByGroupId(int groupId) {
        return userGroupMapper.queryUserGroupInfoByGroupId(groupId);
    }

    /**
     * 根据groupId和userId删除组别内的用户信息
     * 输入groupId和userId
     * 成功输入true 失败输出false
     *
     * @param groupId
     * @param userId
     */
    public int deleteUserGroupInfoByGroupIdAndUserId(int groupId,int userId) {
        return userGroupMapper.deleteUserGroupInfoByUserGroupId(groupId,userId);
    }

    /**
     * 根据groupId和userId查看对应的用户是否在组别中
     * 输入groupId和userId
     * 成功输入true 失败输出false
     *
     * @param groupId
     * @param userId
     */
    public Integer queryUserIfInGroup(int groupId, int userId) {
        return userGroupMapper.queryUserIfInGroup(groupId,userId);
    }


}
