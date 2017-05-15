package com.example.thanhtung.foody.Model;

import android.graphics.Bitmap;

/**
 * Created by Thanh Tung on 4/11/2017.
 */

public class DanhMuc {

    private Bitmap imgDanhMuc;
    private String tvDanhMuc;

    public DanhMuc(Bitmap imgDanhMuc, String tvDanhMuc) {
        this.imgDanhMuc = imgDanhMuc;
        this.tvDanhMuc = tvDanhMuc;
    }

    public Bitmap getImgDanhMuc() {
        return imgDanhMuc;
    }

    public void setImgDanhMuc(Bitmap imgDanhMuc) {
        this.imgDanhMuc = imgDanhMuc;
    }

    public String getTvDanhMuc() {
        return tvDanhMuc;
    }

    public void setTvDanhMuc(String tvDanhMuc) {
        this.tvDanhMuc = tvDanhMuc;
    }
//    int MaDanhMuc;
//    String TenDanhMuc;
//    Bitmap HinhDanhMuc;
//    int KieuDanhMuc;
//
//    public DanhMuc(int maDanhMuc, String tenDanhMuc, Bitmap hinhDanhMuc, int kieuDanhMuc) {
//        this.MaDanhMuc = maDanhMuc;
//        this.TenDanhMuc = tenDanhMuc;
//        this.HinhDanhMuc = hinhDanhMuc;
//        this.KieuDanhMuc = kieuDanhMuc;
//    }
//    public DanhMuc(JSONObject object) {
//        try {
//            this.MaDanhMuc = object.getInt("MaDanhMuc");
//            this.TenDanhMuc = object.getString("TenDanhMuc");
//            byte[] byteArray =  Base64.decode(object.getString("HinhDanhMuc"), Base64.DEFAULT) ;
//            this.HinhDanhMuc =  BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//            this.KieuDanhMuc = object.getInt("KieuDanhMuc");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public int getMaDanhMuc() {
//        return MaDanhMuc;
//    }
//
//    public void setMaDanhMuc(int maDanhMuc) {
//        this.MaDanhMuc = maDanhMuc;
//    }
//
//    public String getTenDanhMuc() {
//        return TenDanhMuc;
//    }
//
//    public void setTenDanhMuc(String tenDanhMuc) {
//        this.TenDanhMuc = tenDanhMuc;
//    }
//
//    public Bitmap getHinhDanhMuc() {
//        return HinhDanhMuc;
//    }
//
//    public void setHinhDanhMuc(Bitmap hinhDanhMuc) {
//        this.HinhDanhMuc = hinhDanhMuc;
//    }
//
//    public int getKieuDanhMuc() {
//        return KieuDanhMuc;
//    }
//
//    public void setKieuDanhMuc(int kieuDanhMuc) {
//        this.KieuDanhMuc = kieuDanhMuc;
//    }
}
