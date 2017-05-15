package com.example.thanhtung.foody.Tab_Fragment;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.thanhtung.foody.Adapter.DoiThanhPhoAdapter;
import com.example.thanhtung.foody.Database;
import com.example.thanhtung.foody.Model.ThanhPho;
import com.example.thanhtung.foody.R;

import java.util.ArrayList;

public class PhanChonThanhPho extends Activity {

    public static int MaThanhPho=0;
    public static String TenThanhPho="TP.HCM";

    final String DATABASE_NAME="QuanLyFoodyDB.sqlite";
    SQLiteDatabase database ;

    Button btnXong;
    ImageButton btnQuayLai;
    ListView listView;
    ArrayList<ThanhPho> list;
    DoiThanhPhoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chonthanhpho_main);

        btnXong = (Button) findViewById(R.id.btnXongThanhPho);
        btnQuayLai = (ImageButton)  findViewById(R.id.btnQuayLaiThanhPho);

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView = (ListView) findViewById(R.id.listChonThanhPho);
        list = new ArrayList<ThanhPho>();
        fillData();
        adapter = new DoiThanhPhoAdapter(this, list);
        listView.setAdapter(adapter);

        //adapter.notifyDataSetChanged();
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        // set sự kiện cho item của listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                MaThanhPho = list.get(position-1).getMaTP();
                TenThanhPho = list.get(position-1).getTenTP();

                listView.smoothScrollToPosition(position-1);
                adapter.notifyDataSetChanged();
            }
        });

        //Click theo MaThanhPho(cong 1 vi id trong SQLite bat dau tu 0)
        listView.performItemClick(listView, MaThanhPho+1, listView.getItemIdAtPosition(MaThanhPho+1));

    }
    private void fillData()
    {
        database = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor = database.rawQuery("Select * from ThanhPho",null);
        list.clear();
        for(int i=0;i<cursor.getCount();i++)
        {
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String ten = cursor.getString(1);
            list.add(new ThanhPho(id,ten));
        }

    }
    // 2.0 and above
    @Override
    public void onBackPressed() {
        finish();
    }

}
