package com.app.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button btn1;
    CheckBox ch1, ch2, ch3, ch4;
    int name1=0;
    int name2=0;
    int name3=0;
    int name4=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ch1 = findViewById(R.id.checkBox1);
        ch2 = findViewById(R.id.checkBox2);
        ch3 = findViewById(R.id.checkBox3);
        ch4 = findViewById(R.id.checkBox4);
        btn1 = findViewById(R.id.b2);


        SharedPreferences sp = getSharedPreferences("your_prefs", 0);
        int myIntValue = sp.getInt("your_int_key", 0);
        name1=myIntValue;

        SharedPreferences sp2 = getSharedPreferences("your_prefs2", 0);
        int myIntValue2 = sp2.getInt("your_int_key", 0);
        name2=myIntValue2;

        SharedPreferences sp3 = getSharedPreferences("your_prefs3", 0);
        int myIntValue3 = sp3.getInt("your_int_key", 0);
        name3=myIntValue3;

        SharedPreferences sp4 = getSharedPreferences("your_prefs3", 0);
        int myIntValue4 = sp4.getInt("your_int_key", 0);
        name4=myIntValue4;

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ch1.isChecked()) {
                    Toast.makeText(getApplicationContext(), "check1", Toast.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("your_prefs", 0);
                    SharedPreferences.Editor editor = sp.edit();
                    name1++;
                    editor.putInt("your_int_key", name1);
                    editor.apply();

                } else if (ch2.isChecked()) {
                    Toast.makeText(getApplicationContext(), "check2", Toast.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("your_prefs2", 0);
                    SharedPreferences.Editor editor = sp.edit();
                    name2++;
                    editor.putInt("your_int_key", name2);
                    editor.apply();

                } else if (ch3.isChecked()) {

                    Toast.makeText(getApplicationContext(), "check3", Toast.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("your_prefs3", 0);
                    SharedPreferences.Editor editor = sp.edit();
                    name3++;
                    editor.putInt("your_int_key", name3);
                    editor.apply();

                } else if (ch4.isChecked()) {
                    Toast.makeText(getApplicationContext(), "check4", Toast.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("your_prefs4", 0);
                    SharedPreferences.Editor editor = sp.edit();
                    name4++;
                    editor.putInt("your_int_key", name4);
                    editor.apply();
                } else if (!ch1.isChecked() && !ch2.isChecked() && !ch3.isChecked() && !ch4.isChecked()) {
                    Toast.makeText(getApplicationContext(), "not", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}