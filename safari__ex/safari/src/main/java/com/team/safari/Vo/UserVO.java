package com.team.safari.Vo;

public class UserVO {
    private String userId;
    private String Password;
    private String userName;
    private String email;
    private String Phone;

    public UserVO() {}

    public UserVO(String userId, String password, String userName, String email, String phone) {
        this.userId = userId;
        this.Password = password;
        this.userName = userName;
        this.email = email;
        this.Phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
}