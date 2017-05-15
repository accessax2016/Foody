package com.example.thanhtung.foody.BottomBar.TimKiem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.thanhtung.foody.BottomBar.TimKiem.Fragment.TimKiem_Fragment;
import com.example.thanhtung.foody.R;

/**
 * Created by Thanh Tung on 4/10/2017.
 */

public class TimKiem extends Fragment {

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    EditText edtTimKiem;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.timkiem_main, container, false);

        edtTimKiem = (EditText) v.findViewById(R.id.edtTimKiem);
        edtTimKiem.requestFocus();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager = (ViewPager) v.findViewById(R.id.view_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        return v;
    }

    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return new TimKiem_Fragment();
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 1;
        }
    }
}
