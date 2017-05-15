package com.example.thanhtung.foody.BottomBar.BoSuuTap;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thanhtung.foody.BottomBar.BoSuuTap.Fragment.BST_Anh_Fragment;
import com.example.thanhtung.foody.BottomBar.BoSuuTap.Fragment.BST_DiaDiem_Fragment;
import com.example.thanhtung.foody.R;

/**
 * Created by Thanh Tung on 4/6/2017.
 */

public class BoSuuTap extends Fragment {

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    public TextView tvBST_DiaDiem, tvBST_Anh;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bosuutam_main, container, false);

        tvBST_DiaDiem = (TextView) v.findViewById(R.id.tvBST_DiaDiem);
        tvBST_Anh = (TextView) v.findViewById(R.id.tvBST_Anh);

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
                        changeSwipe(tvBST_DiaDiem, tvBST_Anh,true);
                        break;
                    case 1:
                        changeSwipe(tvBST_Anh, tvBST_DiaDiem,false);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tvBST_DiaDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
            }
        });

        tvBST_Anh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1);
            }
        });


        return v;
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
                    return new BST_DiaDiem_Fragment();
                case 1:
                    return new BST_Anh_Fragment();
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
