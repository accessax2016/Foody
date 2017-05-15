package com.example.thanhtung.foody.BottomBar.NhaChinh;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thanhtung.foody.Fragment.AnGi_Fragment;
import com.example.thanhtung.foody.Fragment.ODau_Fragment;
import com.example.thanhtung.foody.Login.YeuCauDangNhap;
import com.example.thanhtung.foody.MainActivity;
import com.example.thanhtung.foody.R;

import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.flDD2;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.flDM2;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.flMN2;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.mTabHostAnGi;
import static com.example.thanhtung.foody.Fragment.ODau_Fragment.flDD;
import static com.example.thanhtung.foody.Fragment.ODau_Fragment.flDM;
import static com.example.thanhtung.foody.Fragment.ODau_Fragment.flMN;
import static com.example.thanhtung.foody.Fragment.ODau_Fragment.mTabHostODau;
import static com.example.thanhtung.foody.MainActivity.Login;

/**
 * Created by Thanh Tung on 4/7/2017.
 */

public class Home extends Fragment {

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    public TextView tvODau, tvAnGi;
    private ImageView btnPlus;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.home_main, container, false);

        tvODau = (TextView) v.findViewById(R.id.tvODau);
        tvAnGi = (TextView) v.findViewById(R.id.tvAnGi);
        btnPlus=(ImageView) v.findViewById(R.id.imgPlus);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager = (ViewPager) v.findViewById(R.id.view_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //Hoán đổi hiệu ứng chọn khi kéo
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mTabHostODau.setCurrentTab(0);
                        flMN=false;
                        flDM=false;
                        flDD=false;
                        MainActivity.mBottomBar.setVisibility(View.VISIBLE);
                        changeSwipe(tvODau, tvAnGi,true);
                        break;
                    case 1:
                        mTabHostAnGi.setCurrentTab(0);
                        flMN2=false;
                        flDM2=false;
                        flDD2=false;
                        MainActivity.mBottomBar.setVisibility(View.VISIBLE);
                        changeSwipe(tvAnGi, tvODau,false);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tvODau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
            }
        });

        tvAnGi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1);
            }
        });

        setBottomSheetDialag();

        return v;
    }

    private void setBottomSheetDialag() {
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
                View bottomSheetView = LayoutInflater.from(getContext()).inflate(R.layout.home_bottomsheet_layout,null);
                bottomSheetDialog.setContentView(bottomSheetView);

                TextView txtQuetMaCoupon = (TextView)bottomSheetView.findViewById(R.id.txtQuetMaCoupon);
                TextView txtDangAnh = (TextView)bottomSheetView.findViewById(R.id.txtDangAnh);
                TextView txtCheckIn = (TextView)bottomSheetView.findViewById(R.id.txtCheckIn);
                TextView txtVietBinhLuan = (TextView)bottomSheetView.findViewById(R.id.txtVietBinhLuan);
                TextView txtThemDiaDiem = (TextView)bottomSheetView.findViewById(R.id.txtThemDiaDiem);

                txtQuetMaCoupon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!Login) {
                            Intent intent = new Intent(getActivity(), YeuCauDangNhap.class);
                            startActivity(intent);
                            Login = true;
                        }
                        else {

                        }
                    }
                });
                txtDangAnh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!Login) {
                            Intent intent = new Intent(getActivity(), YeuCauDangNhap.class);
                            startActivity(intent);
                            Login = true;
                        }
                        else {

                        }
                    }
                });
                txtCheckIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!Login) {
                            Intent intent = new Intent(getActivity(), YeuCauDangNhap.class);
                            startActivity(intent);
                            Login = true;
                        }
                        else {

                        }
                    }
                });
                txtVietBinhLuan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!Login) {
                            Intent intent = new Intent(getActivity(), YeuCauDangNhap.class);
                            startActivity(intent);
                            Login = true;
                        }
                        else {

                        }
                    }
                });
                txtThemDiaDiem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!Login) {
                            Intent intent = new Intent(getActivity(), YeuCauDangNhap.class);
                            startActivity(intent);
                            Login = true;
                        }
                        else {

                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });
    }
    private void changeSwipe(TextView tvTurnOn, TextView tvTurnOff, boolean onLeft) {
        tvTurnOn.setBackgroundResource(android.R.color.transparent);
        tvTurnOn.setTextColor(Color.parseColor("#000000"));
        if (onLeft) {
            tvTurnOff.setBackgroundResource(R.drawable.round_left_2);
        }
        else{
            tvTurnOff.setBackgroundResource(R.drawable.round_right_2);
        }
        tvTurnOff.setTextColor(Color.parseColor("#FFFFFF"));
    }
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ODau_Fragment();
                case 1:
                    return new AnGi_Fragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }
    }
}
