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
    public int insertUserGroupInfo(@Param("groupId") int groupId,@Param("userId") int userId);


    /**
     * 查看组别内的用户信息
     * 输入groupId
     * 成功输入true 失败输出false
     */
    public List<User> selectUserGroupInfoByGroupId(@Param("groupId")  int groupId);

    /**
     * 根据groupId和userId删除组别内的用户信息
     * 输入groupId和userId
     * 成功输入true 失败输出false
     */
    public int  deleteUserGroupInfoByUserGroupId(@Param("groupId") int groupId,@Param("userId")int userId);

    /**
     * 根据groupId和userId查看对应的用户是否在组别中
     * 输入groupId和userId
     * 成功输入true 失败输出false
     */
    public Integer  selectUserIfInGroup(@Param("groupId") int groupId,@Param("userId")int userId);

    /**
     * 根据examId查询对应考试的全部用户信息
     * 输入examId
     * 输出List<User>
     */
    public List<User>  selectUserGroupInfoByExamId(@Param("examId")int examId);
}
