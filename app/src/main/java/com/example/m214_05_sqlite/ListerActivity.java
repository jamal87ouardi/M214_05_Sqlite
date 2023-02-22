package com.example.m214_05_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import java.util.List;



public class ListerActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.lv);
        DB db = new DB(getApplicationContext());

        List<Molinet> molinets = db.get_All();

        Adapter ma = new Adapter(molinets,getApplicationContext(),R.layout.item);

        listView.setAdapter(ma);

    }
}