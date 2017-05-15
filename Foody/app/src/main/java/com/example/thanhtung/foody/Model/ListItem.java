package com.example.thanhtung.foody.Model;

import java.util.ArrayList;

/**
 * Created by Thanh Tung on 4/3/2017.
 */

public class ListItem {
    private String mName;
    private int mImageView;

    public ListItem(String name, int ImageView) {
        mName = name;
        mImageView = ImageView;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getmImageView() {
        return mImageView;
    }

    public void setImageView(int mImageView) {
        this.mImageView = mImageView;
    }


    public static ArrayList<ListItem> createListItem(String[] danhsach, int dodai, int[] hinh) {
        ArrayList<ListItem> temp = new ArrayList<ListItem>();
//        int[] hinh={ R.drawable.mnod01, R.drawable.mnod02, R.drawable.mnod03, R.drawable.mnod04,
//                R.drawable.mnod05, R.drawable.mnod06, R.drawable.mnod07, R.drawable.mnod08,};
        for (int i = 0; i < dodai; i++) {
            temp.add(new ListItem(danhsach[i], hinh[i]));
        }

        return temp;
    }
}
