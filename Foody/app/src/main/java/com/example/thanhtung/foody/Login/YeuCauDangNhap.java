package com.example.thanhtung.foody.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.thanhtung.foody.R;

import static com.example.thanhtung.foody.MainActivity.Login;

/**
 * Created by Thanh Tung on 5/14/2017.
 */

public class YeuCauDangNhap extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yeucaudangnhap_main);

        ImageView imgThoatKhoiManHinhDangNhap = (ImageView) findViewById(R.id.back_login);
        imgThoatKhoiManHinhDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Login=false;
                finish();
            }
        });

        Button btnDangKyTaiKhoan = (Button) findViewById(R.id.btnDangKyTaiKhoan);
        btnDangKyTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YeuCauDangNhap.this, DangKy.class);
                startActivity(intent);
            }
        });

        Button btnDangNhapVoiEmail = (Button) findViewById(R.id.btnLoginEmail);
        btnDangNhapVoiEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YeuCauDangNhap.this, DangNhapEmail.class);
                startActivity(intent);
            }
        });

        Button btnDangNhapVoiSDT = (Button) findViewById(R.id.btnDangNhapVoiSDT);
        btnDangNhapVoiSDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YeuCauDangNhap.this, DangNhapSDT.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        //Login=false;
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Login)
            finish();
    }
}
