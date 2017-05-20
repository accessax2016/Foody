package com.example.thanhtung.foody.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.thanhtung.foody.R;

/**
 * Created by Thanh Tung on 5/20/2017.
 */

public class ThietLapTaiKhoan extends Activity {
    ImageView back_thietlap;
    LinearLayout loAnhDaiDien;
    LinearLayout loMatKhau;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_dat_tk__main);

        back_thietlap = (ImageView) findViewById(R.id.back_thietlap);
        loAnhDaiDien = (LinearLayout) findViewById(R.id.loAnhDaiDien);
        loMatKhau = (LinearLayout) findViewById(R.id.loMatKhau);

        back_thietlap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        loAnhDaiDien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThietLapTaiKhoan.this, DoiHinhDaiDien.class);
                startActivity(intent);
            }
        });
        loMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThietLapTaiKhoan.this, DoiMatKhau.class);
                startActivity(intent);
            }
        });
    }
}
