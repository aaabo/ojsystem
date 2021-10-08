package com.example.ojsystem.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceQuestionLabelMapper {
    /**
     * 获取选择题问题标签并保存
     * 输入questionLabel
     * 成功输出true 失败输出false
     */
    public int addChoiceQuestionLabelInfo(@Param("choiceQuestionId") int choiceQuestionId,@Param("questionLabelId") int questionLabelId);
}
