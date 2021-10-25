package com.example.ojsystem.entity;

public class Label {
    private int labelId;
    private String firstPoint;
    private String secondPoint;

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public String getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(String firstPoint) {
        this.firstPoint = firstPoint;
    }

    public String getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(String secondPoint) {
        this.secondPoint = secondPoint;
    }

    @Override
    public String toString() {
        return "Label{" +
                "labelId=" + labelId +
                ", firstPoint='" + firstPoint + '\'' +
                ", secondPoint='" + secondPoint + '\'' +
                '}';
    }
}
