package com.example.ojsystem.service;

import com.example.ojsystem.entity.Classes;

import java.util.List;

public interface ClassesService {
    /**
     * 根据班级信息添加班级
     * 输入classes
     * 输出int
     */
    public int addClasses(Classes classes);


    /**
     * 根据班级信息添加班级
     * 输入无
     * 输出List<Classes>
     */
    public List<Classes> queryClassesInfo();

    /**
     * 根据班级信息修改
     * 输入classes
     * 输出int
     */
    public int modifyClassesInfo(Classes classes);

    /**
     * 根据班级id删除班级
     * 输入classesId
     * 输出int
     */
    public int deleteClasses(int classesId);

}
