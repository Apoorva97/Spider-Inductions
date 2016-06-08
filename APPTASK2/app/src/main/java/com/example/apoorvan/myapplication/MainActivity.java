package com.example.apoorvan.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btone =(Button)findViewById(R.id.button);
        btone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckBox Web = (CheckBox)findViewById(R.id.checkBox);
                CheckBox App = (CheckBox)findViewById(R.id.checkBox2);
                CheckBox Algo = (CheckBox)findViewById(R.id.checkBox3);


                String Name,Rollno;
                EditText usernameEditText = (EditText) findViewById(R.id.editText_Name);
                Name = usernameEditText.getText().toString();
                EditText RollnoEditText = (EditText) findViewById(R.id.editText_Rno);
                Rollno = RollnoEditText.getText().toString();
                int p_chk =0;
                if((Web.isChecked())||(App.isChecked())||(Algo.isChecked())) {
                    p_chk = 1;
                }
                if(Name.matches(""))
                {
                    Toast.makeText(getApplicationContext(),"You have not entered your name",Toast.LENGTH_SHORT).show();
                }
                else if(Rollno.matches(""))
                {
                    Toast.makeText(getApplicationContext(),"You have not entered your Roll Number",Toast.LENGTH_SHORT).show();
                }
                else if(p_chk==0)
                {
                    Toast.makeText(getApplicationContext(),"You have not chosen any profile",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(),Activity2.class);
                    intent .putExtra("NAME",Name);
                    startActivity(intent);
                }
        }
    });
}
}
