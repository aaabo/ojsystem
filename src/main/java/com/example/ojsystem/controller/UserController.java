package com.example.ojsystem.controller;

import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 根据学生账号密码查询学生信息是否存在 用户登录
     * 输入user
     * 输出查询的student信息，若没有则返回false
     */
    @RequestMapping(value="/isUserExist",method = RequestMethod.POST)
    public Object queryUserExist(HttpServletRequest request){
        User user=new User();
        user.setUserAccount(request.getParameter("userAccount"));
        user.setUserPassword(request.getParameter("userPassword"));
        User userLogin=userService.checkUserExist(user);
        HttpSession session=request.getSession();
        if(userLogin==null){
            return false;
        }
        else {
            session.setAttribute("userId",userLogin.getUserId());
            return userLogin;
        }
    }


    /**
     * 根据学生账号查询学生信息判断是否注册过
     * 输入user
     * 输出注册过为true 没注册过返回false
     */
    @RequestMapping(value="/isUserInfoExist",method = RequestMethod.POST)
    public boolean queryUserInfoExist(HttpServletRequest request){
        User user=new User();
        user.setUserAccount(request.getParameter("userAccount"));
        User userLogin=userService.checkUserInfoExist(user);
        if(userLogin==null){
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * 根据学生信息注册向数据库添加学生信息
     * 输入user
     * 输出int
     */
    @RequestMapping(value="/addUserInfo",method = RequestMethod.POST)
    public Boolean addUserInfo(HttpServletRequest request){
        int i=0;
        User user=new User();
        String userAccount = request.getParameter("userAccount");
        String userPassword = request.getParameter("userPassword");
        String userEmail = request.getParameter("userEmail");
        String userName = request.getParameter("userName");
        user.setUserAccount(userAccount);
        user.setUserPassword(userPassword);
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        i=userService.saveUserInfo(user);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据教师信息注册向数据库添加教师信息
     * 输入teacherUser
     * 输出int
     */
    @RequestMapping(value="/addTeacherUserInfo",method = RequestMethod.POST)
    public Boolean addTeacherUserInfo(HttpServletRequest request){
        int i=0;
        User user=new User();
        String userAccount = request.getParameter("userAccount");
        String userPassword = request.getParameter("userPassword");
        String userName = request.getParameter("userName");
        user.setUserAccount(userAccount);
        user.setUserPassword(userPassword);
        user.setUserName(userName);
        i=userService.saveTeacherUserInfo(user);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 根据输入的教师信息修改数据库的教师信息
     * 输入teacherUser
     * 输出int
     */
    @RequestMapping(value="/modifyTeacherUserInfo",method = RequestMethod.POST)
    public Boolean modifyTeacherUserInfo(HttpServletRequest request){
        int i=0;
        User user=new User();
        String userPassword = request.getParameter("userPassword");
        String userName = request.getParameter("userName");
        int userId = Integer.valueOf(request.getParameter("userId"));
        user.setUserId(userId);
        user.setUserPassword(userPassword);
        user.setUserName(userName);
        i=userService.alterTeacherUserInfo(user);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 根据用户id删除用户
     * 输入userId
     * 输出int
     */
    @RequestMapping(value="/deleteUserInfoByUserId",method = RequestMethod.POST)
    public Boolean removeUserInfoByUserId(HttpServletRequest request){
        int i=0;
        i=userService.cancelUserInfoByUserId(Integer.valueOf(request.getParameter("userId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 根据用户id查询学生信息
     * 输入输入userId
     * 输出User
     */

    @RequestMapping(value="/queryUserInfoById",method = RequestMethod.POST)
    public Object queryUserInfoById(HttpServletRequest request){
        return userService.checkUserInfoById(Integer.valueOf(request.getParameter("userId")));
    }

    /**
     * 查询自己的信息
     * 输入userId
     * 输出User
     */
    @RequestMapping(value="/queryUserInfo",method = RequestMethod.POST)
    public Object queryStudentInfo(HttpServletRequest request){
        Object userId=request.getSession().getAttribute("userId");
        if(userId==null){
            return false;
        }
        else{
            return userService.checkUserInfoById((Integer)userId);
        }

    }

    /**
     * 根据用户id修改用户信息
     * 输入user
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/modifyUserInfo",method = RequestMethod.POST)
    public Boolean modifyUserInfo(HttpServletRequest request){
        int i=0;
        String userName=request.getParameter("userName");
        String userProfile=request.getParameter("userProfile");
        int userId=Integer.valueOf(request.getParameter("userId"));
        User user=new User();
        user.setUserName(userName);
        user.setUserId(userId);
        user.setUserProfile(userProfile);
        i=userService.alterUserInfo(user);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据用户id查询用户密码
     * 输入studentId
     * 输出studnetPassword
     */
    @RequestMapping(value="/queryUserPasswordInfo",method = RequestMethod.POST)
    public Object queryUserPasswordInfo(HttpServletRequest request){

        return userService.checkUserPasswordInfo((Integer)request.getSession().getAttribute("userId"));
    }



    /**
     * 根据用户id修改用户密码
     * 输入user
     * 输出int
     */
    @RequestMapping(value="/modifyPassword",method = RequestMethod.POST)
    public Boolean modifyPassword(HttpServletRequest request){
        int i=0;
        String userPassword=request.getParameter("userPassword");
        User user=new User();
        user.setUserPassword(userPassword);
        user.setUserId((Integer)request.getSession().getAttribute("userId"));
        i=userService.alterPassword(user);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 查询学生排行榜
     * 输入无
     * 输出List<User>
     */
    @RequestMapping(value="/queryUserRankListInfo",method = RequestMethod.POST)
    public Object queryUserRankListInfo(){
        return userService.checkUserRankListInfo();

    }

    /**
     * 修改用户提交信息
     * 输入solved 是否要添加解决问题次数  userId
     * 输出int
     */
    @RequestMapping(value="/updateUserSubmitInfo",method = RequestMethod.POST)
    public Boolean modifyUserSubmitInfo(HttpServletRequest request){
        int i=0;
        //studentSolve为1或0表示是否添加一次解决次数
        i=userService.alterUserSubmitInfo(Integer.valueOf(request.getParameter("studentSolve")),Integer.valueOf(request.getParameter("studentId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 查询全部教师用户
     * 输入无
     * 输出List<User>
     */
    @RequestMapping(value="/queryTeacherUserInfo",method = RequestMethod.POST)
    public Object queryTeacherUserInfo(HttpServletRequest request){
        return userService.checkTeacherUserInfo();
    }

    /**
     * 退出登录
     * 输入无
     * 输出无
     */
    @RequestMapping(value="/exitLogin",method = RequestMethod.POST)
    public void exitLogin(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute("userId");
    }
}
