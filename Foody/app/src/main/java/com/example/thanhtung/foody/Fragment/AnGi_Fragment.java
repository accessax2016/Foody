package com.example.thanhtung.foody.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.thanhtung.foody.MainActivity;
import com.example.thanhtung.foody.R;
import com.example.thanhtung.foody.Tab_Fragment.AnGi_Tab_DanhMuc;
import com.example.thanhtung.foody.Tab_Fragment.AnGi_Tab_Home;
import com.example.thanhtung.foody.Tab_Fragment.AnGi_Tab_MoiNhat;
import com.example.thanhtung.foody.Tab_Fragment.AnGi_Tab_ThanhPho;

import static com.example.thanhtung.foody.Tab_Fragment.PhanChonThanhPho.TenThanhPho;


/**
 * Created by Thanh Tung on 3/27/2017.
 */

@SuppressWarnings("deprecation")
public class AnGi_Fragment extends Fragment {

    public static boolean flMN2, flDM2, flDD2;
    public static FragmentTabHost mTabHostAnGi;
    public static String danhmuc_angi = "Danh mục";
    public static String kieudiadiem_angi = "ThanhPho";
    public static String diadiem_angi = "TP.HCM";
    public static boolean IsPressFirstItem_DanhMuc_AnGi = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mTabHostAnGi = new FragmentTabHost(getActivity());
        mTabHostAnGi.setup(getActivity(), getChildFragmentManager(), R.layout.fragment_angi);

        setupTab(new TextView(getContext()), "Ở Đâu", AnGi_Tab_Home.class);
        setupTab(new TextView(getContext()), "Mới nhất", AnGi_Tab_MoiNhat.class);
        setupTab(new TextView(getContext()), danhmuc_angi, AnGi_Tab_DanhMuc.class);
        setupTab(new TextView(getContext()), diadiem_angi, AnGi_Tab_ThanhPho.class);

        mTabHostAnGi.getTabWidget().getChildAt(0).setVisibility(View.GONE);
        //set color cho tab khi khoi tao
        TextView moinhat = (TextView) mTabHostAnGi.getTabWidget().getChildAt(1).findViewById(R.id.tabname);
        moinhat.setTextColor(Color.RED);
        TextView thanhpho = (TextView) mTabHostAnGi.getTabWidget().getChildAt(3).findViewById(R.id.tabname);
        thanhpho.setTextColor(Color.RED);
        Reselect();


        return mTabHostAnGi;
    }

    private void setupTab(final View view, final String tag, Class cl) {
        View tabview = createTabView(mTabHostAnGi.getContext(), tag);
        TabHost.TabSpec setContent = mTabHostAnGi.newTabSpec(tag).setIndicator(tabview).setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {return view;}
        });
        mTabHostAnGi.addTab(setContent, cl, Bundle.EMPTY);

    }

    private static View createTabView(final Context context, final String text) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) view.findViewById(R.id.tabname);
        tv.setText(text);
        return view;
    }

    private void Reselect(){
        mTabHostAnGi.getTabWidget().getChildAt(1).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if (!flMN2){
                    flMN2 = true;
                    flDM2 = false;
                    flDD2 = false;
                    MainActivity.mBottomBar.setVisibility(View.GONE);//ẩn BottomBar khi bấm hủy
                    mTabHostAnGi.setCurrentTab(1);
                }
                else {
                    flMN2 = false;
                    MainActivity.mBottomBar.setVisibility(View.VISIBLE);//hiện BottomBar khi bấm hủy
                    mTabHostAnGi.setCurrentTab(0);
                }
            }
        });

        mTabHostAnGi.getTabWidget().getChildAt(2).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if (!flDM2){
                    flMN2 = false;
                    flDM2 = true;
                    flDD2 = false;
                    MainActivity.mBottomBar.setVisibility(View.GONE);//ẩn BottomBar khi bấm hủy
                    mTabHostAnGi.setCurrentTab(2);
                }
                else {
                    flDM2 = false;
                    MainActivity.mBottomBar.setVisibility(View.VISIBLE);//hiện BottomBar khi bấm hủy
                    mTabHostAnGi.setCurrentTab(0);
                }
            }
        });

        mTabHostAnGi.getTabWidget().getChildAt(3).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if (!flDD2){
                    flMN2 = false;
                    flDM2 = false;
                    flDD2 = true;
                    MainActivity.mBottomBar.setVisibility(View.GONE);//ẩn BottomBar khi bấm hủy
                    mTabHostAnGi.setCurrentTab(3);
                }
                else {
                    flDD2 = false;
                    MainActivity.mBottomBar.setVisibility(View.VISIBLE);//hiện BottomBar khi bấm hủy
                    mTabHostAnGi.setCurrentTab(0);
                }
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        TextView temp = (TextView) mTabHostAnGi.getTabWidget().getChildAt(3).findViewById(R.id.tabname);//Lấy những text muôn thay đổi
        temp.setText(TenThanhPho);
        kieudiadiem_angi = "ThanhPho";
        diadiem_angi = TenThanhPho;
        mTabHostAnGi.setCurrentTab(0);
        flDD2 = false;
        MainActivity.mBottomBar.setVisibility(View.VISIBLE);
    }
}

