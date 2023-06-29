package com.naver.user.domain.dto;

public class UpdateUser {

    private int uid;

    private String name;

    private String password;

    public UpdateUser(int uid, String name, String password) {
        this.uid = uid;
        this.name = name;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
