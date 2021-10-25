package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Exam;
import com.example.ojsystem.entity.Group;
import com.example.ojsystem.entity.User;
import com.example.ojsystem.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    ExamService examService;

    /**
     * 根据考试信息添加考试
     * 输入exam
     * 输出新的examId
     */
    @RequestMapping(value="/addExamInfo",method = RequestMethod.POST)
    public int addClasses(HttpServletRequest request){
        int i=0;

        String examStartTime=request.getParameter("examStartTime");
        String examEndTime=request.getParameter("examEndTime");
        String examName=request.getParameter("examName");
        int userId=Integer.valueOf((Integer) request.getSession().getAttribute("userId"));
        int groupId=Integer.valueOf(request.getParameter("groupId"));
        String examStatus=request.getParameter("examStatus");
        String examLanguage=request.getParameter("examLanguage");
        Exam exam=new Exam();
        exam.setExamStartTime(examStartTime);
        exam.setExamEndTime(examEndTime);
        User user=new User();
        user.setUserId(userId);
        exam.setUser(user);
        Group group=new Group();
        group.setGroupId(groupId);
        exam.setGroup(group);
        exam.setExamStatus(examStatus);
        exam.setExamName(examName);
        exam.setExamLanguage(examLanguage);
        i=examService.addExamInfo(exam);
        if(i!=0){
            return exam.getExamId();
        }
        else{
            return 0;
        }
    }

    /**
     * 用户查询自己创建的的考试信息
     * 输入userId
     * 输出List<Exam>
     */
    @RequestMapping(value="/userQueryExamInfo",method = RequestMethod.POST)
    public Object userQueryExamInfo(HttpServletRequest request){
        return  examService.userQueryExamInfo((Integer) request.getSession().getAttribute("userId"));
    }


    /**
     * 查询全部的考试信息
     * 输入无
     * 输出List<Exam>
     */
    @RequestMapping(value="/queryExamInfo",method = RequestMethod.POST)
    public Object queryExamInfo(HttpServletRequest request){
        return  examService.queryExamInfo();
    }

    /**
     * 查询用户能参加的考试信息
     * 输入无
     * 输出List<Exam>
     */
    @RequestMapping(value="/queryExamInfoByUserId",method = RequestMethod.POST)
    public Object queryExamInfoByUserId(HttpServletRequest request){
        HttpSession session=request.getSession();
        return  examService.queryExamInfoByUserId((Integer)(session.getAttribute("userId")));
    }


    /**
     * 修改考试信息
     * 输入exam
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/modifyExamInfo",method = RequestMethod.POST)
    public Boolean modifyExamInfo(HttpServletRequest request){
        int i=0;
        int examId=Integer.valueOf(request.getParameter("examId"));
        String examStartTime=request.getParameter("examStartTime");
        String examEndTime=request.getParameter("examEndTime");
        String examName=request.getParameter("examName");
        int groupId=Integer.valueOf(request.getParameter("groupId"));
        String examLanguage=request.getParameter("examLanguage");
        Exam exam=new Exam();
        exam.setExamStartTime(examStartTime);
        exam.setExamEndTime(examEndTime);
        Group group=new Group();
        group.setGroupId(groupId);
        exam.setGroup(group);
        exam.setExamId(examId);
        exam.setExamLanguage(examLanguage);
        exam.setExamName(examName);
        i=examService.modifyExamInfo(exam);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 删除考试信息
     * 输入examId
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/deleteExamInfo",method = RequestMethod.POST)
    public Boolean deleteExamInfo(HttpServletRequest request){
        int i=0;
        i=examService.deleteExamInfo(Integer.valueOf(request.getParameter("examId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 修改考试状态
     * 输入exam
     * 输出成功返回true 失败返回false
     */
    @RequestMapping(value="/updateExamStatus",method = RequestMethod.POST)
    public Boolean updateExamType(HttpServletRequest request){
        int i=0;
        int examId=Integer.valueOf(request.getParameter("examId"));
        String examStatus=request.getParameter("examStatus");
        Exam exam=new Exam();
        exam.setExamId(examId);
        exam.setExamStatus(examStatus);
        i=examService.updateExamStatus(exam);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 根据考试id查询考试信息
     * 输入examId
     * 输出Exam
     */
    @RequestMapping(value="/queryExamInfoByExamId",method = RequestMethod.POST)
    public Object queryExamInfoByExamId(HttpServletRequest request){
        return examService.queryExamInfoByExamId(Integer.valueOf(request.getParameter("examId")));
    }


    /**
     * 查询未结束的考试信息
     * 输入null
     * 输出Exam
     */
    @RequestMapping(value="/queryNotFinishedExamInfo",method = RequestMethod.POST)
    public Object queryNotFinishedExamInfo(HttpServletRequest request){
        return examService.queryNotFinishedExamInfo();
    }


    /**
     * 通过考试名称,考试状态，创建人来查询考试信息
     * 输入exam
     * 输出 List<Exam>
     */
    @RequestMapping(value="/searchExamInfo",method = RequestMethod.POST)
    public Object searchExamInfo(HttpServletRequest request){
        String examName=request.getParameter("examName");
        String examStatus=request.getParameter("examStatus");
        String userName=request.getParameter("userName");
        Exam exam=new Exam();
        if(examName.equals("")){
            exam.setExamName(examName);
        }else{
            exam.setExamName("%"+examName+"%");
        }
        exam.setExamStatus(examStatus);
        User user=new User();
        if(userName.equals("")){
            user.setUserName(userName);
        }else{
            user.setUserName("%"+userName+"%");
        }
        exam.setUser(user);
        return examService.searchExamInfo(exam);
    }




}
