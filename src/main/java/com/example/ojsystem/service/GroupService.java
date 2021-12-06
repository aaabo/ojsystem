package com.example.ojsystem.service;

import com.example.ojsystem.entity.Group;
import com.example.ojsystem.entity.User;

import java.util.List;

public interface GroupService {
    /**
     * 获取组别信息并添加
     * 输入group
     * 成功输出true 失败输出false
     */
    public int saveGroupInfo(Group group);

    /**
     * 删除组别信息
     * 输入groupId
     * 删除成功返回true 失败返回false
     */
    public int cancelGroupInfo(int groupId);

    /**
     * 修改组别信息
     * 输入group
     * 修改成功返回true 失败返回false
     */
    public int alterGroupInfo(Group group);

    /**
     * 获取组别信息
     * 输入无
     * 成功输出ist<Group>
     */
    public List<Group> checkGroupInfo();
}
