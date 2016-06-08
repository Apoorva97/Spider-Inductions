package com.example.apoorvan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txt = (TextView)findViewById(R.id.txt);
        TextView t =(TextView)findViewById(R.id.time);
        Intent intent = getIntent();
        String n =intent.getStringExtra("NAME");
        txt.setText("THANK YOU "+n);

        SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyhhmmss");
        String format = s.format(new Date());

        t.setText(format);

        Button b =(Button)findViewById(R.id.button_back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });
    }

}
