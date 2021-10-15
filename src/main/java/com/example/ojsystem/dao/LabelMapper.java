package com.example.ojsystem.dao;

import com.example.ojsystem.entity.Label;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelMapper {
    /**
     * 获取标签信息并添加
     * 输入label
     * 成功输出true 失败输出false
     */
    public int addLabelInfo(@Param("label") Label label);

    /**
     * 获取全部标签信息
     * 输入无
     * 成功输出List<Label>
     */
    public List<Label> queryLabelInfo();

    /**
     * 获取习题标签所有一级分类信息
     * 输入无
     * 成功输出List<String>
     */
    public List<String> queryLabelFirstPointInfo();

    /**
     * 获取习题标签所有二级分类信息
     * 输入无
     * 成功输出List<Label>
     */
    public List<Label> queryLabelSecondPointInfo(@Param("firstPoint") String firstPoint);

    /**
     * 修改对应的标签信息
     * 输入label
     * 成功输出true 失败输出false
     */
    public int modifyLabelInfo(@Param("label") Label label);

    /**
     * 删除对应的标签信息
     * 输入exerciseLabelId
     * 成功输出true 失败输出false
     */
    public int deleteLabelInfo(@Param("labelId") int labelId);
}
