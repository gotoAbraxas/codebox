package com.naver.user.domain.request;

public class LikeRequest {

    private int tid;

    private int hearts;

    public LikeRequest(int tid, int hearts) {
        this.tid = tid;
        this.hearts = hearts;
    }

    public int getId() {
        return tid;
    }

    public void setId(int id) {
        this.tid = id;
    }

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }
}
