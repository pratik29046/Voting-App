package com.app.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    TextView t1, t2, t3, t4;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);
        t3 = findViewById(R.id.text3);
        t4 = findViewById(R.id.text4);

        SharedPreferences sp = getSharedPreferences("your_prefs", 0);
        int myIntValue = sp.getInt("your_int_key", 0);

        SharedPreferences sp2 = getSharedPreferences("your_prefs2", 0);
        int myIntValue2 = sp2.getInt("your_int_key", 0);

        SharedPreferences sp3 = getSharedPreferences("your_prefs3", 0);
        int myIntValue3 = sp3.getInt("your_int_key", 0);

        SharedPreferences sp4 = getSharedPreferences("your_prefs4", 0);
        int myIntValue4 = sp4.getInt("your_int_key", 0);


//        Intent intent = getIntent();
//        String C1 = intent.getStringExtra("ch1");
//        String C2 = intent.getStringExtra("ch2");
//        String C3 = intent.getStringExtra("ch3");
//        String C4 = intent.getStringExtra("ch4");
//
//
        t1.setText("Candidate 1 Vote Count " + myIntValue);
        t2.setText("Candidate 2 Vote Count " + myIntValue2);
        t3.setText("Candidate 3 Vote Count " + myIntValue3);
        t4.setText("Candidate 4 Vote Count " + myIntValue4);


//        t2.setText(C2);
//        t3.setText(C3);
//        t4.setText(C4);

    }
}