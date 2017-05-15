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
import com.example.thanhtung.foody.Tab_Fragment.ODau_Tab_DanhMuc;
import com.example.thanhtung.foody.Tab_Fragment.ODau_Tab_Home;
import com.example.thanhtung.foody.Tab_Fragment.ODau_Tab_MoiNhat;
import com.example.thanhtung.foody.Tab_Fragment.ODau_Tab_ThanhPho;

import static com.example.thanhtung.foody.Tab_Fragment.PhanChonThanhPho.TenThanhPho;


/**
 * Created by Thanh Tung on 3/27/2017.
 */

@SuppressWarnings("deprecation")
public class ODau_Fragment extends Fragment {

    public static boolean flMN, flDM, flDD;
    public static FragmentTabHost mTabHostODau;
    public static String danhmuc_odau = "Danh mục";
    public static String kieudiadiem_odau = "ThanhPho";
    public static String diadiem_odau = "TP.HCM";
    public static boolean IsPressFirstItem_DanhMuc_ODau = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mTabHostODau = new FragmentTabHost(getActivity());
        mTabHostODau.setup(getActivity(), getChildFragmentManager(), R.layout.fragment_odau);

        setupTab(new TextView(getContext()), "Ở Đâu", ODau_Tab_Home.class);
        setupTab(new TextView(getContext()), "Mới nhất", ODau_Tab_MoiNhat.class);
        setupTab(new TextView(getContext()), danhmuc_odau, ODau_Tab_DanhMuc.class);
        setupTab(new TextView(getContext()), diadiem_odau, ODau_Tab_ThanhPho.class);

        mTabHostODau.getTabWidget().getChildAt(0).setVisibility(View.GONE);
        //set color cho tab khi khoi tao
        TextView moinhat = (TextView) mTabHostODau.getTabWidget().getChildAt(1).findViewById(R.id.tabname);
        moinhat.setTextColor(Color.RED);
        TextView thanhpho = (TextView) mTabHostODau.getTabWidget().getChildAt(3).findViewById(R.id.tabname);
        thanhpho.setTextColor(Color.RED);

        Reselect();


        return mTabHostODau;
    }

    private void setupTab(final View view, final String tag, Class cl) {
        View tabview = createTabView(mTabHostODau.getContext(), tag);
        TabHost.TabSpec setContent = mTabHostODau.newTabSpec(tag).setIndicator(tabview).setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {return view;}
        });
        mTabHostODau.addTab(setContent, cl, Bundle.EMPTY);
    }

    private static View createTabView(final Context context, final String text) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) view.findViewById(R.id.tabname);
        tv.setText(text);
        return view;
    }

    private void Reselect(){
        mTabHostODau.getTabWidget().getChildAt(1).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if (!flMN){
                    flMN = true;
                    flDM = false;
                    flDD = false;
                    MainActivity.mBottomBar.setVisibility(View.GONE);//ẩn BottomBar khi bấm hủy
                    mTabHostODau.setCurrentTab(1);
                }
                else {
                    flMN = false;
                    MainActivity.mBottomBar.setVisibility(View.VISIBLE);//hiện BottomBar khi bấm hủy
                    mTabHostODau.setCurrentTab(0);
                }
            }
        });

        mTabHostODau.getTabWidget().getChildAt(2).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if (!flDM){
                    flMN = false;
                    flDM = true;
                    flDD = false;
                    MainActivity.mBottomBar.setVisibility(View.GONE);//ẩn BottomBar khi bấm hủy
                    mTabHostODau.setCurrentTab(2);
                }
                else {
                    flDM = false;
                    MainActivity.mBottomBar.setVisibility(View.VISIBLE);//hiện BottomBar khi bấm hủy
                    mTabHostODau.setCurrentTab(0);
                }
            }
        });

        mTabHostODau.getTabWidget().getChildAt(3).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if (!flDD){
                    flMN = false;
                    flDM = false;
                    flDD = true;
                    MainActivity.mBottomBar.setVisibility(View.GONE);//ẩn BottomBar khi bấm hủy
                    mTabHostODau.setCurrentTab(3);
                }
                else {
                    flDD = false;
                    MainActivity.mBottomBar.setVisibility(View.VISIBLE);//hiện BottomBar khi bấm hủy
                    mTabHostODau.setCurrentTab(0);
                }
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        TextView temp = (TextView) mTabHostODau.getTabWidget().getChildAt(3).findViewById(R.id.tabname);//Lấy những text muôn thay đổi
        temp.setText(TenThanhPho);
        kieudiadiem_odau = "ThanhPho";
        diadiem_odau = TenThanhPho;
        mTabHostODau.setCurrentTab(0);
        flDD = false;
        MainActivity.mBottomBar.setVisibility(View.VISIBLE);
    }

}

