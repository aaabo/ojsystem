package com.example.ojsystem.dao;

import com.example.ojsystem.entity.QuestionLabel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChoiceQuestionLabelMapper {
    /**
     * 获取选择题问题标签并保存
     * 输入choiceQuestionId questionLabelId
     * 成功输出true 失败输出false
     */
    public int insertChoiceQuestionLabelInfo(@Param("choiceQuestionId") int choiceQuestionId,@Param("questionLabelId") int questionLabelId);

    /**
     * 获取选择题问题标签并保存
     * 输入choiceQuestionId
     * 成功List<QuestionLabel>
     */
    public List<QuestionLabel> queryChoiceQuestionLabelInfoByChoiceQuestionId(@Param("choiceQuestionId") int choiceQuestionId);

    /**
     * 根据获取的选择题标签id删除对应的选择题标签
     * 输入choiceQuestionId
     * 成功输出true 失败输出false
     */
    public int deleteChoiceQuestionLabelInfoByChoiceQuestionId(@Param("choiceQuestionId") int choiceQuestionId);

    /**
     * 在标签被删除时级联删除对应的选择题标签并修改为无标签状态
     * 输入questionLabelId
     * 成功输出true 失败输出false
     */
    public int updateChoiceQuestionLabelInfoToNullByQuestionLabelId(@Param("questionLabelId") int questionLabelId);
}
