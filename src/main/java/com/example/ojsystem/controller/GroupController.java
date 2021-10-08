package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Group;
import com.example.ojsystem.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;
    /**
     * 获取学生组别信息并添加
     * 输入group
     * 成功输入true 失败输出false
     */
    @RequestMapping(value="/addGroupInfo",method = RequestMethod.POST)
    public Object addGroupInfo(HttpServletRequest request){
        int i=0;
        Group group=new Group();
        group.setGroupName(request.getParameter("groupName"));
        i=groupService.addGroupInfo(group);
        if(i>0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 删除组别信息
     * 输入groupId
     * 删除成功返回true 失败返回false
     */
    @RequestMapping(value="/deleteGroupInfo",method = RequestMethod.POST)
    public Object deleteGroupInfo(HttpServletRequest request){
        int groupId=Integer.valueOf(request.getParameter("groupId"));
        int i=0;
        i=groupService.deleteGroupInfo(groupId);
        if(i>0){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * 修改组别信息
     * 输入group
     * 修改成功返回true 失败返回false
     */
    @RequestMapping(value="/modifyGroupInfo",method = RequestMethod.POST)
    public Object updateGroupInfo(HttpServletRequest request){

        int i=0;
        Group group=new Group();
        group.setGroupName(request.getParameter("groupName"));
        group.setGroupId(Integer.valueOf(request.getParameter("groupId")));
        i=groupService.modifyGroupInfo(group);
        if(i>0){
            return true;
        }
        else{
            return false;
        }
    }
}
