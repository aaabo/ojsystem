package com.example.ojsystem.service.impl;


import com.example.ojsystem.dao.GroupMapper;
import com.example.ojsystem.dao.UserGroupMapper;
import com.example.ojsystem.entity.Group;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    GroupMapper groupMapper;


    /**
     * 获取学生组别信息并添加
     * 输入group
     * 成功输入true 失败输出false
     *
     * @param group
     */
    public int addGroupInfo(Group group) {
        return groupMapper.addGroupInfo(group);
    }

    /**
     * 删除组别信息
     * 输入groupId
     * 删除成功返回true 失败返回false
     *
     * @param groupId
     */
    public int deleteGroupInfo(int groupId) {
        return groupMapper.deleteGroupInfo(groupId);
    }

    /**
     * 修改组别信息
     * 输入group users
     * 修改成功返回true 失败返回false
     *
     * @param group
     */
    public int modifyGroupInfo(Group group) {
        return groupMapper.modifyGroupInfo(group);
    }

    /**
     * 获取组别信息
     * 输入无
     * 成功输出ist<Group>
     */
    public List<Group> queryGroupInfo() {
        return groupMapper.queryGroupInfo();
    }
}