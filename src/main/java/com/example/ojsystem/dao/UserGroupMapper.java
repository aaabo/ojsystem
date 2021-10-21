package com.example.ojsystem.dao;

import com.example.ojsystem.entity.Group;
import com.example.ojsystem.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupMapper {
    /**
     * 获取组别的用户信息并添加
     * 输入groupId userAccount
     * 成功输入true 失败输出false
     */
    public int addUserGroupInfo(@Param("groupId") int groupId,@Param("userId") int userId);


    /**
     * 查看组别内的用户信息
     * 输入groupId
     * 成功输入true 失败输出false
     */
    public List<User> queryUserGroupInfoByGroupId(@Param("groupId")  int groupId);

    /**
     * 根据groupId和userId删除组别内的用户信息
     * 输入groupId和userId
     * 成功输入true 失败输出false
     */
    public int  deleteUserGroupInfoByUserGroupId(@Param("groupId") int groupId,@Param("userId")int userId);
}