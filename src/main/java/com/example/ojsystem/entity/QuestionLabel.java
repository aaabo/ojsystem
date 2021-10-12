package com.example.ojsystem.entity;


public class QuestionLabel {
    private int questionLabelId;
    private String chapter;
    private String firstKnowledgePoint;
    private String secondKnowledgePoint;

    public int getQuestionLabelId() {
        return questionLabelId;
    }

    public void setQuestionLabelId(int questionLabelId) {
        this.questionLabelId = questionLabelId;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getFirstKnowledgePoint() {
        return firstKnowledgePoint;
    }

    public void setFirstKnowledgePoint(String firstKnowledgePoint) {
        this.firstKnowledgePoint = firstKnowledgePoint;
    }

    public String getSecondKnowledgePoint() {
        return secondKnowledgePoint;
    }

    public void setSecondKnowledgePoint(String secondKnowledgePoint) {
        this.secondKnowledgePoint = secondKnowledgePoint;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(this==obj){
            return true;
        }
        if(obj instanceof QuestionLabel){
            QuestionLabel questionLabel=(QuestionLabel)obj;
            if(questionLabel.questionLabelId==this.questionLabelId&&questionLabel.chapter.equals(this.chapter)&&
                    firstKnowledgePoint.equals(this.firstKnowledgePoint)&&secondKnowledgePoint.equals(this.secondKnowledgePoint)){
                return true;
            }else{
                return false;
            }
        }
        return false;

    }



    @Override
    public String toString() {
        return "QuestionLabel{" +
                "questionLabelId=" + questionLabelId +
                ", chapter='" + chapter + '\'' +
                ", firstKnowledgePoint='" + firstKnowledgePoint + '\'' +
                ", secondKnowledgePoint='" + secondKnowledgePoint + '\'' +
                '}';
    }
}
