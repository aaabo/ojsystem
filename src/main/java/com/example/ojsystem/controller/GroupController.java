package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Group;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;
    /**
     * 获取组别信息并添加
     * 输入group
     * 成功输入true 失败输出false
     */
    @RequestMapping(value="/addGroupInfo",method = RequestMethod.POST)
    public Object addGroupInfo(HttpServletRequest request){
        HttpSession session=request.getSession();
        int i=0;
        Group group=new Group();
        group.setGroupName(request.getParameter("groupName"));
        User user=new User();
        user.setUserId((Integer)session.getAttribute("userId"));
        group.setUser(user);
        i=groupService.saveGroupInfo(group);
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
    public Object removeGroupInfo(HttpServletRequest request){
        int groupId=Integer.valueOf(request.getParameter("groupId"));
        int i=0;
        i=groupService.cancelGroupInfo(groupId);

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
    public Object modifyGroupInfo(HttpServletRequest request){

        int i=0;
        Group group=new Group();
        group.setGroupName(request.getParameter("groupName"));
        group.setGroupId(Integer.valueOf(request.getParameter("groupId")));
        i=groupService.alterGroupInfo(group);
        if(i>0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 获取组别信息
     * 输入无
     * 成功输出ist<Group>
     */
    @RequestMapping(value="/queryGroupInfo",method = RequestMethod.POST)
    public Object queryGroupInfo(HttpServletRequest request){
        return groupService.checkGroupInfo();
    }



    /**
     * 根据输入groupId判断是否在考试或测试中
     * 输入groupId
     * 输出true 或者false
     */
    @RequestMapping(value="/queryGroupIsExamByGroupId",method = RequestMethod.POST)
    public Object queryGroupIsExamByGroupId(HttpServletRequest request){
        return groupService.checkGroupIsExamByGroupId(Integer.valueOf(request.getParameter("groupId")));
    }
}
