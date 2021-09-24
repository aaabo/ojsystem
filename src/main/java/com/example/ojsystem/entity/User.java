package com.example.ojsystem.entity;

public class User {
    private int userId;
    private String userAccount;
    private String userPassword;
    private String userEmail;
    private String userName;
    private String userProfile;
    private int userSolved;
    private int userSubmit;
    private  String userIdentity;


    public User(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public int getUserSolved() {
        return userSolved;
    }

    public void setUserSolved(int userSolved) {
        this.userSolved = userSolved;
    }

    public int getUserSubmit() {
        return userSubmit;
    }

    public void setUserSubmit(int userSubmit) {
        this.userSubmit = userSubmit;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }


}
