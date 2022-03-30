package com.example.phamtruong.haui.buoi7_sqlite;

public class Ghichu {
    int id;
    String nd;

    public Ghichu(int id, String nd) {
        this.id = id;
        this.nd = nd;
    }

    public Ghichu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }
}
