package com.example.thanhtung.foody.Model;


public class ThanhPho {

    private int MaTP;
    private String TenTP;

    public ThanhPho(int maTP, String tenTP) {
        this.MaTP = maTP;
        this.TenTP = tenTP;
    }

    public int getMaTP() {
        return MaTP;
    }

    public void setMaTP(int maTP) {
        MaTP = maTP;
    }

    public String getTenTP() {
        return TenTP;
    }

    public void setTenTP(String tenTP) {
        TenTP = tenTP;
    }
}
