package com.example.ojsystem.dao;

import com.example.ojsystem.entity.QuestionLabel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionLabelMapper {
    /**
     * 获取问题标签信息并添加
     * 输入questionLabel
     * 成功输出true 失败输出false
     */
    public int addQuestionLabelInfo(@Param("questionLabel") QuestionLabel questionLabel);

    /**
     * 获取全部的问题标签信息
     * 输入无
     * 成功输出List<QuestionLabel>
     */
    public List<QuestionLabel> queryQuestionLabelInfo();

    /**
     * 删除对应的问题标签信息
     * 输入questionLabelId
     * 成功输出true 失败输出false
     */
    public int deleteQuestionLabelInfo(@Param("questionLabelId") int questionLabelId);

    /**
     * 修改对应的问题标签信息
     * 输入questionLabel
     * 成功输出true 失败输出false
     */
    public int updateQuestionLabelInfo(@Param("questionLabel") QuestionLabel questionLabel);
}
