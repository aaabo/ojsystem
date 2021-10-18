package com.example.ojsystem.service;

import com.example.ojsystem.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGroupService {
    /**
     * 获取组别的用户信息并添加
     * 输入groupId userAccount
     * 成功输入true 失败输出false
     */
    public int addUserGroupInfo(int groupId,int userAccount);

    /**
     * 查看组别内的用户信息
     * 输入groupId
     * 成功输入true 失败输出false
     */
    public List<User> queryUserGroupInfoByGroupId(int groupId);

    /**
     * 删除组别内的用户信息
     * 输入userGroupId
     * 成功输入true 失败输出false
     */
    public int  deleteUserGroupInfoByUserGroupId(int userGroupId);
}
