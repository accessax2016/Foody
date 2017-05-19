package com.example.thanhtung.foody.Login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.thanhtung.foody.FoodyRestClient;
import com.example.thanhtung.foody.R;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Thanh Tung on 5/14/2017.
 */

public class DangKy extends Activity {
    ProgressDialog prgDialog;
    EditText etxtTaiKhoanMailDangKy;
    EditText etxtMatKhauDangKy;
    EditText etxtXacNhanMatKhau;
    EditText etxtTenHienThi;
    Button btnDangKyTaiKhoan;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangkythanhvien_main);

        ImageView imgThoatManHinhDangKy = (ImageView) findViewById(R.id.imgThoatManHinhDangKy);
        imgThoatManHinhDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        etxtTaiKhoanMailDangKy = (EditText) findViewById(R.id.etxtTaiKhoanMailDangKy);
        etxtMatKhauDangKy = (EditText) findViewById(R.id.etxtMatKhauDangKy);
        etxtXacNhanMatKhau = (EditText) findViewById(R.id.etxtXacNhanMatKhau);
        etxtTenHienThi = (EditText) findViewById(R.id.etxtTenHienThi);
        btnDangKyTaiKhoan = (Button) findViewById(R.id.btnDangKyTaiKhoan);

        btnDangKyTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = etxtTaiKhoanMailDangKy.getText().toString();
                String matkhau = etxtMatKhauDangKy.getText().toString();
                String xacnhanmatkhau = etxtXacNhanMatKhau.getText().toString();
                String tenhienthi = etxtTenHienThi.getText().toString();

                prgDialog = new ProgressDialog(DangKy.this);
                prgDialog.setMessage("Vui lòng chờ ...");
                prgDialog.setCancelable(false);
                DangKyTaiKhoan(taikhoan, matkhau, xacnhanmatkhau, tenhienthi);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    Boolean register = false;
    public void DangKyTaiKhoan(String Email, String Pass, String ConfirmPass, String Name){
        RequestParams params = new RequestParams();
        if(Utility.isNotNull(Email) && Utility.isNotNull(Pass) && Utility.isNotNull(Name)&& Utility.isNotNull(ConfirmPass)){
            if(Utility.validateEmail(Email)) {
                if(Utility.validatePaswordLength(Pass)) {
                    if(Utility.validatePasword(Pass, ConfirmPass)) {
                        prgDialog.show();
                        params.put("TaiKhoan", Email);
                        params.put("MatKhau", Pass);
                        params.put("TenHienThi", Name);
                        FoodyRestClient dangky = new FoodyRestClient();
                        dangky.register("/api/TaiKhoan/DangKyTaiKhoan", params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                                try {
                                    register= Boolean.valueOf(new String(responseBody,"UTF-8"));
                                    if (register) {
                                        //message = "Đăng Ký Thành Công";
                                        Toast.makeText(getApplicationContext(), "Đăng Ký Thành Công", Toast.LENGTH_LONG).show();
                                        finish();
                                    }
                                    else {
                                        //message = "Đăng Ký Thất Bại";
                                        Toast.makeText(getApplicationContext(), "Đăng Ký Thất Bại", Toast.LENGTH_LONG).show();
                                    }
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                prgDialog.dismiss();
                        }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                //message = "Kết Nối Thất Bại";
                                Toast.makeText(getApplicationContext(), "Kết Nối Thất Bại", Toast.LENGTH_LONG).show();
                                prgDialog.dismiss();
                            }
                        });
                    }
                    else {
                        //message = "Xác nhận mật khẩu sai";
                        Toast.makeText(getApplicationContext(), "Xác nhận mật khẩu sai", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    //message = "Mật khẩu phải có ít nhất 4 ký tự";
                    Toast.makeText(getApplicationContext(),  "Mật khẩu phải có ít nhất 4 ký tự", Toast.LENGTH_LONG).show();
                }
            }
            else {
                //message = "Định dạng Email sai";
                Toast.makeText(getApplicationContext(), "Định dạng Email sai", Toast.LENGTH_LONG).show();
            }
        }
        else {
            //message = "Vui lòng điền đầy đủ thông tin";
            Toast.makeText(getApplicationContext(), "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_LONG).show();
        }
    }
}
