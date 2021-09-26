package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.UserGroupMapper;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupServiceImpl implements UserGroupService{
    @Autowired
    UserGroupMapper userGroupMapper;

    /**
     * 获取组别的用户信息并添加
     * 输入groupId users
     * 成功输入true 失败输出false
     *
     * @param groupId
     * @param user
     */
    public int addUserGroupInfo(int groupId, User user) {
        return userGroupMapper.addUserGroupInfo(groupId,user);
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
     * 删除组别内的用户信息
     * 输入userGroupId
     * 成功输入true 失败输出false
     *
     * @param userGroupId
     */
    public int deleteUserGroupInfoByUserGroupId(int userGroupId) {
        return userGroupMapper.deleteUserGroupInfoByUserGroupId(userGroupId);
    }


}
