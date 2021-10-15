package com.example.ojsystem.service;

import com.example.ojsystem.entity.Label;

import java.util.List;

public interface LabelService {
    /**
     * 获取标签信息并添加
     * 输入exerciseLabel
     * 成功输出true 失败输出false
     */
    public int addLabelInfo(Label exerciseLabel);

    /**
     * 获取全部习题标签信息
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
    public List<Label> queryLabelSecondPointInfo(String firstPoint);

    /**
     * 修改对应的标签信息
     * 输入exerciseLabel
     * 成功输出true 失败输出false
     */
    public int modifyLabelInfo(Label exerciseLabel);

    /**
     * 删除对应的标签信息
     * 输入exerciseLabelId
     * 成功输出true 失败输出false
     */
    public int deleteLabelInfo(int exerciseLabelId);
}
