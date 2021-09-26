package com.example.ojsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties({" hibernateLazyInitializer","handler"})
public class UserTool {
    private List<User> users;
    private List<Group> groups;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "UserTool{" +
                "users=" + users +
                ", groups=" + groups +
                '}';
    }
}
