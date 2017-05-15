package com.example.thanhtung.foody.Model;

/**
 * Created by Thanh Tung on 4/10/2017.
 */

public class QuanHuyen {
    private int MaQuan;
    private String TenQuan;

    public QuanHuyen(int maQuan, String tenQuan) {
        MaQuan = maQuan;
        TenQuan = tenQuan;
    }

    public int getMaQuan() {
        return MaQuan;
    }

    public void setMaQuan(int maQuan) {
        MaQuan = maQuan;
    }

    public String getTenQuan() {
        return TenQuan;
    }

    public void setTenQuan(String tenQuan) {
        TenQuan = tenQuan;
    }
}
