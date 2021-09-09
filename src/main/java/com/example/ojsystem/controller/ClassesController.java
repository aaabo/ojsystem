package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Classes;
import com.example.ojsystem.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    ClassesService classesService;


    /**
     * 根据教师信息添加教师
     * 输入teacher
     * 输出新加的teacherId
     */
    @RequestMapping(value="/addClasses",method = RequestMethod.POST)
    public int addClasses(HttpServletRequest request){
        int i=0;
        String classesName=request.getParameter("classesName");
        Classes classes=new Classes();
        classes.setClassesName(classesName);
        i=classesService.addClasses(classes);
        if(i!=0){
            return classes.getClassesId();
        }
        else{
            return 0;
        }
    }




     /**
     * 查询所用班级信息
     * 输入无
     * 输出List<Classes>
     */
    @RequestMapping(value="/queryClassesInfo",method = RequestMethod.POST)
    public Object queryClassesInfo(HttpServletRequest request){
        return classesService.queryClassesInfo();
    }


    /**
     * 根据班级信息修改
     * 输入classes
     * 输出成功返回true失败返回false
     */
    @RequestMapping(value="/modifyClassesInfo",method = RequestMethod.POST)
    public Boolean modifyClassesInfo(HttpServletRequest request){
        int i=0;
        int classesId=Integer.valueOf(request.getParameter("classesId"));
        String classesName=request.getParameter("classesName");
        Classes classes=new Classes();
        classes.setClassesId(classesId);
        classes.setClassesName(classesName);
        i=classesService.modifyClassesInfo(classes);
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }



    /**
     * 根据班级id删除班级
     * 输入classesId
     * 输出int
     */
    @RequestMapping(value="/deleteClasses",method = RequestMethod.POST)
    public Boolean deleteClasses(HttpServletRequest request){
        int i=0;
        i=classesService.deleteClasses(Integer.valueOf(request.getParameter("classesId")));
        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
