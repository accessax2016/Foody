package com.example.thanhtung.foody.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thanhtung.foody.Model.ThanhPho;
import com.example.thanhtung.foody.R;

import java.util.ArrayList;


public class DoiThanhPhoAdapter extends BaseAdapter {
    //các kiểu trong list thành phố
    private static final int TYPE_HEARDER = 0;
    private static final int TYPE_ITEM = 1;

    Context context;
    ArrayList<ThanhPho> thanhPhos;
    //constructor
    public DoiThanhPhoAdapter(Context context, ArrayList<ThanhPho> thanhPhos) {
        this.context = context;
        this.thanhPhos = thanhPhos;
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
        return thanhPhos.size();
    }

    @Override
    public Object getItem(int position) {
        return thanhPhos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView;
        //tùy kiểu sẽ lấy layout khác nhau
        int rowType = getItemViewType(position);
        if (rowType == TYPE_HEARDER){
            rowView = inflater.inflate(R.layout.item_chonthanhpho_header, null);
            EditText edtSearch = (EditText) rowView.findViewById(R.id.edtSearch);
            TextView tvLocal = (TextView) rowView.findViewById(R.id.tvLocal);
            TextView tvPosition = (TextView) rowView.findViewById(R.id.tvPosition);
        }
        else {
            rowView = inflater.inflate(R.layout.item_chonthanhpho, null);
            ImageView imgChonThanhPho = (ImageView) rowView.findViewById(R.id.imgThanhPhoDaChon);
            TextView txtTenThanhPho = (TextView) rowView.findViewById(R.id.txtThanhPhoDuocChon);

            txtTenThanhPho.setText(thanhPhos.get(position-1).getTenTP());

            if(((ListView)parent).isItemChecked(position)){
                txtTenThanhPho.setTextColor(Color.BLUE);
                imgChonThanhPho.setImageResource(R.drawable.stick_icon);
            }
        }

        return rowView;
    }
}
