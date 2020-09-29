package com.example.interaksi_pengguna;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView editTanggalLahir;
    Calendar calendar;
    DatePickerDialog datePickerDialog;

    Button button;
    EditText editNama,editNim;
    RadioButton radioButton;
    RadioGroup radioGroup;
    Spinner spinnerJurusan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        button=findViewById(R.id.button);
        editNama = (EditText) findViewById(R.id.editNama);
        editNim = (EditText) findViewById(R.id.editNim);
        spinnerJurusan = (Spinner) findViewById(R.id.spinnerJurusan);

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



        editNama=(EditText)findViewById(R.id.editNama);
        editNim=(EditText)findViewById(R.id.editNim);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        spinnerJurusan =(Spinner)findViewById(R.id.spinnerJurusan);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton;
        radioButton = (RadioButton) findViewById(selectedId);
        switch (view.getId()){
            case R.id.button:
                Intent sendData = new Intent(MainActivity.this,MainActivity2.class);
                sendData.putExtra("data1", editNama.getText().toString());
                sendData.putExtra("data2", editNim.getText().toString());
                sendData.putExtra("data3", editTanggalLahir.getText().toString());
                sendData.putExtra("data4", radioButton.getText().toString());
                sendData.putExtra("data5", spinnerJurusan.getSelectedItem().toString());

                startActivity(sendData);
                break;
        }
    }


}