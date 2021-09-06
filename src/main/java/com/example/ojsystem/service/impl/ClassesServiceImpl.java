package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.ClassesMapper;
import com.example.ojsystem.entity.Classes;
import com.example.ojsystem.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService{
    @Autowired
    ClassesMapper classesMapper;

    /**
     * 根据班级信息添加班级
     * 输入classes
     * 输出int
     *
     * @param classes
     */
    public int addClasses(Classes classes) {
        return classesMapper.addClasses(classes);
    }

    /**
     * 根据班级信息添加班级
     * 输入无
     * 输出List<Classes>
     */
    public List<Classes> queryClassesInfo() {
        return classesMapper.queryClassesInfo();
    }

    /**
     * 根据班级信息修改
     * 输入classes
     * 输出int
     *
     * @param classes
     */
    public int modifyClassesInfo(Classes classes) {
        return classesMapper.modifyClassesInfo(classes);
    }

    /**
     * 根据班级id删除班级
     * 输入classesId
     * 输出int
     *
     * @param classesId
     */
    public int deleteClasses(int classesId) {
        return classesMapper.deleteClasses(classesId);
    }
}
