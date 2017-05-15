package com.example.thanhtung.foody.BottomBar.ThongBao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanhtung.foody.R;

/**
 * Created by Thanh Tung on 4/10/2017.
 */

public class ThongBao extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.thongbao_main, container, false);

        return v;
    }
}
