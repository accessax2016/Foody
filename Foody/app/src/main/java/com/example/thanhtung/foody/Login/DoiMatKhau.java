package com.example.thanhtung.foody.Login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.thanhtung.foody.FoodyRestClient;
import com.example.thanhtung.foody.MainActivity;
import com.example.thanhtung.foody.R;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;

import static com.example.thanhtung.foody.MainActivity.user;

/**
 * Created by Thanh Tung on 5/20/2017.
 */

public class DoiMatKhau extends Activity {
    ProgressDialog prgDialog;
    ImageView back_doipass;
    EditText edt_oldpass;
    EditText edit_passnew;
    EditText edit_confirm;
    Button btn_luuthaydoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_pass_word);

        back_doipass = (ImageView) findViewById(R.id.back_doipass);
        edt_oldpass = (EditText) findViewById(R.id.edt_oldpass);
        edit_passnew = (EditText) findViewById(R.id.edit_passnew);
        edit_confirm = (EditText) findViewById(R.id.edit_confirm);
        btn_luuthaydoi = (Button) findViewById(R.id.btn_luuthaydoi);

        back_doipass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_luuthaydoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current_password = edt_oldpass.getText().toString();
                String new_password = edit_passnew.getText().toString();
                String confirm_password = edit_confirm.getText().toString();

                prgDialog = new ProgressDialog(DoiMatKhau.this);
                prgDialog.setMessage("Vui lòng chờ ...");
                prgDialog.setCancelable(false);
                getDoiMatKhau(current_password, new_password, confirm_password);
            }
        });
    }
    public void getDoiMatKhau(String current_password, final String new_password, String confirm_password) {

        RequestParams params = new RequestParams();
        if(Utility.isNotNull(current_password) && Utility.isNotNull(new_password) && Utility.isNotNull(confirm_password)){
            if(Utility.validateString(user.getMatKhau(), current_password)) {
                if (Utility.validatePaswordLength(new_password)) {
                    if (Utility.validatePasword(new_password, confirm_password)) {
                        prgDialog.show();
                        params.put("TaiKhoan", user.getTaiKhoan());
                        params.put("MatKhau", current_password);
                        params.put("MatKhauMoi", new_password);
                        FoodyRestClient doimatkhau = new FoodyRestClient();
                        doimatkhau.changepassword(getApplicationContext(), "/api/TaiKhoan/DoiMatKhau", params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                                try {
                                    Boolean register= Boolean.valueOf(new String(responseBody,"UTF-8"));
                                    if (register) {
                                        Toast.makeText(getApplicationContext(), "Đổi Mật Khẩu Thành Công", Toast.LENGTH_LONG).show();
                                        //Cập nhât mật khẩu
                                        user.setMatKhau(new_password);
                                        //Về trang chủ
                                        Intent intent = new Intent(DoiMatKhau.this, MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), "Đổi Mật Khẩu Thất Bại", Toast.LENGTH_LONG).show();
                                    }
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                prgDialog.dismiss();
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                Toast.makeText(getApplicationContext(), "Kết Nối Thất Bại", Toast.LENGTH_LONG).show();
                                prgDialog.dismiss();
                            }
                        });
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Xác nhận mật khẩu sai", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Mật khẩu phải có ít nhất 4 ký tự", Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(getApplicationContext(), "Mật khẩu hiện tại không đúng", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_LONG).show();
        }
    }
}
