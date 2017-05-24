package com.example.thanhtung.foody.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.thanhtung.foody.MainActivity;
import com.example.thanhtung.foody.Model.DuongQuan;
import com.example.thanhtung.foody.Model.QuanHuyen;
import com.example.thanhtung.foody.R;

import java.util.HashMap;
import java.util.List;

import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.flDD2;
import static com.example.thanhtung.foody.Fragment.ODau_Fragment.diadiem_odau;
import static com.example.thanhtung.foody.Fragment.ODau_Fragment.flDD;
import static com.example.thanhtung.foody.Fragment.ODau_Fragment.kieudiadiem_odau;
import static com.example.thanhtung.foody.Fragment.ODau_Fragment.mTabHostODau;

/**
 * Created by Thanh Tung on 4/8/2017.
 */

public class DiaDiemODauAdapter extends BaseExpandableListAdapter {
    private List<QuanHuyen> header_titles;
    private HashMap<String, List<DuongQuan>> child_titles;
    private Context ctx;
    //constructor
    public DiaDiemODauAdapter(Context ctx, List<QuanHuyen> header_titles, HashMap<String, List<DuongQuan>> chiled_titles)
    {
        this.ctx = ctx;
        this.child_titles = chiled_titles;
        this.header_titles = header_titles;
    }
    //override các method
    @Override
    public int getGroupCount() {
        return header_titles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return  child_titles.get(header_titles.get(groupPosition).getTenQuan()).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return header_titles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child_titles.get(header_titles.get(groupPosition).getTenQuan()).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //method xử lý hiển thị cho các group (cụ thể là list các quận huyện của thành phố)
    @Override
    public View getGroupView(final int groupPosition, final boolean isExpanded, View convertView, final ViewGroup parent) {
        QuanHuyen title = (QuanHuyen)this.getGroup(groupPosition);
        if (convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.thanhpho_parent, parent, false);
        }
        final TextView textView = (TextView)convertView.findViewById(R.id.heading_item);
        textView.setText(title.getTenQuan());
        Button btnSoDuong = (Button)convertView.findViewById(R.id.btnSoDuong);
        btnSoDuong.setText(this.getChildrenCount(groupPosition) + " đường");
        //set sự khiện khi click vào button số đường sẽ mở các đường trong quận và đóng nếu đã mở
        btnSoDuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExpanded)
                    ((ExpandableListView) parent).collapseGroup(groupPosition);
                else
                    ((ExpandableListView) parent).expandGroup(groupPosition, true);
            }
        });
        //set sự kiện click chọn quận huyện để lấy id và lọc
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView temp = (TextView) mTabHostODau.getTabWidget().getChildAt(3).findViewById(R.id.tabname);//Lấy những text muôn thay đổi
                temp.setText(textView.getText());
                temp.setTextColor(Color.RED);

                kieudiadiem_odau = "QuanHuyen";
                diadiem_odau = temp.getText().toString();
                mTabHostODau.setCurrentTab(0);
                flDD = false;
                MainActivity.mBottomBar.setVisibility(View.VISIBLE);
            }
        });

        return convertView;
    }
    //method xử lý hiển thị cho list child (cụ thể là list các đường trong quận huyện)
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        DuongQuan title = (DuongQuan)this.getChild(groupPosition, childPosition);
        if (convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.thanhpho_child, parent, false);
        }
        final TextView textView = (TextView)convertView.findViewById(R.id.child_item);
        textView.setText(title.getTenDuong());
        //set sự kiện khi click chọn đường để lấy id và lọc
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView temp = (TextView) mTabHostODau.getTabWidget().getChildAt(3).findViewById(R.id.tabname);//Lấy những text muôn thay đổi
                temp.setText(textView.getText());
                temp.setTextColor(Color.RED);

                kieudiadiem_odau = "DuongPho";
                diadiem_odau = temp.getText().toString();
                mTabHostODau.setCurrentTab(0);
                flDD = false;
                flDD2 = false;
                MainActivity.mBottomBar.setVisibility(View.VISIBLE);
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
