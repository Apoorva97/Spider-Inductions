package com.example.apoorvan.slideshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
    Button button,b;
    Spinner spinner;
    String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);
        button=(Button)findViewById(R.id.button1);
        b=(Button)findViewById(R.id.button);
        text=spinner.getSelectedItem().toString();
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,slideshow.class);
                intent.putExtra("Track",text);
                startActivity(intent);

            }
        });
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,proxsensor.class);
                intent1.putExtra("Track",text);
                startActivity(intent1);

            }
        });
    }

}