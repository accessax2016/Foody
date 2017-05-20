package com.example.thanhtung.foody.Login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.thanhtung.foody.FoodyRestClient;
import com.example.thanhtung.foody.MainActivity;
import com.example.thanhtung.foody.Model.TaiKhoan;
import com.example.thanhtung.foody.R;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static com.example.thanhtung.foody.MainActivity.Login;
import static com.example.thanhtung.foody.MainActivity.user;

/**
 * Created by Thanh Tung on 5/15/2017.
 */

public class DangNhapEmail extends Activity {
    ProgressDialog prgDialog;
    EditText etxtTaiKhoanMail;
    EditText etxtMatKhauMail;
    Button btnDangNhapBangMail;
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

        etxtTaiKhoanMail = (EditText) findViewById(R.id.etxtTaiKhoanMail);
        etxtMatKhauMail = (EditText) findViewById(R.id.etxtMatKhauMail);
        btnDangNhapBangMail = (Button) findViewById(R.id.btnDangNhapBangMail);
        btnDangNhapBangMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etxtTaiKhoanMail.getText().toString();
                String password = etxtMatKhauMail.getText().toString();

                prgDialog = new ProgressDialog(DangNhapEmail.this);
                prgDialog.setMessage("Vui lòng chờ ...");
                prgDialog.setCancelable(false);
                getDangNhap(email, password);
            }
        });
    }

    private void getDangNhap(String email, String password){
        prgDialog.show();
        RequestParams params = new RequestParams();
        params.put("TaiKhoan", email);
        params.put("MatKhau", password);
        FoodyRestClient dangnhap = new FoodyRestClient();
        dangnhap.login(getApplicationContext(), "api/TaiKhoan/DangNhapTaiKhoan", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        user = new TaiKhoan(response);
                        Log.d("Success", String.valueOf(statusCode));
                        if (!(user == null)) {
                            Login = true;
                            Toast.makeText(getApplicationContext(), "Đăng Nhập Thành Công", Toast.LENGTH_LONG).show();
                            prgDialog.dismiss();
                            //Về trang chủ
                            Intent intent = new Intent(DangNhapEmail.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(getApplicationContext(), "Đăng Nhập Thất Bại", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String errorResponse, Throwable throwable) {
                        Log.d("Failure", String.valueOf(statusCode));
                        Toast.makeText(getApplicationContext(), "Kết Nối Thất Bại", Toast.LENGTH_LONG).show();
                        prgDialog.dismiss();
                    }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
