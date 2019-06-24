package com.pankaj.waterwala_systemapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiptPage extends AppCompatActivity {
    TextView tv_Date,tv_Time,txtcans,txttotal,orderid;
    Button place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_page);

        tv_Date=findViewById(R.id.tv_Date);
        tv_Time=findViewById(R.id.tv_Time);
        txtcans=findViewById(R.id.txtcans);
        txttotal=findViewById(R.id.txttotal);
        orderid=findViewById(R.id.orderid);
        place=findViewById(R.id.place);


        String date=getIntent().getExtras().getString("DATE");
        tv_Date.setText(date);

        String from=getIntent().getExtras().getString("FROM");
        String to=getIntent().getExtras().getString("TO");
        tv_Time.setText(from+"  :  "+to);

        int can=getIntent().getExtras().getInt("Cans");
        txtcans.setText(""+can);

        int total=getIntent().getExtras().getInt("Total");
        txttotal.setText(""+total);

        int order=getIntent().getExtras().getInt("Order");
        orderid.setText(""+order);


           place.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent=new Intent(ReceiptPage.this,MainActivity.class);
                   startActivity(intent);
               }
           });
    }
}
