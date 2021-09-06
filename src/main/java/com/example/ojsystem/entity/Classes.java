package com.example.ojsystem.entity;

public class Classes {
    private int classesId;
    private String classesName;

    public Classes(){

    }


    public Classes(int classesId, String classesName) {
        this.classesId = classesId;
        this.classesName = classesName;
    }

    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }
}
