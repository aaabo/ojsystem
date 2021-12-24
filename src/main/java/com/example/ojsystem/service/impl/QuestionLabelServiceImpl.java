package com.example.ojsystem.service.impl;

import com.example.ojsystem.dao.*;
import com.example.ojsystem.entity.QuestionLabel;
import com.example.ojsystem.service.QuestionLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionLabelServiceImpl implements QuestionLabelService{
    @Autowired
    QuestionLabelMapper questionLabelMapper;
    @Autowired
    ChoiceQuestionLabelMapper choiceQuestionLabelMapper;
    @Autowired
    CompletionQuestionLabelMapper completionQuestionLabelMapper;
    @Autowired
    ExerciseLabelMapper exerciseLabelMapper;
    /**
     * 获取问题标签信息并添加
     * 输入questionLabel
     * 成功输出true 失败输出false
     *
     * @param questionLabel
     */
    public int saveQuestionLabelInfo(QuestionLabel questionLabel) {
        return questionLabelMapper.insertQuestionLabelInfo(questionLabel);
    }

    /**
     * 获取全部的问题标签信息
     * 输入无
     * 成功输出List<QuestionLabel>
     */
    public List<QuestionLabel> checkQuestionLabelInfo() {
        return questionLabelMapper.selectQuestionLabelInfo();
    }

    /**
     * 删除对应的问题标签信息
     * 输入questionLabelId
     * 成功输出true 失败输出false
     *
     * @param questionLabelId
     */
    public int cancelQuestionLabelInfo(int questionLabelId) {
        choiceQuestionLabelMapper.updateChoiceQuestionLabelInfoToNullByQuestionLabelId(questionLabelId);
        completionQuestionLabelMapper.updateCompletionQuestionLabelInfoToNullByQuestionLabelId(questionLabelId);
        exerciseLabelMapper.updateExerciseLabelInfoToNullByQuestionLabelId(questionLabelId);
        return questionLabelMapper.deleteQuestionLabelInfo(questionLabelId);
    }

    /**
     * 修改对应的问题标签信息
     * 输入questionLabel
     * 成功输出true 失败输出false
     *
     * @param questionLabel
     */
    public int alterQuestionLabelInfo(QuestionLabel questionLabel) {
        return questionLabelMapper.updateQuestionLabelInfo(questionLabel);
    }

    /**
     * 获取全部的问题标签的章节信息(去重)
     * 输入无
     * 成功输出List<String>
     */
    public List<String> checkChapterInfo() {
        return questionLabelMapper.selectChapterInfo();
    }

    /**
     * 获取全部的问题标签的章节信息查询第一知识点
     * 输入chapter
     * 成功输出List<String>
     *
     * @param chapter
     */
    public List<String> checkFirstKnowledgePointInfoByChapter(String chapter) {
        return questionLabelMapper.selectFirstKnowledgePointInfoByChapter(chapter);
    }

    /**
     * 根据章节和第一知识点查询问题标签信息
     * 输入chapter firstKnowledgePoint
     * 成功输出List<QuestionLabel>
     *
     * @param chapter
     * @param firstKnowledgePoint
     */
    public List<QuestionLabel> checkSecondKnowledgePointInfoByChapter(String chapter, String firstKnowledgePoint) {
        return questionLabelMapper.selectSecondKnowledgePointInfoByChapter(chapter,firstKnowledgePoint);
    }
}
