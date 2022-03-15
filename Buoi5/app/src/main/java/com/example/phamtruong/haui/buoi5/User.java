package com.example.phamtruong.haui.buoi5;

public class User {
    private String ma;
    private String ten;

    public User(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public User() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
