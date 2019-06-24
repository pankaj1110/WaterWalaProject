package com.pankaj.waterwala_systemapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Water_Type extends AppCompatActivity {

    Button btn_Ok;
    RadioGroup rg_Demo;
    RadioButton rb_Bisleri,rb_Normal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_type);

        rb_Bisleri=findViewById(R.id.rb_Bisleri);
        rb_Normal=findViewById(R.id.rb_Normal);
        btn_Ok = findViewById(R.id.btn_Ok);
        rg_Demo = findViewById(R.id.rg_Demo);

        rg_Demo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (rb_Bisleri.isChecked()) {
//                    Toast.makeText(context, "Bislari", Toast.LENGTH_SHORT).show();
//                } else
//                    {
//                    Toast.makeText(context, "Normal", Toast.LENGTH_SHORT).show();
//
//                }
            }
        });

        btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id= rg_Demo.getCheckedRadioButtonId();
                Intent intent=new Intent(Water_Type.this,MainActivity.class);

                if(id==R.id.rb_Bisleri)
                {
                    intent.putExtra("Name","Bisleri");
                    setResult(1,intent);
                    finish();
                }
                else
                {
                    intent.putExtra("Name","Normal");
                    setResult(1,intent);
                    finish();
                }

            }

        });

    }
}
