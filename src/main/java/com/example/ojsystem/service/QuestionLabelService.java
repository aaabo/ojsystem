package com.example.ojsystem.service;

import com.example.ojsystem.entity.QuestionLabel;

import java.util.List;

public interface QuestionLabelService {
    /**
     * 获取问题标签信息并添加
     * 输入questionLabel
     * 成功输出true 失败输出false
     */
    public int addQuestionLabelInfo(QuestionLabel questionLabel);

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
    public int deleteQuestionLabelInfo(int questionLabelId);

    /**
     * 修改对应的问题标签信息
     * 输入questionLabel
     * 成功输出true 失败输出false
     */
    public int modifyQuestionLabelInfo(QuestionLabel questionLabel);

    /**
     * 获取全部的问题标签的章节信息(去重)
     * 输入无
     * 成功输出List<String>
     */
    public List<String> queryChapterInfo();

    /**
     * 获取全部的问题标签的章节信息查询第一知识点
     * 输入chapter
     * 成功输出List<String>
     */
    public List<String> queryFirstKnowledgePointInfoByChapter(String chapter);

    /**
     * 根据章节和第一知识点查询问题标签信息
     * 输入chapter firstKnowledgePoint
     * 成功输出List<QuestionLabel>
     */
    public List<QuestionLabel> querySecondKnowledgePointInfoByChapter(String chapter,String firstKnowledgePoint);
}
