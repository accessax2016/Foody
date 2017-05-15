package com.example.thanhtung.foody.Model;

import android.graphics.Bitmap;

/**
 * Created by Thanh Tung on 4/10/2017.
 */

public class MonAn {

    private Bitmap imgHinhMonAn;
    private String tvTenMonAn;
    private String tvTenQuanMonAn;
    private String tvDiaDiemQuanMonAn;
    private String tvTenDuong;

    public MonAn(Bitmap imgHinhMonAn, String tvTenMonAn, String tvTenQuanMonAn, String tvDiaDiemQuanMonAn, String tvTenDuong) {
        this.imgHinhMonAn = imgHinhMonAn;
        this.tvTenMonAn = tvTenMonAn;
        this.tvTenQuanMonAn = tvTenQuanMonAn;
        this.tvDiaDiemQuanMonAn = tvDiaDiemQuanMonAn;
        this.tvTenDuong = tvTenDuong;
    }

    public Bitmap getImgHinhMonAn() {
        return imgHinhMonAn;
    }

    public String getTvTenMonAn() {
        return tvTenMonAn;
    }

    public String getTvTenQuanMonAn() {
        return tvTenQuanMonAn;
    }

    public String getTvDiaDiemQuanMonAn() {
        return tvDiaDiemQuanMonAn;
    }

    public String getTvTenDuong() {
        return tvTenDuong;
    }

    public void setImgHinhMonAn(Bitmap imgHinhMonAn) {
        this.imgHinhMonAn = imgHinhMonAn;
    }

    public void setTvTenMonAn(String tvTenMonAn) {
        this.tvTenMonAn = tvTenMonAn;
    }

    public void setTvTenQuanMonAn(String tvTenQuanMonAn) {
        this.tvTenQuanMonAn = tvTenQuanMonAn;
    }

    public void setTvDiaDiemQuanMonAn(String tvDiaDiemQuanMonAn) {
        this.tvDiaDiemQuanMonAn = tvDiaDiemQuanMonAn;
    }

    public void setTvTenDuong(String tvTenDuong) {
        this.tvTenDuong = tvTenDuong;
    }
}
