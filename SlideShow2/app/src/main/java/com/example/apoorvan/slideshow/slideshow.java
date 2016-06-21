package com.example.apoorvan.slideshow;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class slideshow extends Activity{
    private TextView txtStatus;
    MediaPlayer mySound1,mySound2,mySound3,mySound4,mySound5;
    String str;
    int num;
    TextView text;
    TextView t;
    TextView timer;
    long startTime=0;
    private boolean Running=true;
    private ImageView imageView;
    int i=0;
    int imgid[]={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,
            R.drawable.img7,R.drawable.img8};
    Handler timerHandler;

    RefreshHandler refreshHandler=new RefreshHandler();

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

    class RefreshHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            slideshow.this.updateUI();
        }
        public void sleep(long delayMillis){
            this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMillis);
        }
    };
    public void updateUI(){
            if(i<imgid.length){
                imageView.setImageResource(imgid[i]);
                refreshHandler.sleep(3000);
                i++;
            }
            if(i==imgid.length){
                Running=false;
            }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slideshow);
        mySound1=MediaPlayer.create(this,R.raw.beat);
        mySound2=MediaPlayer.create(this,R.raw.beautiful);
        mySound3=MediaPlayer.create(this,R.raw.cool);
        mySound4=MediaPlayer.create(this,R.raw.joy);
        mySound5=MediaPlayer.create(this,R.raw.landscape);
        timerHandler=new Handler();
        final Runnable runnable=new Runnable() {
            @Override
            public void run() {
                while (Running) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    timerHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            num += 1;
                            timer.setText(String.valueOf(num));
                        }


                    });
                }}
                };

        new Thread(runnable).start();
        Intent intent=getIntent();
        str= intent.getStringExtra("Track");
        text=(TextView)findViewById(R.id.textView2);
        text.setText(str);
        timer=(TextView)findViewById(R.id.textView3);
        this.txtStatus=(TextView)this.findViewById(R.id.textView1);
        this.imageView=(ImageView)this.findViewById(R.id.imageView);
        updateUI();
    }

}