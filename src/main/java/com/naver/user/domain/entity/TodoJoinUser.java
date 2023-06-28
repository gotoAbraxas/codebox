package com.naver.user.domain.entity;

public class TodoJoinUser {

    private Integer id;

    private Integer uid;

    private String name;

    private String createAt;

    private String content;

    private boolean checked;

    private Integer heart;

    public TodoJoinUser(Integer id, Integer uid, String name, String createAt, String content, boolean checked, Integer heart) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.createAt = createAt;
        this.content = content;
        this.checked = checked;
        this.heart = heart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getHeart() {
        return heart;
    }

    public void setHeart(Integer heart) {
        this.heart = heart;
    }
}



