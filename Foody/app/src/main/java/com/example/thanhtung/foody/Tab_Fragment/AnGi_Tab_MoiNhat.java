package com.example.thanhtung.foody.Tab_Fragment;

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

import com.example.thanhtung.foody.Adapter.MoiNhatAdapter;
import com.example.thanhtung.foody.Fragment.ODau_Fragment;
import com.example.thanhtung.foody.MainActivity;
import com.example.thanhtung.foody.R;

import static com.example.thanhtung.foody.Adapter.MoiNhatAdapter.IsPressFirstItem_MoiNhat;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.flMN2;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.mTabHostAnGi;

/**
 * Created by Thanh Tung on 4/3/2017.
 */

public class AnGi_Tab_MoiNhat extends Fragment {

    private ListView lvItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.layout_list, container, false);

        final String[] tv_custom = {"Mới nhất", "Gần tôi", "Xem nhiều", "Du khách"};
        int[] img_custom={ R.drawable.mnod01, R.drawable.mnod02, R.drawable.mnod03, R.drawable.mnod04};

        lvItems = (ListView) v.findViewById(R.id.lv_custom);
        lvItems.setAdapter(new MoiNhatAdapter(getContext(), img_custom,tv_custom, mTabHostAnGi));

        lvItems.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (IsPressFirstItem_MoiNhat == true) {
                    mTabHostAnGi.setCurrentTab(0);
                    flMN2 = false;
                    MainActivity.mBottomBar.setVisibility(View.VISIBLE);
                }
                if(((ListView)parent).isItemChecked(position)){
                    TextView temp = (TextView) mTabHostAnGi.getTabWidget().getChildAt(1).findViewById(R.id.tabname);//Lấy những text muôn thay đổi
                    temp.setText(tv_custom[position]);
                    temp.setTextColor(Color.RED);
                }

            }
        });
        if(IsPressFirstItem_MoiNhat == false) {
            lvItems.performItemClick(lvItems, 0, lvItems.getItemIdAtPosition(0));
        }

        Button btn=(Button) v.findViewById(R.id.btnHuy);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ODau_Fragment.mTabHostODau.setCurrentTab(0);
                MainActivity.mBottomBar.setVisibility(View.VISIBLE);//hiện BottomBar khi bấm hủy
            }
        });


        return v;
    }
}
