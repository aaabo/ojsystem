package com.example.ojsystem.dao;

import com.example.ojsystem.entity.Group;
import com.example.ojsystem.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMapper {
    /**
     * 获取组别信息并添加
     * 输入group
     * 成功输入true 失败输出false
     */
    public int insertGroupInfo(@Param("group") Group group);

    /**
     * 删除组别信息
     * 输入groupId
     * 删除成功返回true 失败返回false
     */
    public int deleteGroupInfo(int groupId);

    /**
     * 修改组别信息
     * 输入group users
     * 修改成功返回true 失败返回false
     */
    public int updateGroupInfo(Group group);
    /**
     * 获取组别信息
     * 输入无
     * 成功输出ist<Group>
     */
    public List<Group> selectGroupInfo();

    /**
     * 根据输入groupId判断是否在考试或测试中
     * 输入groupId
     * 输出true 或者false
     */
    public Integer selectGroupIsExamByGroupId(@Param("groupId") int groupId);
}
