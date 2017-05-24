package com.example.thanhtung.foody.Adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thanhtung.foody.R;

/**
 * Created by Thanh Tung on 4/3/2017.
 */

public class MoiNhatAdapter extends BaseAdapter {

    public static boolean IsPressFirstItem_MoiNhat = false;

    Context context;
    int[] img_custom;
    String[] tv_custom;
    FragmentTabHost mTabHost;
    //constructor
    public MoiNhatAdapter(Context context, int[] img_custom, String[] tv_custom, FragmentTabHost mTabHost) {
        this.context = context;
        this.img_custom = img_custom;
        this.tv_custom = tv_custom;
        this.mTabHost = mTabHost;
    }
    //override các method
    @Override
    public int getCount() {
        return tv_custom.length ;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_list, null);

        TextView tv=(TextView) rowView.findViewById(R.id.tv_custom);
        ImageView img=(ImageView) rowView.findViewById(R.id.img_custom);
        ImageView img_stick=(ImageView) rowView.findViewById(R.id.img_stick);

        tv.setText(tv_custom[position]);
        img.setImageResource(img_custom[position]);
        //thay đổi hình khi click vào
        if (((ListView)parent).isItemChecked(position)) {
            IsPressFirstItem_MoiNhat = true;
            tv.setTextColor(Color.RED);
            img_stick.setImageResource(R.drawable.stick_icon);

            switch (position){
                case 0:
                    img.setImageResource(R.drawable.mnod01_active);
                    break;
                case 1:
                    img.setImageResource(R.drawable.mnod02_active);
                    break;
                case 2:
                    img.setImageResource(R.drawable.mnod03_active);
                    break;
                case 3:
                    img.setImageResource(R.drawable.mnod04_active);
                    break;
                case 4:
                    img.setImageResource(R.drawable.mnod05_active);
                    break;
                case 5:
                    img.setImageResource(R.drawable.mnod06_active);
                    break;
                case 6:
                    img.setImageResource(R.drawable.mnod07_active);
                    break;
                case 7:
                    img.setImageResource(R.drawable.mnod08_active);
                    break;
                default:
                    break;
            }
        }




        return rowView;
    }
}
