package com.example.ojsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ojsystem.entity.Group;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userGroup")
public class UserGroupController {
    @Autowired
    UserGroupService userGroupService;
    /**
     * 获取组别的用户信息并添加
     * 输入groupId users
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/addUserGroupInfo",method = RequestMethod.POST)
    public Object addUserGroupInfo(HttpServletRequest request){
        int i=0;
        String selections = request.getParameter("userGroupInfo");
        JSONArray jsonArray=JSONArray.parseArray(selections);//把前台接收的string数组转化为json数组
        List<String> userAccounts = new ArrayList<String>();
        userAccounts= JSON.parseArray(String.valueOf(jsonArray.get(0)), String.class);
        Integer groupId=Integer.parseInt(String.valueOf(jsonArray.get(1)));

        for(int o=0;o<userAccounts.size();o++){
            i=userGroupService.saveUserGroupInfo(groupId,userAccounts.get(o));
            if(i==0){
                return userAccounts.get(o);
            }
        }
        if(i>0){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 查看组别内的用户信息
     * 输入groupId
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/queryUserGroupInfoByGroupId",method = RequestMethod.POST)
    public List<User> queryUserGroupInfoByGroupId(HttpServletRequest request){

        return userGroupService.checkUserGroupInfoByGroupId(Integer.valueOf(request.getParameter("groupId")));

    }

    /**
     * 根据groupId和userId删除组别内的用户信息
     * 输入groupId和userId
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/deleteUserGroupInfoByGroupIdAndUserId",method = RequestMethod.POST)
    public Object  removeUserGroupInfoByGroupIdAndUserId(HttpServletRequest request){
        int i=0;
        int userId=Integer.valueOf(request.getParameter("userId"));
        int groupId=Integer.valueOf(request.getParameter("groupId"));
        i=userGroupService.cancelUserGroupInfoByGroupIdAndUserId(groupId,userId);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }


    /**
     * 根据groupId和userId查看对应的用户是否在组别中
     * 输入groupId和userId
     * 成功查询输出true 失败输出false
     */
    @RequestMapping(value="/queryUserIfInGroup",method = RequestMethod.POST)
    public Object  queryUserIfInGroup(HttpServletRequest request){
        int i=0;
        int userId=(Integer)request.getSession().getAttribute("userId");
        int groupId=Integer.valueOf(request.getParameter("groupId"));
        i=userGroupService.checkUserIfInGroup(groupId,userId);

        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}
