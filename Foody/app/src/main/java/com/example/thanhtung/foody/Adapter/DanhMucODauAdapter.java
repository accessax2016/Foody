package com.example.thanhtung.foody.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thanhtung.foody.Model.DanhMuc;
import com.example.thanhtung.foody.R;

import java.util.ArrayList;

import static com.example.thanhtung.foody.Fragment.ODau_Fragment.IsPressFirstItem_DanhMuc_ODau;
import static com.example.thanhtung.foody.R.id.img_custom;
import static com.example.thanhtung.foody.R.id.tv_custom;
import static com.example.thanhtung.foody.R.id.tv_normal;

/**
 * Created by Thanh Tung on 4/15/2017.
 */

public class DanhMucODauAdapter extends BaseAdapter {
    //khai báo cách kiểu trong listview
    private static final int TYPE_HEARDER = 0;
    private static final int TYPE_ITEM = 1;

    Context context;
    String HeaderDanhMuc;
    ArrayList<DanhMuc> listDanhMuc;
    //constructor
    public DanhMucODauAdapter(Context context, String headerDanhMuc, ArrayList<DanhMuc> listDanhMuc) {
        this.context = context;
        this.HeaderDanhMuc = headerDanhMuc;
        this.listDanhMuc = listDanhMuc;
    }
    //override các method
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0)
            return TYPE_HEARDER;
        return TYPE_ITEM;
    }

    @Override
    public int getCount() {
        return listDanhMuc.size();
    }

    @Override
    public Object getItem(int position) {
        return listDanhMuc.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView;
        //tùy kiểu sẽ lấy các layout khác nhau
        int rowType = getItemViewType(position);
        if (rowType == TYPE_HEARDER){
            rowView = inflater.inflate(R.layout.normal_list, null);
            TextView tv_header = (TextView) rowView.findViewById(tv_normal);
            ImageView img_stick=(ImageView) rowView.findViewById(R.id.img_stick_normal);

            tv_header.setText(HeaderDanhMuc);

            if (((ListView)parent).isItemChecked(position)) {
                IsPressFirstItem_DanhMuc_ODau = true;
                tv_header.setTextColor(Color.RED);
                img_stick.setImageResource(R.drawable.stick_icon);
            }

        }
        else {
            rowView = inflater.inflate(R.layout.custom_list, null);
            ImageView img_item = (ImageView) rowView.findViewById(img_custom);
            TextView tv_item = (TextView) rowView.findViewById(tv_custom);
            ImageView img_stick=(ImageView) rowView.findViewById(R.id.img_stick);

            img_item.setImageBitmap(listDanhMuc.get(position - 1).getImgDanhMuc());
            tv_item.setText(listDanhMuc.get(position - 1).getTvDanhMuc());

            if (((ListView)parent).isItemChecked(position)) {
                IsPressFirstItem_DanhMuc_ODau = true;
                tv_item.setTextColor(Color.RED);
                img_stick.setImageResource(R.drawable.stick_icon);
            }

        }

        return rowView;
    }
}
