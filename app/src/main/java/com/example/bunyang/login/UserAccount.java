package com.example.bunyang.login;

public class UserAccount {
    private String idToken; // Firebase Uid (고유정보)
    private String emailId; // 이메일 아이디
    private String password; // 비밀번호
    private String name; //이름


    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
