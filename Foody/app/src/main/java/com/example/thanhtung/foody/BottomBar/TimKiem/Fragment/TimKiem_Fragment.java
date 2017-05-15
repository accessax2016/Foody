package com.example.thanhtung.foody.BottomBar.TimKiem.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.thanhtung.foody.R;

/**
 * Created by Thanh Tung on 4/11/2017.
 */

public class TimKiem_Fragment extends Fragment {
    public static FragmentTabHost mTabHost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mTabHost = new FragmentTabHost(getActivity());
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.layout.fragment_timkiem);

        setupTab(new TextView(getContext()), "Xem gần đây");
        setupTab(new TextView(getContext()), "Đã tìm");

        return mTabHost;
    }

    private void setupTab(final View view, final String tag) {
        View tabview = createTabView(mTabHost.getContext(), tag);
        TabHost.TabSpec setContent = mTabHost.newTabSpec(tag).setIndicator(tabview).setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {return view;}
        });
        mTabHost.addTab(setContent);
    }

    private static View createTabView(final Context context, final String text) {
        View view = LayoutInflater.from(context).inflate(R.layout.normal_tab, null);
        TextView tv = (TextView) view.findViewById(R.id.tabname);
        tv.setText(text);
        return view;
    }
}
