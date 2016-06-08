package com.example.apoorvan.spider_appdev1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView dispcount = (TextView) findViewById(R.id.textView_click);
        Button buttoncount = (Button) findViewById(R.id.button_click);

        buttoncount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                dispcount.setText("COUNT:" + count);

            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
    }

}