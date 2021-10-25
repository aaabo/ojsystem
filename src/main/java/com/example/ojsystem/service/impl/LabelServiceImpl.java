package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.LabelMapper;
import com.example.ojsystem.entity.Label;
import com.example.ojsystem.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    LabelMapper labelMapper;

    /**
     * 获取标签信息并添加
     * 输入exerciseLabel
     * 成功输出true 失败输出false
     *
     * @param label
     */
    public int addLabelInfo(Label label) {
        return labelMapper.addLabelInfo(label);
    }

    /**
     * 获取全部标签信息
     * 输入无
     * 成功输出List<Label>
     */
    public List<Label> queryLabelInfo() {
        return labelMapper.queryLabelInfo();
    }

    /**
     * 获取习题标签所有一级分类信息
     * 输入无
     * 成功输出List<String>
     */
    public List<String> queryLabelFirstPointInfo() {
        return labelMapper.queryLabelFirstPointInfo();
    }

    /**
     * 获取习题标签所有二级分类信息
     * 输入无
     * 成功输出List<Label>
     */
    public List<Label> queryLabelSecondPointInfo(String firstPoint) {
        return labelMapper.queryLabelSecondPointInfo(firstPoint);
    }

    /**
     * 修改对应的标签信息
     * 输入label
     * 成功输出true 失败输出false
     *
     * @param label
     */
    public int modifyLabelInfo(Label label) {
        return labelMapper.modifyLabelInfo(label);
    }

    /**
     * 删除对应的标签信息
     * 输入labelId
     * 成功输出true 失败输出false
     *
     * @param labelId
     */
    public int deleteLabelInfo(int labelId) {
        return labelMapper.deleteLabelInfo(labelId);
    }
}
