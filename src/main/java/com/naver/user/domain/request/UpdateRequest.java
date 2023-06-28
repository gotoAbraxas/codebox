package com.naver.user.domain.request;

public class UpdateRequest {
    private int id;
    private Integer uid;
    private String content;

    public UpdateRequest() {

    }

    public UpdateRequest(int id, Integer uid, String content) {
        this.id = id;
        this.uid = uid;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}