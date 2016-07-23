package com.example.apoorvan.a2048;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int[][] A = new int[4][4];
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t19,t18;
    int score=0,highscore=0;
    float x1,x2,y1,y2,MIN_DISTANCE=150;
    public static final String PREFS_NAME = "myPref";
    public static final String PREFS_KEY = "HIGHSCORE";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random randomX = new Random();

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(PREFS_KEY,highscore);

        if (sharedPreferences.contains(PREFS_KEY)) {
            highscore = sharedPreferences.getInt(PREFS_KEY, highscore);
        }


        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        t5 = (TextView) findViewById(R.id.textView5);
        t6 = (TextView) findViewById(R.id.textView6);
        t7 = (TextView) findViewById(R.id.textView7);
        t8 = (TextView) findViewById(R.id.textView8);
        t9 = (TextView) findViewById(R.id.textView9);
        t10 = (TextView) findViewById(R.id.textView10);
        t11 = (TextView) findViewById(R.id.textView11);
        t12 = (TextView) findViewById(R.id.textView12);
        t13 = (TextView) findViewById(R.id.textView13);
        t14 = (TextView) findViewById(R.id.textView14);
        t15 = (TextView) findViewById(R.id.textView15);
        t16 = (TextView) findViewById(R.id.textView16);
        t18 = (TextView) findViewById(R.id.textView17);
        t19=(TextView)findViewById(R.id.textView18);
        put(A);
        put(A);
        Display(A);
        t18.setText("HIGHSCORE: "+highscore);
    }

    public void Display(int[][] A) {
        if(highscore<=score)
        {highscore=score;
            t18.setText("HIGHSCORE: "+ highscore);}

        t1.setText(String.valueOf(A[0][0]));
        t2.setText(String.valueOf(A[0][1]));
        t3.setText(String.valueOf(A[0][2]));
        t4.setText(String.valueOf(A[0][3]));
        t5.setText(String.valueOf(A[1][0]));
        t6.setText(String.valueOf(A[1][1]));
        t7.setText(String.valueOf(A[1][2]));
        t8.setText(String.valueOf(A[1][3]));
        t9.setText(String.valueOf(A[2][0]));
        t10.setText(String.valueOf(A[2][1]));
        t11.setText(String.valueOf(A[2][2]));
        t12.setText(String.valueOf(A[2][3]));
        t13.setText(String.valueOf(A[3][0]));
        t14.setText(String.valueOf(A[3][1]));
        t15.setText(String.valueOf(A[3][2]));
        t16.setText(String.valueOf(A[3][3]));
        t18.setText("HIGHSCORE: "+ highscore);

        t19.setText("SCORE: "+ String.valueOf(score));



    }

    public int youwin(int[][] A) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (A[i][j] == 2048) {

                    return 1;
                }
            }
        }

        return 0;
    }

    public int gameover(int[][] A) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (A[i][j] == 0) {
                    return 1;
                }
                if (A[i][j] == A[i + 1][j] && i + 1 < 4) {
                    return 1;
                }
                if (A[i][j] == A[i-1][j] && i - 1 >= 0) {
                    return 1;
                }
                if (A[i][j] == A[i][j + 1] && j + 1 < 4) {
                    return 1;
                }
                if (A[i][j] == A[i][j - 1] && j - 1 >= 0) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public int check(int[][] A, int[][] B) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (A[i][j] != B[i][j]) {
                    return 1;
                }}}
        return 0;
    }

    public void put(int[][] A) {

        int m, n, i, j;
        Random random = new Random();
        m = random.nextInt(4 - 1) + 1;
        n = random.nextInt(4 - 1) + 1;
        for(i=0;i<4;i++)
            for(j=0;j<4;j++)
            if(i==m&&j==n&&A[i][j]==0) {
                    A[i][j] = 2;

                }
    }

    public void down(int[][] A) {
        byte ch;
        int i, j;
        int[][] B = new int[4][4];
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                B[i][j] = A[i][j];
            }
        }
        for (j = 0; j < 4; j++) {
            for (i = 3; i >= 0; i--) {
                if (A[i][j] == 0 && i < 4) {
                    for (int k = i - 1; k >= 0; k--) {
                        if (A[k][j] != 0) {
                            A[i][j] = A[k][j];
                            A[k][j] = 0;
                            break;
                        }
                    }
                }
                for (int k = i - 1; k >= 0; k--) {
                    if (A[k][j] == A[i][j] && k + 1 == i || A[k][j] == A[i][j] && A[k + 1][j] == 0 || A[k][j] == A[i][j] && A[k + 1][j] == 0 && A[k + 2][j] == 0) {
                        A[i][j] *= 2;
                        score += A[i][j];
                        A[k][j] = 0;
                        break;
                    }
                }
            }
        }
        if (check(A, B) != 0) {
            put(A);
        }
        Display(A);
    }

    public void up(int [][]A)
    { int[][]B=new int[4][4];
        byte ch;
        int i,j;
        for(i=0;i<4;i++)
            for(j=0;j<4;j++)
                B[i][j]=A[i][j];
        for( j=0;j<4;j++)
            for( i=0;i<4;i++)
            {if(A[i][j]==0&&i<4)
            {for(int k=i+1;k<4;k++)
                if(A[k][j]!=0)
                {A[i][j]=A[k][j];
                    A[k][j]=0;
                    break;
                }
            }
                for(int k=i+1;k<4;k++)
                    if(A[k][j]==A[i][j]&&k-1==i||A[k][j]==A[i][j]&&A[k-1][j]==0||A[k][j]==A[i][j]&&A[k-1][j]==0&&A[k-2][j]==0)
                    {A[i][j]*=2;
                        score+=A[i][j];
                        A[k][j]=0;
                        break;
                    }
            }
        if(check(A,B)!=0) {
            put(A);
        }
        Display(A);
    }


    public void right(int[][] A) {
        int[][] B = new int[4][4];
        byte ch;
        int i, j;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                B[i][j] = A[i][j];
            }
        }
        for (i = 0; i < 4; i++) {
            for (j = 3; j >= 0; j--) {
                if (A[i][j] == 0) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (A[i][k] != 0) {
                            A[i][j] = A[i][k];
                            A[i][k] = 0;
                            break;
                        }
                    }
                }
                for (int k = j - 1; k >= 0; k--) {
                   if (A[i][k] == A[i][j] && k + 1 == j || A[i][k] == A[i][j] && A[i][k + 1] == 0 || A[i][k] == A[i][j] && A[i][k + 1] == 0 && A[i][k + 2] == 0) {
                        A[i][j] *= 2;
                        score += A[i][j];
                        A[i][k] = 0;
                        break;
                    }
                }
            }
        }
        if (check(A, B) != 0) {
            put(A);
        }
        Display(A);
    }



    public void left(int[][] A) {
        int i, j;
        int[][] B = new int[4][4];
        byte ch;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                B[i][j] = A[i][j];
            }
        }
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                if (A[i][j] == 0) {
                    for (int k = j + 1; k < 4; k++) {
                        if (A[i][k] != 0) {
                            A[i][j] = A[i][k];
                            A[i][k] = 0;
                            break;
                        }
                    }
                }
                for (int k = j + 1; k < 4; k++) {
                    if (A[i][k] == A[i][j] && k - 1 == j || A[i][k] == A[i][j] && A[i][k - 1] == 0 || A[i][k] == A[i][j] && A[i][k - 1] == 0 && A[i][k - 2] == 0) {
                        A[i][j] *= 2;
                        score += A[i][j];
                        A[i][k] = 0;
                        break;
                    }
                }
            }
        }
        if (check(A, B) != 0) {
            put(A);
        }
        Display(A);
    }




    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;

            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                float Y = y2 - y1;
                float X = x2 - x1;
                if (Math.abs(X) > MIN_DISTANCE) {
                    if (x2 > x1) {

                        right(A);
                    } else {

                        left(A);
                    }
                }

                if (Math.abs(Y) > MIN_DISTANCE) {
                    if (y2 > y1) {

                        down(A);

                    } else {

                        up(A);

                    }
                }

                break;
        }

        if (youwin(A) == 1) {
            Toast.makeText(MainActivity.this, "YOU WON!!!", Toast.LENGTH_LONG).show();
        }

        if (gameover(A) != 1) {
            Toast.makeText(MainActivity.this, "YOU LOSE!!!", Toast.LENGTH_LONG).show();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    A[i][j] = 0;

                }
            }}




    return super.onTouchEvent(event);
}

    public void onStop(Bundle savedInstanceState){
        super.onStop();

    }
    public void save() {
        if(score>highscore)
            highscore=score;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PREFS_KEY, highscore);
        editor.commit();

    }

    public int getValue() {

        sharedPreferences =getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences.contains(PREFS_KEY)){
            return highscore;
        }
        return highscore;
    }

    @Override
    protected void onPause() {
        super.onPause();
        save();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getValue();
    }
}

