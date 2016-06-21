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
    Button button;
    Spinner spinner;
    String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);
        button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                text=spinner.getSelectedItem().toString();
                Intent intent=new Intent(MainActivity.this,slideshow.class);
                intent.putExtra("Track",text);
                startActivity(intent);

            }
        });
    }

}