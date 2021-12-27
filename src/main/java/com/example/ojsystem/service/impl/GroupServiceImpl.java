package com.example.ojsystem.service.impl;


import com.example.ojsystem.dao.ExamUserGroupHistoryMapper;
import com.example.ojsystem.dao.GroupMapper;
import com.example.ojsystem.dao.TestMapper;
import com.example.ojsystem.dao.UserGroupMapper;
import com.example.ojsystem.entity.Group;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    GroupMapper groupMapper;
    @Autowired
    TestMapper testMapper;
    @Autowired
    ExamUserGroupHistoryMapper examUserGroupHistoryMapper;

    /**
     * 获取学生组别信息并添加
     * 输入group
     * 成功输入true 失败输出false
     *
     * @param group
     */
    public int saveGroupInfo(Group group) {
        return groupMapper.insertGroupInfo(group);
    }

    /**
     * 删除组别信息
     * 输入groupId
     * 删除成功返回true 失败返回false
     *
     * @param groupId
     */
    public int cancelGroupInfo(int groupId) {
        testMapper.deleteTestInfoByGroupId(groupId);
        return groupMapper.deleteGroupInfo(groupId);
    }

    /**
     * 修改组别信息
     * 输入group users
     * 修改成功返回true 失败返回false
     *
     * @param group
     */
    public int alterGroupInfo(Group group) {
        examUserGroupHistoryMapper.updateExamUserGroupHistoryInfoByGroupId(group.getGroupId(),group.getGroupName());
        return groupMapper.updateGroupInfo(group);
    }

    /**
     * 获取组别信息
     * 输入无
     * 成功输出ist<Group>
     */
    public List<Group> checkGroupInfo() {
        List<Group> groups=new ArrayList<Group>();
        groups=groupMapper.selectGroupInfo();
        for(int i=0;i<groups.size();i++){
            Group group=groups.get(i);
            Integer o=groupMapper.selectGroupIsExamByGroupId(group.getGroupId());
            if(o!=null){
                group.setIsExam(true);
            }else{
                group.setIsExam(false);
            }
        }
        return groups;

    }

    /**
     * 根据输入groupId判断是否在考试或测试中
     * 输入groupId
     * 输出true 或者false
     *
     * @param groupId
     */
    public Boolean checkGroupIsExamByGroupId(int groupId) {
        Integer i=groupMapper.selectGroupIsExamByGroupId(groupId);
        if(i!=null){
            return true;
        }else{
            return false;
        }
    }
}
