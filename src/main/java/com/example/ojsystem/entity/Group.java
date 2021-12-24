package com.example.ojsystem.entity;

public class Group {
    private int groupId;
    private String groupName;
    private Boolean isExam;
    private User user;


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getIsExam() {
        return isExam;
    }

    public void setIsExam(Boolean isExam) {
        this.isExam = isExam;
    }
    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", user=" + user +
                '}';
    }
}
