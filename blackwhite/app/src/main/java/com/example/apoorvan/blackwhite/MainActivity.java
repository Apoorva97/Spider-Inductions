package com.example.apoorvan.blackwhite;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {
    public int[][]A=new int [6][6];
    ImageView [][]image= new ImageView[6][6];
    int lastClicked1,lastClicked2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<6;i++)
            for(int j=0;j<6;j++)
            {
                A[i][j]=0;
            }
        image[0][0]=(ImageView)findViewById(R.id.imageView1);image[0][5]=(ImageView)findViewById(R.id.imageView6);
        image[0][1]=(ImageView)findViewById(R.id.imageView2);image[1][0]=(ImageView)findViewById(R.id.imageView7);
        image[0][2]=(ImageView)findViewById(R.id.imageView3);image[1][1]=(ImageView)findViewById(R.id.imageView8);
        image[0][3]=(ImageView)findViewById(R.id.imageView4);image[1][2]=(ImageView)findViewById(R.id.imageView9);
        image[0][4]=(ImageView)findViewById(R.id.imageView5);image[1][3]=(ImageView)findViewById(R.id.imageView10);
        image[1][4]=(ImageView)findViewById(R.id.imageView11);image[1][5]=(ImageView)findViewById(R.id.imageView12);
        image[2][0]=(ImageView)findViewById(R.id.imageView13);image[2][1]=(ImageView)findViewById(R.id.imageView14);
        image[2][2]=(ImageView)findViewById(R.id.imageView15);image[2][3]=(ImageView)findViewById(R.id.imageView16);
        image[2][4]=(ImageView)findViewById(R.id.imageView17);image[2][5]=(ImageView)findViewById(R.id.imageView18);
        image[4][2]=(ImageView)findViewById(R.id.imageView27);image[4][3]=(ImageView)findViewById(R.id.imageView28);
        image[3][0]=(ImageView)findViewById(R.id.imageView19);image[4][4]=(ImageView)findViewById(R.id.imageView29);
        image[3][1]=(ImageView)findViewById(R.id.imageView20);image[4][5]=(ImageView)findViewById(R.id.imageView30);
        image[3][2]=(ImageView)findViewById(R.id.imageView21);image[5][0]=(ImageView)findViewById(R.id.imageView31);
        image[3][3]=(ImageView)findViewById(R.id.imageView22);image[5][1]=(ImageView)findViewById(R.id.imageView32);
        image[3][4]=(ImageView)findViewById(R.id.imageView23);image[5][2]=(ImageView)findViewById(R.id.imageView33);
        image[3][5]=(ImageView)findViewById(R.id.imageView24);image[5][3]=(ImageView)findViewById(R.id.imageView34);
        image[4][0]=(ImageView)findViewById(R.id.imageView25);image[5][4]=(ImageView)findViewById(R.id.imageView36);
        image[4][1]=(ImageView)findViewById(R.id.imageView26);image[5][5]=(ImageView)findViewById(R.id.imageView35);

        Button reset=(Button)findViewById(R.id.reset);
        final Button undo=(Button)findViewById(R.id.undo);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<6;i++)
                    for(int j=0;j<6;j++)
                        A[i][j]=0;
               // Generate(A);
            }
        });

        Display(A);

        for(int i=0;i<6;i++)
            for(int j=0;j<6;j++)
            {

                final int finalI = i;
                final int finalJ = j;
                image[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Change(finalI, finalJ,A);
                        Display(A);
                        undo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Change(finalI,finalJ,A);
                                Display(A);
                            }
                        });
                    }
                });

            }

    }

    public void Change(int a,int b, int [][]A) {
        int i, j;
        if (a == 0) {
            if (b == 0) {
                if (A[0][1] == 0) A[0][1] = 1;
                else A[0][1] = 0;
                if (A[1][0] == 0) A[1][0] = 1;
                else A[1][0] = 0;
            } else if (b == 5) {
                if (A[0][4] == 0) A[0][4] = 1;
                else A[0][4] = 0;
                if (A[1][5] == 0) A[1][5] = 1;
                else A[1][5] = 0;
            } else {
                if (A[0][b - 1] == 0) A[0][b - 1] = 1;
                else A[0][b + 1] = 0;
                if (A[0][b + 1] == 0) A[0][b + 1] = 1;
                else A[0][b + 1] = 0;
                if (A[1][b] == 0) A[1][b] = 1;
                else A[1][b] = 0;
            }
        }
        if (a == 5) {
            if (b == 0) {
                if (A[5][1] == 0) A[5][1] = 1;
                else A[5][1] = 0;
                if (A[4][0] == 0) A[4][0] = 1;
                else A[4][0] = 0;
            } else if (b == 5) {
                if (A[5][4] == 0) A[5][4] = 1;
                else A[5][4] = 0;
                if (A[4][5] == 0) A[4][5] = 1;
                else A[4][5] = 0;
            } else {
                if (A[5][b - 1] == 0) A[5][b - 1] = 1;
                else A[5][b + 1] = 0;
                if (A[5][b + 1] == 0) A[5][b + 1] = 1;
                else A[5][b + 1] = 0;
                if (A[4][b] == 0) A[4][b] = 1;
                else A[4][b] = 0;

            }

        } else if (b == 0 && a != 0 && a != 5) {
            if (A[a + 1][b] == 0) A[a + 1][b] = 1;
            else A[a + 1][b] = 0;
            if (A[a - 1][b] == 0) A[a - 1][b] = 1;
            else A[a - 1][b] = 0;
            if (A[a][b + 1] == 0) A[a][b + 1] = 1;
            else A[a][b + 1] = 1;
        } else if (b == 5 && a != 0 && a != 5) {
            if (A[a + 1][b] == 0) A[a + 1][b] = 1;
            else A[a + 1][b] = 0;
            if (A[a - 1][b] == 0) A[a - 1][b] = 1;
            else A[a - 1][b] = 0;
            if (A[a][b + 1] == 0) A[a][b + 1] = 1;
            else A[a][b - 1] = 1;

        } else {
            for (i = 1; i < 5; i++) {
                for (j = 1; j < 5; j++) {
                    if (i == a && j == b) {

                        if (A[i + 1][j] == 1) A[i + 1][j] = 0;
                        else A[i + 1][j] = 1;


                        if (A[i - 1][j] == 0) A[i - 1][j] = 1;
                        else A[i - 1][j] = 0;


                        if (A[i][j + 1] == 0) A[i][j + 1] = 1;
                        else A[i][j + 1] = 0;


                        if (A[i][j - 1] == 0) A[i][j - 1] = 1;
                        else A[i][j - 1] = 0;

                    }
                }
            }
        }
    }



    public void Generate(int [][]A) {
        Random random = new Random();
        int m, p = 0, q = 0, i, j;
        for (m = 0; m < 6; m++) {
            p = random.nextInt(6);
            q = random.nextInt(6);
            Change(p, q, A);

            }
        Display(A);
            }






    public void youwin(int [][]A){
        int k=0;
        for(int i=0;i<6;i++)
            for(int j=0;j<6;j++) {
                if (A[i][j] == 1)
                    k++;
            }
        if(k==36) {
            Toast.makeText(getApplicationContext(), "YOU WIN", Toast.LENGTH_LONG).show();
            for (int i = 0; i < 6; i++)
                for (int j = 0; j < 6; j++) {
                    image[i][j].setEnabled(false);
                }
        }


    }
    public void Display(int [][]A)
    {   int id1 = getResources().getIdentifier("whit++e", "drawable", getPackageName());
        int id2 = getResources().getIdentifier("black", "drawable", getPackageName());
        image[3][3].setImageResource(id1);
        for(int i=0;i<6;i++)
            for(int j=0;j<6;j++)
                if(A[i][j]==0)
                    image[i][j].setImageResource(id2);
                else
                    image[i][j].setImageResource(id1);
    youwin(A);
    }
}
