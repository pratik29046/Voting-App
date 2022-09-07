package com.app.voting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    Button b1, b2;
    EditText e1, e2, e3, e4;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;
    UserInfo userInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b2 = findViewById(R.id.b2);
        b1 = findViewById(R.id.b1);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserInfo");
        userInfo = new UserInfo();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = e1.getText().toString().toLowerCase(Locale.ROOT);
                String Password = e2.getText().toString().toLowerCase(Locale.ROOT);
                String Email = e3.getText().toString().toLowerCase(Locale.ROOT);
                String Phone = e4.getText().toString().toLowerCase(Locale.ROOT);

                if (TextUtils.isEmpty(Username) && TextUtils.isEmpty(Password) && TextUtils.isEmpty(Email) && TextUtils.isEmpty(Phone)) {
                    Toast.makeText(getApplicationContext(), "Please add some data.", Toast.LENGTH_SHORT).show();

                } else {
                    addDatatoFirebase(Username, Password, Email, Phone);
                    Log.d("TAG", "onClick: "+Username+" "+Password+"  "+Email+"  "+Phone);
                }

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void addDatatoFirebase(String Username, String Password, String Email,String Phone) {
        userInfo.setUsername(Username);
        userInfo.setPassword(Password);
        userInfo.setEmail(Email);
        userInfo.setPhone(Phone);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                databaseReference.setValue(userInfo);
                databaseReference.child(Username).setValue(userInfo);
                Log.d("TAG", "onDataChange: "+userInfo);
                Toast.makeText(getApplicationContext(), "data added", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });

    }
}