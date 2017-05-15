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

import com.example.thanhtung.foody.Adapter.DiaDiemODauAdapter;
import com.example.thanhtung.foody.Database;
import com.example.thanhtung.foody.MainActivity;
import com.example.thanhtung.foody.Model.DuongQuan;
import com.example.thanhtung.foody.Model.QuanHuyen;
import com.example.thanhtung.foody.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.thanhtung.foody.Fragment.ODau_Fragment.diadiem_odau;
import static com.example.thanhtung.foody.Fragment.ODau_Fragment.flDD;
import static com.example.thanhtung.foody.Fragment.ODau_Fragment.kieudiadiem_odau;
import static com.example.thanhtung.foody.Fragment.ODau_Fragment.mTabHostODau;
import static com.example.thanhtung.foody.MainActivity.DATABASE_NAME;
import static com.example.thanhtung.foody.MainActivity.database;
import static com.example.thanhtung.foody.Tab_Fragment.PhanChonThanhPho.MaThanhPho;
import static com.example.thanhtung.foody.Tab_Fragment.PhanChonThanhPho.TenThanhPho;

/**
 * Created by Thanh Tung on 4/3/2017.
 */

public class ODau_Tab_ThanhPho extends Fragment {

    TextView tvThanhPho;
    ExpandableListView expandableListView;
    DiaDiemODauAdapter listAdapter;
    List<QuanHuyen> Headings;
    HashMap<String, List<DuongQuan>> ChildList;
    Button btnDoiTinhThanh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.layout_thanhpho, container, false);

        tvThanhPho = (TextView) v.findViewById(R.id.tvDiaDiem);
        tvThanhPho.setText(TenThanhPho);
        tvThanhPho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kieudiadiem_odau = "ThanhPho";
                diadiem_odau = tvThanhPho.getText().toString();
                tvThanhPho.setTextColor(Color.RED);
                TextView temp = (TextView) mTabHostODau.getTabWidget().getChildAt(3).findViewById(R.id.tabname);//Lấy những text muôn thay đổi
                temp.setText(tvThanhPho.getText().toString());
                temp.setTextColor(Color.RED);
                mTabHostODau.setCurrentTab(0);
                flDD = false;
                MainActivity.mBottomBar.setVisibility(View.VISIBLE);
            }
        });
        expandableListView =(ExpandableListView)v.findViewById(R.id.expand_listview);

        fillData();
        listAdapter = new DiaDiemODauAdapter(getContext(), Headings, ChildList);
        expandableListView.setAdapter(listAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        //btnDoiTinhThanh
        btnDoiTinhThanh =(Button)v.findViewById(R.id.btnDoiTinhThanh);
        btnDoiTinhThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PhanChonThanhPho.class);
                startActivity(intent);
            }
        });

        Button btn=(Button) v.findViewById(R.id.btnHuy);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTabHostODau.setCurrentTab(0);
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
        String query = "";
        if(MaThanhPho <= 0) {
            query = "SELECT MaQuan, TenQuan FROM QuanHuyen WHERE MaTP=0";
        }
        else {
            query = "SELECT MaQuan, TenQuan FROM QuanHuyen WHERE MaTP=" +MaThanhPho+ "";
        }
        Cursor cursorHeading = database.rawQuery(query, null);
        for (int i = 0; i < cursorHeading.getCount(); i++) {
            cursorHeading.moveToPosition(i);
            int maQH = cursorHeading.getInt(0);
            String tenQH = cursorHeading.getString(1);
            Headings.add(new QuanHuyen(maQH,tenQH));
            //add ChildList
            List<DuongQuan> temp = new ArrayList<>();
            Cursor cursorChildList = database.rawQuery("SELECT MaDuong,TenDuong FROM DuongQuan WHERE MaQuan='" + maQH + "'", null);
            for (int j = 0; j < cursorChildList.getCount(); j++) {
                cursorChildList.moveToPosition(j);
                int maDuong = cursorHeading.getInt(0);
                String tenDuong = cursorChildList.getString(1);
                temp.add(new DuongQuan(maDuong,tenDuong));
            }
            ChildList.put(tenQH, temp);
            //end add ChildList

        }

        database.close();
    }
}
