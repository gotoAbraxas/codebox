package com.naver.user.domain.dto;

public class Hearts {
    private int id;
    private int uid;
    private int tid;

    public Hearts(int id, int uid, int tid) {
        this.id = id;
        this.uid = uid;
        this.tid = tid;
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

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Hearts{" +
                "id=" + id +
                ", uid=" + uid +
                ", tid=" + tid +
                '}';
    }
}
