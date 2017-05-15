package com.example.thanhtung.foody.Login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.thanhtung.foody.R;

/**
 * Created by Thanh Tung on 5/15/2017.
 */

public class DangNhapEmail extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhapbangemail_main);

        ImageView imgThoatManHinhDangNhapVoiEmail = (ImageView) findViewById(R.id.imgThoatManHinhDangNhapVoiEmail);
        imgThoatManHinhDangNhapVoiEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
