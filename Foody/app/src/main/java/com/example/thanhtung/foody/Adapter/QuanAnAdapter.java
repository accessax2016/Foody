package com.example.thanhtung.foody.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.thanhtung.foody.Model.ODau;
import com.example.thanhtung.foody.R;

import java.util.List;

/**
 * Created by Thanh Tung on 4/9/2017.
 */

public class QuanAnAdapter extends RecyclerView.Adapter< RecyclerView.ViewHolder> {
    //các kiểu của list quán ăn
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_CATEGORY = 1;
    private static final int TYPE_DATA = 2;

    private Context context;
    private int imgHeader;
    private int[] imgCategory;
    private String[] tvCategory;
    private List<ODau> listODau;
    //constructor
    public QuanAnAdapter(Context context, int imgHeader, int[] imgCategory, String[] tvCategory, List<ODau> listODau) {
        this.context=context;
        this.imgHeader=imgHeader;
        this.imgCategory=imgCategory;
        this.tvCategory=tvCategory;
        this.listODau=listODau;
    }
    //class ViewHolder dành cho header, xử lý hiển thị phần Header
    public class HeaderItem extends RecyclerView.ViewHolder {

        private ViewFlipper viewFlipper;
        public HeaderItem(View itemView) {
            super(itemView);

            viewFlipper = (ViewFlipper) itemView.findViewById(R.id.viewFlipper);
            viewFlipper.setFlipInterval(2000);  //set thời gian chờ
            viewFlipper.startFlipping();    //tự động thay đổi hình theo thời gian chờ
        }
    }
    //class ViewHolder dành cho header, xử lý hiển thị phần Category
    public class CategoryItem extends RecyclerView.ViewHolder {

        private ImageView img_category;
        private TextView tv_category;
        public CategoryItem(View itemView) {
            super(itemView);

            img_category = (ImageView) itemView.findViewById(R.id.imgCategory);
            tv_category = (TextView) itemView.findViewById(R.id.tvCategory);
        }
    }
    //class ViewHolder dành cho header, xử lý hiển thị phần Data
    public class DataItem extends RecyclerView.ViewHolder {
        private TextView tvDiem;
        private TextView tvTen;
        private TextView tvDiaDiem;
        private ImageView imgHinh;
        public DataItem(View itemView) {
            super(itemView);
            tvDiem = (TextView) itemView.findViewById(R.id.tvDiem);
            tvTen = (TextView) itemView.findViewById(R.id.tvTen);
            tvDiaDiem = (TextView) itemView.findViewById(R.id.tvDiaDiem);
            imgHinh = (ImageView) itemView.findViewById(R.id.imgHinh);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        //tùy kiểu sẽ lấy layout khác nhau
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_main_header, parent, false);

            viewHolder = new HeaderItem(view);
        } else if (viewType == TYPE_CATEGORY){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_main_category, parent, false);
            viewHolder = new CategoryItem(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_main_data, parent, false);
            viewHolder = new DataItem(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //tùy kiểu gắn giá trị khác nhau
        if (holder instanceof HeaderItem) {
            HeaderItem mHolder = (HeaderItem)holder;
            //mHolder.img_quangcao.setImageResource(imgHeader);
        } else if (holder instanceof CategoryItem){
            CategoryItem mHolder = (CategoryItem)holder;
            mHolder.img_category.setImageResource(imgCategory[position - 1]);
            mHolder.tv_category.setText(tvCategory[position - 1]);
        } else {
            DataItem mHolder = (DataItem) holder;
            ODau item = listODau.get(position - tvCategory.length - 1);
            mHolder.tvDiem.setText(String.valueOf(item.getDiem()));
            mHolder.tvTen.setText(item.getTenQuan());
            mHolder.tvDiaDiem.setText(item.getDiaChi() + ", " + item.getTenDuong()+ ", " + item.getTenQuanHuyen()+ ", " + item.getTenThanhPho());
            mHolder.imgHinh.setImageBitmap(item.getHinhAnh());
        }
    }

    @Override
    public int getItemCount() {
        return 1 + tvCategory.length + listODau.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_HEADER;
        else if (position <= 10)
            return TYPE_CATEGORY;
        else
            return TYPE_DATA;
    }
}
