package com.example.interaksi_pengguna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView datanama;
    TextView datanim;
    TextView datatgl;
    TextView datajk;
    TextView datajurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        datanama=(TextView)findViewById(R.id.datanama);
        datanim=(TextView)findViewById(R.id.datanim);
        datatgl=(TextView)findViewById(R.id.datatgl);
        datajk=(TextView)findViewById(R.id.datajk);
        datajurusan=(TextView)findViewById(R.id.datajurusan);

        datanama.setText(getIntent().getStringExtra("data1"));
        datanim.setText(getIntent().getStringExtra("data2"));
        datatgl.setText(getIntent().getStringExtra("data3"));
        datajk.setText(getIntent().getStringExtra("data4"));
        datajurusan.setText(getIntent().getStringExtra("data5"));

    }
}