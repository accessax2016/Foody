package com.example.thanhtung.foody;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.thanhtung.foody.BottomBar.BoSuuTap.BoSuuTap;
import com.example.thanhtung.foody.BottomBar.NhaChinh.Home;
import com.example.thanhtung.foody.BottomBar.TaiKhoan.ThongTinTaiKhoan;
import com.example.thanhtung.foody.BottomBar.ThongBao.ThongBao;
import com.example.thanhtung.foody.BottomBar.TimKiem.TimKiem;
import com.example.thanhtung.foody.Model.TaiKhoan;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    final public static String DATABASE_NAME = "QuanLyFoodyDB.sqlite";
    public static SQLiteDatabase database;
    public static boolean Login = false; //nhớ sửa lại false
    public static TaiKhoan user= null;

    public static BottomBar mBottomBar;
    Fragment selectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomBar=(BottomBar)findViewById(R.id.bottombar);
        //sự kiện click giữa các tab trong bottombar
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        selectedFragment = new Home();
                        break;
                    case R.id.tab_collection:
                        selectedFragment = new BoSuuTap();
                        break;
                    case R.id.tab_search:
                        selectedFragment = new TimKiem();
                        break;
                    case R.id.tab_bell:
                        selectedFragment = new ThongBao();
                        break;
                    case R.id.tab_user:
                        selectedFragment = new ThongTinTaiKhoan();
                        break;

                }
                //thay thế tab hiện tại thành tab mới
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, selectedFragment).commit();
            }
        });
    }
}
