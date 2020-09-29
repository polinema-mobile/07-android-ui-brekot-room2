package com.example.interaksi_pengguna;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView editTanggalLahir, editNama, editNim;
    Calendar calendar;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTanggalLahir = (TextView)findViewById(R.id.editTanggalLahir);

        editTanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar=Calendar.getInstance();
                int hari =calendar.get(Calendar.DAY_OF_MONTH);
                int bulan =calendar.get(Calendar.MONTH);
                int tahun =calendar.get(Calendar.YEAR);

                datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mhari, int mbulan, int mtahun) {
                        editTanggalLahir.setText(mhari+"/"+(mbulan+1)+"/"+mtahun);
                    }
                }, hari, bulan, tahun);
                datePickerDialog.show();
            }
        });
    }
}