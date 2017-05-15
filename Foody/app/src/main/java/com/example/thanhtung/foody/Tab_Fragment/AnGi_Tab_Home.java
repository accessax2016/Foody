package com.example.thanhtung.foody.Tab_Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.thanhtung.foody.Adapter.MonAnAdapter;
import com.example.thanhtung.foody.FoodyRestClient;
import com.example.thanhtung.foody.Model.AnGi;
import com.example.thanhtung.foody.R;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.message.BasicHeader;

import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.danhmuc_angi;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.diadiem_angi;
import static com.example.thanhtung.foody.Fragment.AnGi_Fragment.kieudiadiem_angi;

/**
 * Created by Thanh Tung on 4/6/2017.
 */

public class AnGi_Tab_Home extends Fragment {

    SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView listView;
    private MonAnAdapter monAnAdapter;
    private int imgHeader = R.drawable.quangcao2;
    private int[] imgCategory ={R.drawable.gantoi,R.drawable.coupon,R.drawable.datchouudai,
            R.drawable.datgiaohang,R.drawable.ecard,R.drawable.gamefun,
            R.drawable.binhluan,R.drawable.blogs,R.drawable.topthanhvien,
            R.drawable.video};
    private String[] tvCategory ={"Gần tôi","Coupon","Đặt chỗ ưu đãi","Đặt giao hàng","E-card","Game & Fun","Bình luận",
            "Blogs","Top Thành Viên","Video"};
    //private ArrayList<MonAn> listMonAn;
    private ArrayList<AnGi> listAnGi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_main, container, false);

        listView = (RecyclerView)v.findViewById(R.id.rv_home);

        listView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                return position == 0 ? 2 : position <= 10 ? 1 : 1;
            }
        });
        listView.setLayoutManager(layoutManager);

        listAnGi = new ArrayList<AnGi>();
        monAnAdapter = new MonAnAdapter(getContext(), imgHeader, imgCategory, tvCategory, listAnGi);
        listView.setAdapter(monAnAdapter);
        monAnAdapter.notifyDataSetChanged();
        listView.scrollToPosition(0);

        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                getAnGi();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        return v;
    }
    ProgressDialog progressDialog;
    private void getAnGi(){
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Accept", "application/json"));
        RequestParams params = new RequestParams();
        params.put("TenDanhMuc", danhmuc_angi);
        params.put("KieuDiaDiem", kieudiadiem_angi);
        params.put("TenDiaDiem", diadiem_angi);

        FoodyRestClient angi = new FoodyRestClient();
        angi.get(getContext(), "api/AnGi/GetAnGiList", headers.toArray(new Header[headers.size()]),
                params, new JsonHttpResponseHandler() {
                    @Override
                    public void onStart() {
                        progressDialog = new ProgressDialog(getContext(), R.style.MyTheme);
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        listAnGi = new ArrayList<AnGi>();
                        //monAnAdapter = new MonAnAdapter(getContext(), imgHeader, imgCategory, tvCategory, listAnGi);

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                listAnGi.add(new AnGi(response.getJSONObject(i)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        monAnAdapter = new MonAnAdapter(getContext(), imgHeader, imgCategory, tvCategory, listAnGi);

                        listView.setAdapter(monAnAdapter);
                        monAnAdapter.notifyDataSetChanged();

                        listView.scrollToPosition(0);


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Toast.makeText(getActivity(), responseString, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();
                    }
                });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getAnGi();
    }
}
