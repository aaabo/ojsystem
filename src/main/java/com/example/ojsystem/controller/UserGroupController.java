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
     * 成功输入true 失败输出false
     */
    @RequestMapping(value="/addUserGroupInfo",method = RequestMethod.POST)
    public Object addUserGroupInfo(HttpServletRequest request){
        int i=0;
        String selections = request.getParameter("userGroupInfo");
        JSONArray jsonArray=JSONArray.parseArray(selections);//把前台接收的string数组转化为json数组
        List<User> users = new ArrayList<User>();
        users= JSON.parseArray(String.valueOf(jsonArray.get(0)), User.class);
        JSONObject jSONObject=JSONObject.parseObject(String.valueOf(jsonArray.get(1)));
        Group group=new Group();
        group=JSON.toJavaObject(jSONObject,Group.class);
        for(int o=0;o<users.size();o++){
            i=userGroupService.addUserGroupInfo(group.getGroupId(),users.get(o));
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
     * 成功输入true 失败输出false
     */
    @RequestMapping(value="/queryUserGroupInfoByGroupId",method = RequestMethod.POST)
    public List<User> queryUserGroupInfoByGroupId(HttpServletRequest request){

        return userGroupService.queryUserGroupInfoByGroupId(Integer.valueOf(request.getParameter("groupId")));

    }

    /**
     * 删除组别内的用户信息
     * 输入userGroupId
     * 成功输入true 失败输出false
     */
    @RequestMapping(value="/deleteUserGroupInfoByUserGroupId",method = RequestMethod.POST)
    public Object  deleteUserGroupInfoByUserGroupId(HttpServletRequest request){
        int i=0;
        int userGroupId=Integer.valueOf(request.getParameter("userGroupId"));
        i=userGroupService.deleteUserGroupInfoByUserGroupId(userGroupId);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}
