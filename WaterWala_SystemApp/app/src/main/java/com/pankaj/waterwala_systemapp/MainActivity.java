package com.pankaj.waterwala_systemapp;



import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText can;
    TextView et_Date,et_From,et_To,et_Type;
    Button btn_Submit;
    String dateOf,toTime ,fromTime,typeOf;
    Context context=this;
    final int request=1;
    int total,Can,OrderId=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Date=findViewById(R.id.et_Date);
        et_From=findViewById(R.id.et_From);
        et_To=findViewById(R.id.et_To);
        et_Type=findViewById(R.id.et_Type);
        can=findViewById(R.id.can);
        btn_Submit=findViewById(R.id.btn_Submit);



        et_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                int mdate = c.get(Calendar.DAY_OF_MONTH);
                int mmonth = c.get(Calendar.MONTH);
                int myear = c.get(Calendar.YEAR);

                DatePickerDialog my = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        et_Date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        dateOf=et_Date.getText().toString();
                    }
                }, mdate, mmonth, myear);

                my.show();
            }
        });

        et_From.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR);
                int min = c.get(Calendar.MINUTE);

                TimePickerDialog tp = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        et_From.setText(hourOfDay + ":" + minute);
                        fromTime=et_From.getText().toString();

                    }
                }, hour, min, false);
                tp.show();

            }
        });

        et_To.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR);
                int min = c.get(Calendar.MINUTE);

                TimePickerDialog tm = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        et_To.setText(hourOfDay + ":" + minute);
                        toTime=et_To.getText().toString();
                    }
                }, hour, min, false);
                tm.show();

            }
        });

        et_Type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Water_Type.class);

                typeOf=et_Type.getText().toString();
                startActivityForResult(intent,request);
            }
        });



        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(context,ReceiptPage.class);

                intent.putExtra("Order",OrderId);
                intent.putExtra("DATE",dateOf);
                intent.putExtra("FROM",fromTime);
                intent.putExtra("TO",toTime);
                intent.putExtra("Cans",Can);
                intent.putExtra("Total",total);
                Toast.makeText(context, "Receipt Corrected Successfully", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data!=null)
        {
            String str=data.getExtras().getString("Name");

            String c=can.getText().toString();
            if(c!=null)
            Can=Integer.parseInt(c);


            et_Type.setText(str);
            if (str.equals("Bisleri"))
            {
                total = Can * 75;
                Toast.makeText(context, "Selected Bisleri Water", Toast.LENGTH_SHORT).show();
            }

            else
                {
                total = Can * 45;
                    Toast.makeText(context, "Selected Normal Water", Toast.LENGTH_SHORT).show();
            }
        }


    }
}