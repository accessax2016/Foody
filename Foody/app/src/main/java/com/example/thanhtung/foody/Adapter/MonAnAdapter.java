package com.example.thanhtung.foody.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thanhtung.foody.Model.AnGi;
import com.example.thanhtung.foody.R;

import java.util.List;

/**
 * Created by Thanh Tung on 4/9/2017.
 */

public class MonAnAdapter extends RecyclerView.Adapter< RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_CATEGORY = 1;
    private static final int TYPE_DATA = 2;

    private Context context;
    private int imgHeader;
    private int[] imgCategory;
    private String[] tvCategory;
    private List<AnGi> listAnGi;

    public MonAnAdapter(Context context, int imgHeader, int[] imgCategory, String[] tvCategory, List<AnGi> listAnGi) {
        this.context=context;
        this.imgHeader=imgHeader;
        this.imgCategory=imgCategory;
        this.tvCategory=tvCategory;
        this.listAnGi=listAnGi;
    }

    public class HeaderItem extends RecyclerView.ViewHolder {

        private ImageView img_quangcao;
        public HeaderItem(View itemView) {
            super(itemView);

            img_quangcao = (ImageView) itemView.findViewById(R.id.imgHeader);
        }
    }

    public class CategoryItem extends RecyclerView.ViewHolder {

        private ImageView img_category;
        private TextView tv_category;
        public CategoryItem(View itemView) {
            super(itemView);

            img_category = (ImageView) itemView.findViewById(R.id.imgCategory);
            tv_category = (TextView) itemView.findViewById(R.id.tvCategory);
        }
    }

    public class DataItem extends RecyclerView.ViewHolder {
        private ImageView imgHinhMonAn;
        private TextView tvTenMonAn;
        private TextView tvTenQuanMonAn;
        private TextView tvDiaChiQuanMonAn;

        public DataItem(View itemView) {
            super(itemView);
            imgHinhMonAn = (ImageView) itemView.findViewById(R.id.imgHinhMonAn);
            tvTenMonAn = (TextView) itemView.findViewById(R.id.tvTenMonAn);
            tvTenQuanMonAn = (TextView) itemView.findViewById(R.id.tvTenQuanMonAn);
            tvDiaChiQuanMonAn = (TextView) itemView.findViewById(R.id.tvDiaChiQuanMonAn);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_main_header, parent, false);

            viewHolder = new HeaderItem(view);
        } else if (viewType == TYPE_CATEGORY){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_main_category, parent, false);
            viewHolder = new CategoryItem(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_main_data_2, parent, false);
            viewHolder = new DataItem(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeaderItem) {
            HeaderItem mHolder = (HeaderItem)holder;
            mHolder.img_quangcao.setImageResource(imgHeader);
        } else if (holder instanceof CategoryItem){
            CategoryItem mHolder = (CategoryItem)holder;
            mHolder.img_category.setImageResource(imgCategory[position - 1]);
            mHolder.tv_category.setText(tvCategory[position - 1]);
        } else {
            DataItem mHolder = (DataItem) holder;
            AnGi item = listAnGi.get(position - tvCategory.length - 1);
            mHolder.imgHinhMonAn.setImageBitmap(item.getHinhAnh());
            mHolder.tvTenMonAn.setText(item.getTenMonAn());
            mHolder.tvTenQuanMonAn.setText(item.getTenQuan());
            mHolder.tvDiaChiQuanMonAn.setText(item.getDiaChi() + ", " + item.getTenDuong()+ ", " + item.getTenQuanHuyen()+ ", " + item.getTenThanhPho());

        }
    }

    @Override
    public int getItemCount() {
        return 1 + tvCategory.length + listAnGi.size();
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
