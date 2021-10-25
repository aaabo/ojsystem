package com.example.ojsystem.entity;

import java.util.List;

public class CompletionQuestion {
    private int completionQuestionId;
    private String completionQuestionDifficulty;
    private String completionQuestionDescription;
    private Boolean isPrivate;

    private User user;
    private List<CompletionQuestionAnswer> completionQuestionAnswers;
    private List<QuestionLabel> questionLabels;



    public int getCompletionQuestionId() {
        return completionQuestionId;
    }

    public void setCompletionQuestionId(int completionQuestionId) {
        this.completionQuestionId = completionQuestionId;
    }

    public String getCompletionQuestionDifficulty() {
        return completionQuestionDifficulty;
    }

    public void setCompletionQuestionDifficulty(String completionQuestionDifficulty) {
        this.completionQuestionDifficulty = completionQuestionDifficulty;
    }

    public String getCompletionQuestionDescription() {
        return completionQuestionDescription;
    }

    public void setCompletionQuestionDescription(String completionQuestionDescription) {
        this.completionQuestionDescription = completionQuestionDescription;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public List<CompletionQuestionAnswer> getCompletionQuestionAnswers() {
        return completionQuestionAnswers;
    }

    public void setCompletionQuestionAnswers(List<CompletionQuestionAnswer> completionQuestionAnswers) {
        this.completionQuestionAnswers = completionQuestionAnswers;
    }

    public List<QuestionLabel> getQuestionLabels() {
        return questionLabels;
    }

    public void setQuestionLabels(List<QuestionLabel> questionLabels) {
        this.questionLabels = questionLabels;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    @Override
    public String toString() {
        return "CompletionQuestion{" +
                "completionQuestionId=" + completionQuestionId +
                ", completionQuestionDifficulty='" + completionQuestionDifficulty + '\'' +
                ", completionQuestionDescription='" + completionQuestionDescription + '\'' +
                ", isPrivate=" + isPrivate +
                ", user=" + user +
                ", completionQuestionAnswers=" + completionQuestionAnswers +
                ", questionLabels=" + questionLabels +
                '}';
    }
}
