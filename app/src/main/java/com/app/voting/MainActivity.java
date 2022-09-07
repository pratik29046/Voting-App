package com.app.voting;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    EditText e1, e2;
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;
    UserInfo userInfo;
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(getApplicationContext());
        b2 = findViewById(R.id.b2);
        b1 = findViewById(R.id.b1);
        e1 = findViewById(R.id.edit1);
        e2 = findViewById(R.id.edit2);

//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference("UserInfo");
        databaseReference = FirebaseDatabase.getInstance().getReference();


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = e1.getText().toString().toLowerCase(Locale.ROOT);
                String password = e2.getText().toString().toLowerCase(Locale.ROOT);

                if (username.equals("admin") && password.equals("admin")) {
                    Intent i = new Intent(getApplicationContext(), MainActivity4.class);
                    startActivity(i);
                    Log.d("TAG", "onClick: " + username);
                    Log.d("TAG", "onClick: " + password);
                    e1.setText("");
                    e2.setText("");

                } else{
                    databaseReference=FirebaseDatabase.getInstance().getReference().child("UserInfo").child(username);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            ArrayList<String> list=new ArrayList<>();
                            for(DataSnapshot snapshot1:snapshot.getChildren()){
                                list.add(snapshot1.getValue().toString());
                            }
                            Log.d("TAG", "onDataChange: "+list);

                            String us=list.get(3).trim();
                            String pass=list.get(1).trim();

                            Log.d("TAG", "onDataChange: "+us);
                            Log.d("TAG", "onDataChange: "+pass);
                            if(username.equals(us) && password.equals(pass)){
                                Intent i=new Intent(getApplicationContext(),MainActivity3.class);
                                startActivity(i);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }

                    });

                }

            }

        });

    }

//    public void writeNewUser(String Username, String Password) {
//        UserInfo1 user = new UserInfo1(Username, Password);
//        databaseReference.child("users").child(Username).setValue(user);
//        databaseReference.child("users").child(Username).child("username").setValue(Username);
//
//    }



}