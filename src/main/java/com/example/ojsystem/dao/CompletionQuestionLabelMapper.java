package com.example.ojsystem.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletionQuestionLabelMapper {
    /**
     * 获取填空题问题标签并保存
     * 输入completionQuestionId questionLabelId
     * 成功输出true 失败输出false
     */
    public int addCompletionQuestionLabelInfo(@Param("completionQuestionId") int completionQuestionId, @Param("questionLabelId") int questionLabelId);
}
