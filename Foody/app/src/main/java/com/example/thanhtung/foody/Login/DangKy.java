package com.example.thanhtung.foody.Login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.thanhtung.foody.R;

/**
 * Created by Thanh Tung on 5/14/2017.
 */

public class DangKy extends Activity {
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
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
