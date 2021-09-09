package com.example.ojsystem.dao;

import com.example.ojsystem.entity.Classes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesMapper {

    /**
     * 根据班级信息添加班级
     * 输入classes
     * 输出int
     */
    public int addClasses(@Param("classes") Classes classes);

    /**
     * 查询所用班级信息
     * 输入无
     * 输出List<Classes>
     */
    public List<Classes> queryClassesInfo();


    /**
     * 根据班级信息修改
     * 输入classes
     * 输出int
     */
    public int modifyClassesInfo(@Param("classes") Classes classes);

    /**
     * 根据班级id删除班级
     * 输入classesId
     * 输出int
     */
    public int deleteClasses(@Param("classesId") int classesId);
}
