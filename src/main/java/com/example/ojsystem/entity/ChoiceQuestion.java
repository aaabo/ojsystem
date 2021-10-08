package com.example.ojsystem.entity;

import java.util.List;

public class ChoiceQuestion {
    private int choiceQuestionId;
    private String choiceQuestionDescription;
    private String choiceQuestionStemA;
    private String choiceQuestionStemB;
    private String choiceQuestionStemC;
    private String choiceQuestionStemD;
    private String choiceQuestionCorrectOption;
    private String choiceQuestionDifficulty;
    private Boolean isPrivate;

    private User user;
    private List<QuestionLabel> questionLabels;

    public int getChoiceQuestionId() {
        return choiceQuestionId;
    }

    public void setChoiceQuestionId(int choiceQuestionId) {
        this.choiceQuestionId = choiceQuestionId;
    }

    public String getChoiceQuestionDescription() {
        return choiceQuestionDescription;
    }

    public void setChoiceQuestionDescription(String choiceQuestionDescription) {
        this.choiceQuestionDescription = choiceQuestionDescription;
    }

    public String getChoiceQuestionStemA() {
        return choiceQuestionStemA;
    }

    public void setChoiceQuestionStemA(String choiceQuestionStemA) {
        this.choiceQuestionStemA = choiceQuestionStemA;
    }

    public String getChoiceQuestionStemB() {
        return choiceQuestionStemB;
    }

    public void setChoiceQuestionStemB(String choiceQuestionStemB) {
        this.choiceQuestionStemB = choiceQuestionStemB;
    }

    public String getChoiceQuestionStemC() {
        return choiceQuestionStemC;
    }

    public void setChoiceQuestionStemC(String choiceQuestionStemC) {
        this.choiceQuestionStemC = choiceQuestionStemC;
    }

    public String getChoiceQuestionStemD() {
        return choiceQuestionStemD;
    }

    public void setChoiceQuestionStemD(String choiceQuestionStemD) {
        this.choiceQuestionStemD = choiceQuestionStemD;
    }

    public String getChoiceQuestionCorrectOption() {
        return choiceQuestionCorrectOption;
    }

    public void setChoiceQuestionCorrectOption(String choiceQuestionCorrectOption) {
        this.choiceQuestionCorrectOption = choiceQuestionCorrectOption;
    }

    public String getChoiceQuestionDifficulty() {
        return choiceQuestionDifficulty;
    }

    public void setChoiceQuestionDifficulty(String choiceQuestionDifficulty) {
        this.choiceQuestionDifficulty = choiceQuestionDifficulty;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<QuestionLabel> getQuestionLabels() {
        return questionLabels;
    }

    public void setQuestionLabels(List<QuestionLabel> questionLabels) {
        this.questionLabels = questionLabels;
    }

    @Override
    public String toString() {
        return "ChoiceQuestion{" +
                "choiceQuestionId=" + choiceQuestionId +
                ", choiceQuestionDescription='" + choiceQuestionDescription + '\'' +
                ", choiceQuestionStemA='" + choiceQuestionStemA + '\'' +
                ", choiceQuestionStemB='" + choiceQuestionStemB + '\'' +
                ", choiceQuestionStemC='" + choiceQuestionStemC + '\'' +
                ", choiceQuestionStemD='" + choiceQuestionStemD + '\'' +
                ", choiceQuestionCorrectOption='" + choiceQuestionCorrectOption + '\'' +
                ", choiceQuestionDifficulty='" + choiceQuestionDifficulty + '\'' +
                ", isPrivate=" + isPrivate +
                ", user=" + user +
                ", questionLabels=" + questionLabels +
                '}';
    }
}
