package com.example.thanhtung.foody.BottomBar.TaiKhoan;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.thanhtung.foody.Login.ThietLapTaiKhoan;
import com.example.thanhtung.foody.Login.YeuCauDangNhap;
import com.example.thanhtung.foody.MainActivity;
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
        if (!(user.getHinhDaiDien() == null)) //nếu chưa có hình thì sử dụng hình mặc định
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
                Intent intent = new Intent(getActivity(), ThietLapTaiKhoan.class);
                startActivity(intent);
            }
        });
        lo_DangXuat.setVisibility(View.VISIBLE);
        lo_DangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateDialogLogOut dialogLogOut = new CreateDialogLogOut();
                dialogLogOut.show(getFragmentManager(), "LogOut");
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
    public static class CreateDialogLogOut extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Bạn có muốn đăng xuất ?")
                    .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Login = false;
                            user = null;
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}
