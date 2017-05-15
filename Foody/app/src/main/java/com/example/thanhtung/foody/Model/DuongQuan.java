package com.example.thanhtung.foody.Model;

/**
 * Created by Thanh Tung on 4/10/2017.
 */

public class DuongQuan {
    private int MaDuong;
    private String TenDuong;

    public DuongQuan(int maDuong, String tenDuong) {
        MaDuong = maDuong;
        TenDuong = tenDuong;
    }

    public int getMaDuong() {
        return MaDuong;
    }

    public void setMaDuong(int maDuong) {
        MaDuong = maDuong;
    }

    public String getTenDuong() {
        return TenDuong;
    }

    public void setTenDuong(String tenDuong) {
        TenDuong = tenDuong;
    }
}
