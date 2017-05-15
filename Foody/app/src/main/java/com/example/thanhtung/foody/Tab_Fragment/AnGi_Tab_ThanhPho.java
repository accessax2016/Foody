package com.example.thanhtung.foody.Tab_Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.thanhtung.foody.Adapter.DiaDiemAnGiAdapter;
import com.example.thanhtung.foody.Database;
import com.example.thanhtung.foody.MainActivity;
import com.example.thanhtung.foody.Model.DuongQuan;
import com.example.thanhtung.foody.Model.QuanHuyen;
import com.example.thanhtung.foody.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.diadiem_angi;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.flDD2;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.kieudiadiem_angi;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.mTabHostAnGi;
import static com.example.thanhtung.foody.MainActivity.DATABASE_NAME;
import static com.example.thanhtung.foody.MainActivity.database;
import static com.example.thanhtung.foody.Tab_Fragment.PhanChonThanhPho.MaThanhPho;

/**
 * Created by Thanh Tung on 4/3/2017.
 */

public class AnGi_Tab_ThanhPho extends Fragment {

    TextView tvThanhPho;
    ExpandableListView expandableListView;
    DiaDiemAnGiAdapter listAdapter;
    List<QuanHuyen> Headings;
    HashMap<String, List<DuongQuan>> ChildList;
    Button btnDoiTinhThanh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.layout_thanhpho, container, false);

        tvThanhPho = (TextView) v.findViewById(R.id.tvDiaDiem);
        tvThanhPho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kieudiadiem_angi = "ThanhPho";
                diadiem_angi = tvThanhPho.getText().toString();
                tvThanhPho.setTextColor(Color.RED);
                TextView temp = (TextView) mTabHostAnGi.getTabWidget().getChildAt(3).findViewById(R.id.tabname);//Lấy những text muôn thay đổi
                temp.setText(tvThanhPho.getText().toString());
                temp.setTextColor(Color.RED);
                mTabHostAnGi.setCurrentTab(0);
                flDD2 = false;
                MainActivity.mBottomBar.setVisibility(View.VISIBLE);
            }
        });
        expandableListView =(ExpandableListView)v.findViewById(R.id.expand_listview);

        fillData();
        listAdapter = new DiaDiemAnGiAdapter(getContext(), Headings, ChildList);
        expandableListView.setAdapter(listAdapter);

        //btnDoiTinhThanh
        btnDoiTinhThanh =(Button)v.findViewById(R.id.btnDoiTinhThanh);
        btnDoiTinhThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PhanChonThanhPho.class);
                startActivity(intent);
            }
        });

        Button btn=(Button) v.findViewById(R.id.btnHuy);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTabHostAnGi.setCurrentTab(0);
                MainActivity.mBottomBar.setVisibility(View.VISIBLE);//hiện BottomBar khi bấm hủy
            }
        });

        return v;
    }
    public void fillData() {
        Headings = new ArrayList<>();
        ChildList = new HashMap<>();

        //add Heading
        database = Database.initDatabase(getActivity(), DATABASE_NAME);
        String Cauquery="";
        if(MaThanhPho <=0) {
            Cauquery="SELECT TenQuan,MaQuan from QuanHuyen where MaTP=0";
        }
        else {
            Cauquery="SELECT TenQuan,MaQuan from QuanHuyen where MaTP="+MaThanhPho+"";
        }
        Cursor cursorHeading = database.rawQuery(Cauquery, null);
        for (int i = 0; i < cursorHeading.getCount(); i++) {
            cursorHeading.moveToPosition(i);
            String tenQH = cursorHeading.getString(0);
            int maQH = cursorHeading.getInt(1);
            Headings.add(new QuanHuyen(maQH,tenQH));
            //add ChildList
            List<DuongQuan> temp = new ArrayList<>();
            Cursor cursorChildList = database.rawQuery("SELECT MaDuong,TenDuong from DuongQuan where MaQuan='" + maQH + "'", null);
            for (int j = 0; j < cursorChildList.getCount(); j++) {
                cursorChildList.moveToPosition(j);
                String tenDuong = cursorChildList.getString(1);
                int maDuong = cursorHeading.getInt(0);
                temp.add(new DuongQuan(maDuong,tenDuong));
            }
            ChildList.put(tenQH, temp);
            //end add ChildList

        }

        database.close();
    }
}
