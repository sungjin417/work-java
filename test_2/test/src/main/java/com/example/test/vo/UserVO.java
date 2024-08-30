package com.example.test.vo;

public class UserVO {
    private int userid;
    private String username;
    private String password; // 해시된 비밀번호
    private String email;
    private String phone;


    public int getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // 모든 필드를 초기화하는 생성자
    public UserVO(int userid, String username, String password, String email, String phone) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}


