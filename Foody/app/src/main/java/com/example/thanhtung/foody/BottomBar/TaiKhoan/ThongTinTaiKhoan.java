package com.example.thanhtung.foody.BottomBar.TaiKhoan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.thanhtung.foody.Login.YeuCauDangNhap;
import com.example.thanhtung.foody.R;

import static com.example.thanhtung.foody.MainActivity.Login;
import static com.example.thanhtung.foody.MainActivity.user;
import static com.example.thanhtung.foody.R.id.ll_2_1;
import static com.example.thanhtung.foody.R.id.ll_3_1;
import static com.example.thanhtung.foody.R.id.tv_DangXuat;

/**
 * Created by Thanh Tung on 4/10/2017.
 */

public class ThongTinTaiKhoan extends Fragment {
    ImageView iv_login;
    TextView tv_login;
    LinearLayout loDangNhap;
    LinearLayout lo_DangXuat;
    LinearLayout loThongTinLienHe;
    LinearLayout loThietLapTaiKhoan;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.taikhoan_main, container, false);

        loDangNhap = (LinearLayout) v.findViewById(R.id.loDangNhap);
        loThongTinLienHe = (LinearLayout) v.findViewById(ll_2_1);
        loThietLapTaiKhoan = (LinearLayout) v.findViewById(ll_3_1);
        lo_DangXuat = (LinearLayout) v.findViewById(tv_DangXuat);
        iv_login = (ImageView) v.findViewById(R.id.iv_login_1);
        tv_login = (TextView) v.findViewById(R.id.tv_login);

        if (Login) {
            Login();
        }
        else {
            NoLogin();
        }

        return v;
    }
    public void Login() {
        iv_login.setImageBitmap(user.getHinhDaiDien());
        tv_login.setText(user.getTenHienThi());
        loThongTinLienHe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        loThietLapTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        lo_DangXuat.setVisibility(View.VISIBLE);
        lo_DangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login = false;
                user = null;
            }
        });
    }
    public void NoLogin() {
        loDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), YeuCauDangNhap.class);
                startActivity(intent);
            }
        });
        lo_DangXuat.setVisibility(View.GONE);
    }
}
