package com.example.thanhtung.foody.Tab_Fragment;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thanhtung.foody.Adapter.DanhMucODauAdapter;
import com.example.thanhtung.foody.Adapter.DanhMucAnGiAdapter;
import com.example.thanhtung.foody.Database;
import com.example.thanhtung.foody.MainActivity;
import com.example.thanhtung.foody.Model.DanhMuc;
import com.example.thanhtung.foody.R;

import java.util.ArrayList;

import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.IsPressFirstItem_DanhMuc_AnGi;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.danhmuc_angi;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.flDM2;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.mTabHostAnGi;
import static com.example.thanhtung.foody.MainActivity.DATABASE_NAME;
import static com.example.thanhtung.foody.MainActivity.database;

/**
 * Created by Thanh Tung on 4/4/2017.
 */

public class AnGi_Tab_DanhMuc extends Fragment {

    private ListView lvItems;
    private ArrayList<DanhMuc> listDanhMuc;
    //public static String danhmuc_angi = null;
    DanhMucODauAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.layout_list, container, false);

        lvItems = (ListView) v.findViewById(R.id.lv_custom);
        fillData(); //đổ dữ liệu vào list
        final DanhMucAnGiAdapter adapter = new DanhMucAnGiAdapter(getContext(), "Danh mục", listDanhMuc);   //tạo adapter từ list mới đổ dữ liệu
        lvItems.setAdapter(adapter);    //set adapter cho listview
        //set sự kiện khi click chọn item trong listview
        lvItems.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(((ListView)parent).isItemChecked(position)){
                    if (adapter.getItemViewType(position) == 0) {
                        TextView temp = (TextView) mTabHostAnGi.getTabWidget().getChildAt(2).findViewById(R.id.tabname);//Lấy những text muôn thay đổi
                        temp.setText("Danh mục");
                        temp.setTextColor(Color.BLACK);
                        danhmuc_angi=temp.getText().toString();
                    }
                    else {
                        TextView temp = (TextView) mTabHostAnGi.getTabWidget().getChildAt(2).findViewById(R.id.tabname);//Lấy những text muôn thay đổi
                        temp.setText(listDanhMuc.get(position - 1).getTvDanhMuc());
                        temp.setTextColor(Color.RED);
                        danhmuc_angi=temp.getText().toString();
                    }
                }
                if (IsPressFirstItem_DanhMuc_AnGi == true) {
                    mTabHostAnGi.setCurrentTab(0);
                    flDM2 = false;
                    MainActivity.mBottomBar.setVisibility(View.VISIBLE);
                }

            }
        });
        if(IsPressFirstItem_DanhMuc_AnGi == false) {
            lvItems.performItemClick(lvItems, 0, lvItems.getItemIdAtPosition(0));
        }

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

    private void fillData() {
        listDanhMuc = new ArrayList<>();

        database = Database.initDatabase(getActivity(), DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT HinhDanhMuc, TenDanhMuc\n" +
                "FROM DanhMuc\n" +
                "ORDER BY KieuDanhMuc DESC", null);
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);

            byte[] hinhDanhMuc = cursor.getBlob(0);
            String tenDanhMuc = cursor.getString(1);

            //Xử lý hình ảnh
            Bitmap bmp_hinhDanhMuc = BitmapFactory.decodeByteArray(hinhDanhMuc, 0, hinhDanhMuc.length);

            listDanhMuc.add(new DanhMuc(bmp_hinhDanhMuc, tenDanhMuc));
        }

        database.close();
    }
}
