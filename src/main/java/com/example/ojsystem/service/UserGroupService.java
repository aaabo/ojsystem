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
    public int saveUserGroupInfo(int groupId,String userAccount);

    /**
     * 查看组别内的用户信息
     * 输入groupId
     * 成功输入true 失败输出false
     */
    public List<User> checkUserGroupInfoByGroupId(int groupId);

    /**
     * 根据groupId和userId删除组别内的用户信息
     * 输入groupId和userId
     * 成功输入true 失败输出false
     */
    public int  cancelUserGroupInfoByGroupIdAndUserId(int groupId,int userId);

    /**
     * 根据groupId和userId查看对应的用户是否在组别中
     * 输入groupId和userId
     * 成功输入true 失败输出false
     */
    public Integer  checkUserIfInGroup(int groupId,int userId);
}
