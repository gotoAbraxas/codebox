package com.naver.user.domain.dto;

public class SelectId {

    int uid;
    int tid;

    public SelectId(int uid, int tid) {
        this.uid = uid;
        this.tid = tid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
