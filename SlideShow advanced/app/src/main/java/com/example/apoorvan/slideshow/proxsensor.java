package com.example.apoorvan.slideshow;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class proxsensor extends Activity implements SensorEventListener {
    ViewFlipper viewFlipper;
    TextView text;
    Button enable,disable;
    SensorManager sm;
    Sensor sense;
    MediaPlayer mySound1,mySound2,mySound3,mySound4,mySound5;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prox_sensor);
        mySound1= MediaPlayer.create(this,R.raw.beat);
        mySound2=MediaPlayer.create(this,R.raw.beautiful);
        mySound3=MediaPlayer.create(this,R.raw.cool);
        mySound4=MediaPlayer.create(this,R.raw.joy);
        mySound5=MediaPlayer.create(this,R.raw.landscape);
        Intent intent=getIntent();
        str= intent.getStringExtra("Track");
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sense=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener( this,sense,SensorManager.SENSOR_DELAY_NORMAL);
        enable=(Button)findViewById(R.id.button2);
        disable=(Button)findViewById(R.id.button3);
        disable.setEnabled(false);
    }
    public void playMusic(View view) {
        if(str.equals("Track1"))
            mySound1.start();
        else if(str.equals("Track2"))
            mySound2.start();
        else if(str.equals("Track3"))
            mySound3.start();
        else if(str.equals("Track4"))
            mySound4.start();
        else mySound5.start();

    }


    public void stopMusic(View view) {
        if(str.equals("Track1"))
            mySound1.pause();
        else if(str.equals("Trac2"))
            mySound2.pause();
        else if(str.equals("Track3"))
            mySound3.pause();
        else if(str.equals("Track4"))
            mySound4.pause();
        else mySound5.pause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
     enable.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             enable.setEnabled(false);
             disable.setEnabled(true);
         }
     });
       disable.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                enable.setEnabled(true);
               disable.setEnabled(false);
           }
       });
        if(disable.isEnabled()){
            viewFlipper.showNext();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
