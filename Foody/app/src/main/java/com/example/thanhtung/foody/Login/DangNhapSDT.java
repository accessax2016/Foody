package com.example.thanhtung.foody.Login;

import android.app.Activity;
import android.os.Bundle;

import com.example.thanhtung.foody.R;

/**
 * Created by Thanh Tung on 5/15/2017.
 */

public class DangNhapSDT extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhapbangsdt_main);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
